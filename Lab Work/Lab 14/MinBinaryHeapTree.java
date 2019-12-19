import java.util.Random;
import java.util.Scanner;

public class MinBinaryHeapTree {
    private int[] Heap;
    private int size;

    public MinBinaryHeapTree(int maxsize)
    {
        this.size = 0;
        Heap = new int[maxsize + 1];
        for(int i=0; i<Heap.length; i++) Heap[i] = Integer.MAX_VALUE;
		Heap[0] = Integer.MIN_VALUE;
    }


    private int getParent(int n)
    {
        return n / 2;
    }

    private int getLeft(int n)
    {
        return (2 * n);
    }

    private int getRight(int n)
    {
        return (2 * n) + 1;
    }


    private boolean hasLeftChild(int n)
    {
        try {
            int x = Heap[getLeft(n)];
            if(Heap[getLeft(n)] == Integer.MAX_VALUE) return false;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        return  true;
    }

    private boolean hasRightChild(int n)
    {
        try {
            int x = Heap[getRight(n)];
            if(Heap[getRight(n)] == Integer.MAX_VALUE) return false;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        return  true;
    }
    
    private void swap(int x, int y)
    {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }


    public void insert(int element)
    {
        if (size >= Heap.length) {
            return;
        }
        Heap[++size] = element;
        int current = size;
        while (Heap[current] < Heap[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public void printElements()
    {
        for (int i=1; i <=Heap.length/2; i++) {
            try {
                boolean leaf = false;

                if(!hasLeftChild(i) && !hasRightChild(i))  leaf=true;
                System.out.println(((leaf) ? "LEAF: ":" PARENT: ") +  Heap[i]);
                if(hasLeftChild(i))
                    System.out.println("\tLEFT CHILD : " + Heap[getLeft(i)]);
                if(hasRightChild(i))
                    System.out.println("\tRIGHT CHILD :" + Heap[getRight(i)]);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Aukat sa bahir");
            }
        }
    }
	
	public boolean isMinHeap()
    {
		int parent = Integer.MIN_VALUE;
        for (int i=1; i <=Heap.length/2; i++) {
			try{
				parent = Heap[i];
				if(Heap[getLeft(i)] != Integer.MAX_VALUE)
					if(parent > Heap[getLeft(i)])
						return false;
				if(Heap[getRight(i)] != Integer.MAX_VALUE)
					if(parent > Heap[getRight(i)])
						return false;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				
			}
        }
		return true;
    }


    public static void main(String[] arg)
    {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of of random min binary to be generated: ");
		int size = input.nextInt();
        MinBinaryHeapTree minHeap = new MinBinaryHeapTree(size);
        Random r = new Random();
        for(int i=0; i<size; i++)
        {
            int x = r.nextInt(10000);
            minHeap.insert(x);
            System.out.println("Inserted " + x);
        }
        minHeap.printElements();
		System.out.println("\n\nThe following tree is "+((minHeap.isMinHeap())?"":"Not ")+ "min heap.");
    }
} 