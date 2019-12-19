public class Runner { 
	public static void main(String[] args) 
	{ 
		LinkedListQ q = new LinkedListQ(); 
		q.enqueue(10); 
		q.enqueue(20); 
		q.dequeue(); 
		q.dequeue(); 
		q.enqueue(30); 
		q.enqueue(40); 
		q.enqueue(50); 

		while(!q.isNull())System.out.println("Dequeued item is " + q.dequeue().key); 
	
	}
}