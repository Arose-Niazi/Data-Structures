
class LinkedListQ { 
	Node front, rear; 

	public LinkedListQ() 
	{ 
		front = rear = null; 
	} 

	boolean isNull()
	{
		if(rear == null)
			return true;
		return false;
	}

	void enqueue(int key) 
	{ 

		Node temp = new Node(key); 

		if (isNull()) { 
			front = rear = temp; 
			return; 
		} 

		rear.next = temp; 
		rear = temp; 
	} 

	Node dequeue() 
	{ 
		if (front == null) 
			return null; 

		Node temp = front; 
		front = front.next; 


		if (front == null) 
			rear = null; 
		return temp; 
	} 
} 


