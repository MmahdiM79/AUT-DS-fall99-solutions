class Stack(object):

   
    def __init__(self, capacity: int):
        self.__capacity__ = capacity
        self.__arr__ = [0 for _ in range(capacity)]
        self.__top__ = -1
        self.__size__ = 0
        
        
    def is_empty(self) -> bool:
        return (self.__top__ == -1)
    
    
    def push(self, value: int) -> bool:
        
        if self.__top__ == self.__capacity__-1:
            return False
        
        self.__top__ += 1
        self.__arr__[self.__top__] = value
        self.__size__ += 1
        return True
    
    
    def pop(self) -> int:
        
        if self.__top__ == -1:
            raise Exception("underflow")
        
        
        self.__size__ -= 1
        self.__top__ -= 1
        
        return self.__arr__[self.__top__+1]
        
        
        
    def values(self) -> list:
        return self.__arr__[:self.__top__+1]
        
        
    
    def __len__(self) -> int:
        return self.__size__
    
    



if __name__ == "__main__":
    
    trucks = [int(truck) for truck in input().split()[::-1]]
    hold = sorted(trucks)
    hold.reverse()
    if trucks == sorted(trucks) or trucks == hold:
        print("yes")
        exit()
    
    max_n = len(trucks)
    
    street = Stack(len(trucks))
    queue = Stack(len(trucks))
    

    

    target = 1
    while True:
        
        if (len(trucks), len(street)) == (0, 0):
            break
        
        
        if len(trucks) == 0:
            
            current = street.pop()
            
            if current == target:
                queue.push(current)
                target += 1
                continue
            
            else:
                print("no")
                exit()
                
        else: 
            current = trucks.pop()
        
        
        
        
        if current == target:
            queue.push(current)
            target += 1
            
        elif not street.is_empty():
            current2 = street.pop()
            if current2 == target:
                queue.push(current2)
                trucks.append(current)
                target += 1
            else:
                street.push(current2)
                street.push(current)
            
        else:
            street.push(current)
        
        
    if target == max_n + 1:  
        print("yes")
    else:
        print("no")
             
             
             