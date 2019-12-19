import java.util.Scanner;
 

class LinkedListC
{
    protected Node start ;
    protected Node end ;
    public int size ;
 
    public LinkedListC()
    {
        start = null;
        end = null;
        size = 0;
    }
    
	public boolean isEmpty()
    {
        return start == null;
    }
    
	public int getSize()
    {
        return size;
    }
    
	public void insertAtStart(int val)
    {
        Node node = new Node(val,null);    
        node.setNext(start);
        if(start == null)
        {            
            start = node;
            node.setNext(start);
            end = start;            
        }
        else
        {
            end.setNext(node);
            start = node;        
        }
        size++;
    }
    
	public void insertAtEnd(int val)
    {
        Node node = new Node(val,null);    
        node.setNext(start);
        if(start == null)
        {            
            start = node;
            node.setNext(start);
            end = start;            
        }
        else
        {
            end.setNext(node);
            end = node;            
        }
        size++ ;
    }
    
	public void insertAtPos(int val , int pos) 
    {
        Node node = new Node(val,null);                
        Node n = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = n.getNext() ;
                n.setNext( node );
                node.setNext(tmp);
                break;
            }
            n = n.getNext();
        }
        size++ ;
    }
    
	public void deleteAtPos(int pos)
    {    
        if (size == 1 && pos == 1)
        {
            start = null;
            end = null;
            size = 0;
            return ;
        }        
        if (pos == 1) 
        {
            start = start.getNext();
            end.setNext(start);
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getNext();
            }
            end = t;
            end.setNext(start);
            size --;
            return;
        }
        Node n = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = n.getNext();
                tmp = tmp.getNext();
                n.setNext(tmp);
                break;
            }
            n = n.getNext();
        }
        size-- ;
    }
    
	public void display()
    {
        System.out.print("\nCircular Singly Nexted List = ");
        Node n = start;
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getNext() == start) 
        {
            System.out.print(start.getData()+ "->"+n.getData()+ "\n");
            return;
        }
        System.out.print(start.getData()+ "->");
        n = start.getNext();
        while (n.getNext() != start) 
        {
            System.out.print(n.getData()+ "->");
            n = n.getNext();
        }
        System.out.print(n.getData()+ "->");
        n = n.getNext();
        System.out.print(n.getData()+ "\n");
    }
}
