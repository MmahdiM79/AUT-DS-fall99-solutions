import java.util.Scanner;


class Stack
{
            /*  Fields  */

    // hold values
    Task[] arr;

    // hold the index of last value
    int top;


    public Stack(int size)
    {
        arr = new Task[size];
        top = -1;
    }


    public Task getLastValue()
    {
        return arr[top];
    }

    public void setLastValue(Task value)
    {
        arr[top] = value;
    }

    public int size()
    {
        return top + 1;
    }

    public void push(Task value) throws Exception
    {
        try
        {
            arr[++top] = value;
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new Exception("stack overflow !");
        }
    }

    public Task pop() throws Exception
    {
        try
        {
            return arr[top--];
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new Exception("stack underflow !");
        }
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }
}




class Task
{
    public String name;
    public int neededTime;
    
    public Task(String n, int t)
    {
        name = n;
        neededTime = t;
    }

    public Task()
    {
        name = "";
        neededTime = 0;
    }
}





public class Q2
{
    private static Scanner in = new Scanner(System.in);
    private static Stack tasks;
    private static int availableTime = 0;

    public static void main(String[] args) throws Exception
    {
        int n = in.nextInt();
        in.nextLine();

        tasks = new Stack(2*n);

        String[] holdToRead; 
        int costTime = 0;
        for (int i = 0; i < n; i++)
        {
            holdToRead = in.nextLine().split(" ");


            if (holdToRead[0].contains("i"))
                tasks.push(new Task(holdToRead[0], Integer.parseInt(holdToRead[1])));

            else
            {
                availableTime = Integer.parseInt(holdToRead[1]);
                while (!tasks.isEmpty() && availableTime > 0)
                {
                    costTime = tasks.getLastValue().neededTime;

                    tasks.setLastValue(new Task(tasks.getLastValue().name, tasks.getLastValue().neededTime - availableTime));

                    if (tasks.getLastValue().neededTime <= 0)
                        tasks.pop();
                    
                    availableTime -= costTime;
                }
                availableTime = 0;

                if (tasks.isEmpty())
                    System.out.println("main");
                else
                    System.out.println(tasks.getLastValue().name);
                
            }
        }
    }
}
