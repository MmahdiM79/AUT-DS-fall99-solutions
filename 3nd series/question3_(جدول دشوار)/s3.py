


def is_in_range(x, y):
    global m, n

    if x < 0 or y < 0:
        return False
    if x >= n or y >= n:
        return False
    if x >= m or y >= m:
        return False

    return True




def dfs(i, j):
    global matrix, visited, l, length, flag

    l += 1
    visited[i][j] = True
    for x in range(-1, 2):
        for y in range(-1, 2):

            if not is_in_range(x+j, y+i):
                continue
            if visited[y+i][x+j]:
                continue

            
            if ord(matrix[y+i][x+j]) == ord(matrix[i][j])+1:
                dfs(i+y, j+x)
    
    if l > length:
        length = l
        flag = True

    l -= 1







if __name__ == "__main__":
    
    line = input().split()
    n, m = int(line[0]), int(line[1])

    matrix = []
    for _ in range(n):
        matrix.append(input().split())

    target = input()

    falsies = [[False for _ in range(m)] for _ in range(n)]
    visited = falsies.copy()

    x_final, y_final, length, l = 0, 0, 0, 0
    flag = False
    for i in range(n):
        for j in range(m):
            if matrix[i][j] == target:
                dfs(i, j)

            if flag:
                y_final = i
                x_final = j

            visited = falsies.copy()
            l = 0
            flag = False


    print(length)
    print(y_final, x_final)

                



