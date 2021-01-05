




def find():
    global stack
    print(1, end=' ')
    for i in stack:
        print(i+1, end=' ')

    print()
    exit()


def dfs(g, s, visited):
    global stack, n

    visited[s] = True
    stack.append(s)
    for i in range(n):
        if (g[s][i] == 1 and (not visited[i])):
            if i == n-1:
                stack.append(i)
                find()
            dfs(g, i, visited)
    stack.pop()




if __name__ == "__main__":
    
    n = int(input())
    nums = [int(num) for num in input().split()]


    g = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(len(nums)):
        g[nums[i]-1][i+1] = 1

    
    stack = []
    visited = [False] * n


    for i in range(n):
        if (g[0][i] == 1):
            dfs(g, i, visited)
        stack = []
        visited = [False] * n


    
    