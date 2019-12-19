import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedList {

    public static void main(String args[])
    {
        try 
		{	
			Scanner input = new Scanner(System.in);
			
			System.out.print("Enter linked list size: ");
			int s = input.nextInt();
			
			Random rand = new Random();
			
			LinkedList l = new LinkedList(rand.nextInt(500));
			
			for(int i= 1; i<s; i++)
				l.addEnd(rand.nextInt(500));
			
			
			l.displayAll();
			
			System.out.println("\n");
			
			System.out.print("Enter the number to insert:");
			int number = input.nextInt();
			
			System.out.print("Enter the index to insert the number at:");
			int index = input.nextInt();
			
			
			l.add(index, number);
			l.displayAll();
			
			System.out.println("\n");
			
			System.out.print("Enter the digit to search: ");
			number = input.nextInt();
			
			if(l.search(number) != -1)
				System.out.println("Index for searched number is: " + l.search(number));
			else
				System.out.println("Number does not exist in the linked linked.");
			
			System.out.println("\n");
			
			System.out.print("Enter the index to remove: ");
			index = input.nextInt();
			
			l.remove(index);
			l.displayAll();
		}
		catch(InputMismatchException e)
		{
			System.out.println("**** ERROR: INCORRECT INPUT! BYE BYE USER! ****");
		} 
        
    }

    LinkedList next;
    int data;

    public LinkedList(int data)
    {
        this.data=data;
        next=null;
    }

    public void addEnd(int data)
    {
        LinkedList nextPlace= this;
        while (nextPlace.next != null)
        {
            nextPlace=nextPlace.next;
        }

        LinkedList newList = new LinkedList(data);
        nextPlace.next = newList;

    }

    public void addStart(int data)
    {
        LinkedList newList = new LinkedList(this.data);
        newList.next=next;
        next = newList;
        this.data=data;
    }

    public void add(int loc, int data)
    {
        if(loc == 0) {
            addStart(data);
            return;
        }
        LinkedList toadd = next;
        LinkedList previous = this;

        boolean triggerEnd = false;
        for(int i=0; i<loc-1; i++)
        {
            if(triggerEnd){
                System.out.println("*** ERROR: Index not found!");
                return;
            }
            if(toadd.next == null) triggerEnd = true;
            previous=toadd;
            toadd=toadd.next;

        }
        if(triggerEnd)
        {
            addEnd(data);
            return;
        }
        LinkedList newData = new LinkedList(data);
        previous.next = newData;
        newData.next=toadd;

    }
	
	public void remove(int loc)
    {
        if(loc == 0) {
            data = next.data;
			next = next.next;
            return;
        }
        LinkedList toadd = next;
        LinkedList previous = this;

        boolean triggerEnd = false;
        for(int i=0; i<loc-1; i++)
        {
            if(triggerEnd){
                System.out.println("*** ERROR: Index not found!");
                return;
            }
            if(toadd.next == null) triggerEnd = true;
            previous=toadd;
            toadd=toadd.next;

        }
        if(triggerEnd)
        {
            System.out.println("*** ERROR: Index not found!");
            return;
        }
        previous.next = toadd.next;
    }

    public int search(int num)
    {
        int index=0;
        LinkedList findingEmptyList = this;
        while(true){
            if(findingEmptyList.data == num) return index;
            if(findingEmptyList.next == null) break;
            findingEmptyList = findingEmptyList.next;
			index++;
        }
        return -1;
    }

    public void displayAll()
    {
        System.out.println("Printing Data:");
        LinkedList findingEmptyList = this;
        while(true){
            System.out.println("Data: " + findingEmptyList.data);
            if(findingEmptyList.next == null) break;
            findingEmptyList = findingEmptyList.next;
        }
    }
}