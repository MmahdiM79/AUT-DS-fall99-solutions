


n = int(input())
ways = dict()
curr_x, curr_y = 0, 0


for _ in range(n):
    t = 0
    ways.clear()

    path = input()
    for i in range(len(path)):

        if path[i] == 'N':
            curr_y += 1
            if (curr_x, curr_y-1, curr_x, curr_y) in ways:
                t += 1
            elif (curr_x, curr_y, curr_x, curr_y-1) in ways:
                t += 1
            else:
                t += 5
                ways[(curr_x, curr_y-1, curr_x, curr_y)] = 1
                ways[(curr_x, curr_y, curr_x, curr_y-1)] = 1
            

        elif path[i] == 'S':
            curr_y -= 1
            if (curr_x, curr_y+1, curr_x, curr_y) in ways:
                t += 1
            elif (curr_x, curr_y, curr_x, curr_y+1) in ways:
                t += 1
            else:
                t += 5
                ways[(curr_x, curr_y+1, curr_x, curr_y)] = 1
                ways[(curr_x, curr_y, curr_x, curr_y+1)] = 1
            

        elif path[i] == 'E':
            curr_x += 1
            if (curr_x, curr_y, curr_x-1, curr_y) in ways:
                t += 1
            elif (curr_x-1, curr_y, curr_x, curr_y) in ways:
                t += 1
            else:
                t += 5
                ways[(curr_x, curr_y, curr_x-1, curr_y)] = 1
                ways[(curr_x-1, curr_y, curr_x, curr_y)] = 1
            

        elif path[i] == 'W':
            curr_x -= 1
            if (curr_x, curr_y, curr_x+1, curr_y) in ways:
                t += 1
            elif (curr_x+1, curr_y, curr_x, curr_y) in ways:
                t += 1
            else:
                t += 5
                ways[(curr_x, curr_y, curr_x+1, curr_y)] = 1
                ways[(curr_x+1, curr_y, curr_x, curr_y)] = 1
            
    print(t)
