
def is_in_range(y, x):
    global m, n

    if x < 0 or y < 0:
        return False
    if x >= m:
        return False
    if y >= n:
        return False

    return True





if __name__ == "__main__":
    
    line = input().split()
    n, m = int(line[0]), int(line[1])
    visited = []
    dis = []

    q = []

    
    for i in range(n):
        line = input()
        visited.append([])
        dis.append([])

        for j in range(len(line)):

            visited[i].append(False)
            dis[i].append(-1)
            
            if line[j] == 'M':
                q.append((i, j))
                visited[i][j] = True
                dis[i][j] = 0

            elif line[j] == 'X':
                visited[i][j] = True
                dis[i][j] = -1
            

    while q:
        s = q.pop(0)

        if is_in_range(s[0]-1, s[1]) and (not visited[s[0]-1][s[1]]):
            q.append((s[0]-1, s[1]))
            dis[s[0]-1][s[1]] = dis[s[0]][s[1]] + 1
            visited[s[0]-1][s[1]] = True

        if is_in_range(s[0]+1, s[1]) and (not visited[s[0]+1][s[1]]):
            q.append((s[0]+1, s[1]))
            dis[s[0]+1][s[1]] = dis[s[0]][s[1]] + 1
            visited[s[0]+1][s[1]] = True

        if is_in_range(s[0], s[1]-1) and (not visited[s[0]][s[1]-1]):
            q.append((s[0], s[1]-1))
            dis[s[0]][s[1]-1] = dis[s[0]][s[1]] + 1
            visited[s[0]][s[1]-1] = True

        if is_in_range(s[0], s[1]+1) and (not visited[s[0]][s[1]+1]):
            q.append((s[0], s[1]+1))
            dis[s[0]][s[1]+1] = dis[s[0]][s[1]] + 1
            visited[s[0]][s[1]+1] = True
        

    for i in range(n):
        print(*dis[i])




    
    


            


    