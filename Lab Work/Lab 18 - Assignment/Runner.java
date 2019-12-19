import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main(String args[])
    {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        HashTable hashTable = new HashTable(4);
        for(int i=0; i<6; i++)
        {
            String rollno = "FA18-BSE-" + random.nextInt(100);
            System.out.println("Inserting " + rollno);
            if(!hashTable.insert(rollno))
                System.out.println("The hash table is full!!!");
            else System.out.println("Inserted");
        }

        while(true)
        {
            System.out.print("Enter roll no to check: ");
            String rollno = input.nextLine();
            if(rollno.isEmpty()) break;
            System.out.println("Location: " + hashTable.getHashIndex(rollno));
        }

    }
}
