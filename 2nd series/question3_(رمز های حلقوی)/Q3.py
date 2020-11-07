class Queue(object):
    
    
    def __init__(self, capacity: int):
        self.__capacity__ = capacity
        self.arr = [None for _ in range(capacity)]
        self.head = 0
        self.tail = 0
        self.__size__ = 0
        
        
    
    def enqueue(self, value: int):
        
        if self.is_full():
            return
        
        
        self.arr[self.tail] = value
        
        self.tail += 1
        self.tail %= self.__capacity__
        self.__size__ += 1
    
    
    
    def dequeue(self) -> int:
        
        if self.is_empty():
            return -1
        
        
        output = self.arr[self.head]
        
        self.head += 1
        self.head %= self.__capacity__
        self.__size__ -= 1
        
        return output
    
    
    
    def values(self) -> list:
        
        output = []
        
        h = self.head
        t = self.tail
        
        while h != t:
            output.append(self.arr[h])
            h = (h+1)%self.__capacity__
            
        return output
    
    
    
    def capacity(self) -> int:
        return self.__capacity__
    
    
    
    def empty_space(self) -> int:
        return self.capacity() - len(self)
    
    
    
    def is_empty(self) -> bool:
        return (self.__size__ == 0)
    
    
    
    def is_full(self) -> bool:
        return (self.__size__ == self.__capacity__)
        
        
        
    def __len__(self) -> int:
        return self.__size__




class Ball(object):
    
    def __init__(self, numbers: list):
        self.numbers = numbers
        self.digit_index = 0

    def calculate_digit(self) -> int:
        if abs(self.digit_index) < len(self.numbers):
            return self.digit_index
        else:
            if self.digit_index >= 0:
                self.digit_index %= len(self.numbers)
            else:
                self.digit_index = (self.digit_index%len(self.numbers)) - len(self.numbers)
        
        return self.digit_index




if __name__ == "__main__":
    
    ins = input().split()
    n_balls, balls_len = int(ins[0]), int(ins[1])
    
    balls = Queue(n_balls)
    
    for _ in range(n_balls):
        ins = [int(num) for num in input().split()]
        balls.enqueue(Ball(ins))
        
    red_ball_n = int(input())
    red_ball_nums = [int(num) for num in input().split()]
    
    red_ball = Ball(red_ball_nums)
    

    repeation = int(input())
    
    
    for _ in range(repeation):
        
        balls.arr[balls.head].digit_index += red_ball.numbers[red_ball.calculate_digit()]
        
        hold = balls.dequeue()
        balls.enqueue(hold)
        
        red_ball.digit_index += 1
        
    
    ball = balls.arr[balls.head]
    print(ball.numbers[ball.calculate_digit()], end='')
    balls.head += 1
    balls.head %= len(balls.arr)
    
    while balls.head != balls.tail:
        ball = balls.arr[balls.head]
        print(ball.numbers[ball.calculate_digit()], end='')
        balls.head += 1
        balls.head %= len(balls.arr)
    print()
    
        
