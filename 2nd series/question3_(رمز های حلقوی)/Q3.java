import java.util.ArrayList;
import java.util.Scanner;


class Ball
{
    ArrayList<Long> nums;
    int lastDigit;

    public Ball()
    {
        nums = new ArrayList<>();
        lastDigit = 0;
    }


    public int calculateDigit()
    {
        if (lastDigit < 0)
            lastDigit += nums.size();
        
        else if (lastDigit > nums.size()-1)
            lastDigit %= nums.size();

        return lastDigit;
    }
}


class Queue
{
            /*  Fields  */

    // hold values
    Ball[] arr;

    // number of the values
    int size;

    // first value index
    int head;

    // last value index
    int tail;





    public Queue(int capacity)
    {
        arr = new Ball[capacity];

        size = 0;
        head = 0;
        tail = 0;
    }




    public void enqueue(Ball value) throws Exception
    {
        if (isFull())
            throw new Exception("the object " + this.getClass() + " is full");

        
        arr[tail] = value;
        tail++;
        tail %= arr.length;
        size++;
    }


    /**
     * Remove the first value in this queue
     * 
     * @return the removed value
     * @throws exception if queue is empty
     */
    public Ball dequeue() throws Exception
    {
        if (isEmpty())
            throw new Exception("the object " + this.getClass() + " is empty");

        
        Ball output = arr[head];

        head++;
        head %= arr.length;
        size--;

        return output;
    }



    /**
     * @return the capacity of this queue
     */
    public int getCapacity() { return arr.length; }

    /**
     * @return the empty space of this queue
     */
    public int getEmptySpace() { return arr.length - size; }

    /**
     * @return the size of the queue
     */
    public int getSize() { return size; }

    /**
     * @return {@code true} if queue is empty
     */
    public boolean isEmpty() { return (size == 0); }

    /**
     * @return {@code true} if queue is full
     */
    public boolean isFull() { return (size == arr.length); }
}




public class Q3 
{
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception
    {
        String[] firstLine = in.nextLine().split(" ");
        
        int numberOfBalls = Integer.parseInt(firstLine[0]);
        int lenOfEachBall = Integer.parseInt(firstLine[1]);

        Queue q = new Queue(numberOfBalls);

        Ball hold;
        for (int i = 0; i < numberOfBalls; i++)
        {
            hold = new Ball();
            for (int j = 0; j < lenOfEachBall; j++)
                hold.nums.add(in.nextLong());
            in.nextLine();
            q.enqueue(hold);
        }


        int redBallN = in.nextInt(); in.nextLine();
        Ball redBall = new Ball();
        for (int i = 0; i < redBallN; i++)
            redBall.nums.add(in.nextLong());
        in.nextLine();

        long repeation = in.nextInt();
        in.nextLine();

        for (int i = 0; i < repeation; i++)
        {
            q.arr[q.head].lastDigit += redBall.nums.get(redBall.calculateDigit());
            
            hold = q.dequeue();
            q.enqueue(hold);

            redBall.lastDigit += 1;
        }


        Ball ball;
        do
        {
            ball = q.arr[q.head];
            System.out.print(ball.nums.get(ball.calculateDigit()));

            q.head += 1;
            q.head %= q.arr.length;
            
        }while(q.head != q.tail);

        System.out.println();
    }
}
