import java.util.Scanner;


class LinkedListMid
{
    private class Node
    {
        int value;
        Node next;
        Node prev;

        public Node(int value)
        {
            this.value = value;
            next = prev = null;
        }
    }




    private Node head;
    private Node mid;
    private Node tail;
    private int len;

    public LinkedListMid()
    {
        head = mid = tail = null;
        len = 0;
    }


    public void addNode(int value)
    {
        Node newNode = new Node(value);

        if (len == 0)
            head = mid = tail = newNode;
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

            if (len%2 == 0)
                mid = mid.next;
        }
        len++;
    }


    public int removeLast() throws Exception
    {
        if (len == 0)
            throw new Exception();

        int output;

        if (len == 1)
        {
            output = tail.value;
            head = mid = tail = null;
            len--;
            return output;
        }

        
        output = tail.value;

        tail = tail.prev;
        tail.next = null;

        if (len%2 == 1)
            mid = mid.prev;

        len--;

        return output;
    }


    public void print()
    {
        if (len == 0)
        {
            System.out.println();
            return;
        }


        Node curr = tail;
        while (curr != null)
        {
            System.out.print("" + curr.value + " ");
            curr = curr.prev;
        }
        System.out.println();
    }


    public int findMiddle()
    {
        if (mid == null)
            return -1;

        
        return mid.value;
    }


    public void removeMiddle() throws Exception
    {
        if (len == 0)
            throw new Exception();


    

        if (len == 1)
            head = tail = mid = null;
        
        else if (len == 2)
        {
            head = mid = tail;
            tail.prev.next = null;
            tail.prev = null;
        }
        else
        {
            if (len%2 == 1)
            {
                mid = mid.prev;
                mid.next = mid.next.next;
                mid.next.prev = mid;
            }
            else
            {
                mid = mid.next;
                mid.prev = mid.prev.prev;
                mid.prev.next = mid;
            }
        }

        len--;
    }
}






public class Q5
{
    private static Scanner in = new Scanner(System.in);


    public static void main(String[] args) 
    {
        String[] command;
        LinkedListMid stack = new LinkedListMid();

        do
        {
            command = in.nextLine().split(" ");

            switch (command[0])
            {
                case "push":
                    stack.addNode(Integer.parseInt(command[1]));
                break;

                case "pop":
                    try { stack.removeLast(); }
                    catch (Exception e) {}
                break;

                case "print":
                    stack.print();
                break;

                case "findMiddle":
                    System.out.println(stack.findMiddle());
                break;

                case "removeMiddle":
                     try { stack.removeMiddle(); }
                     catch (Exception e) {}
                break;

                default:
                    break;
            }

        } while (!command[0].equals("finish"));

    }
}

