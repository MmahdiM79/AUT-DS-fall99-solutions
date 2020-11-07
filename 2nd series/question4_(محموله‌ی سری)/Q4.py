from math import ceil


if __name__ == "__main__":
    
    trucks = [int(truck_num) for truck_num in input().split()]
    
    current = 0
    final_position = []
    for _ in range(ceil(len(trucks)/2)):
        try:
            final_position.append(trucks.pop())
            final_position.append(trucks[current])
            current += 1
        except Exception:
            break
        
    print(*final_position)