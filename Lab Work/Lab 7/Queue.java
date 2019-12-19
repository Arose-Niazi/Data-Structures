import java.util.Scanner;

public class Queue {
    int size = 10;
    int queue[] = new int[size];
    int rear = 0;
    int front = 0;

    public static void main(String args[])
    {
        Queue q = new Queue();
        Scanner input = new Scanner(System.in);

        for(int i=0; i<5; i++)
        {
            System.out.print("Enter number to put in queue: ");
            q.enqueue(input.nextInt());
        }


        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Enqueue: " + 75);
        q.enqueue(75);
        System.out.println("Enqueue: " + 65);
        q.enqueue(65);

        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());

    }
    public void enqueue(int i) {
        if (rear+1 != size)
        {
            queue[rear++]=i;
        }
        else {
            System.out.println("Queue Overflow!");
        }
    }

    public int dequeue()
    {
        if(front+1 != size)
        {
            return queue[front++];
        }
        System.out.println("Queue underflow!");
        return 0;
    }

    public String toString()
    {
        return queue.toString();
    }


}
