import java.util.*;

class BST { 

	class Node { 
		int key; 
		Node parent, left, right; 

		public Node(int item) { 
			key = item; 
			parent = left = right = null;	
		} 
	} 

	Stack stack = new Stack();
	Node root; 

 
	BST() { 
		root = null;
	} 
 
	void insert_node(int key) {		
		if (root == null) {
            root = new Node(key);
            return;
        }

        Node checking = root;
        Node p;
        do {
            p = checking;
            if (key < checking.key)
                checking = checking.left;
            else
                checking = checking.right;
        }
        while (checking != null);
        Node temp = new Node(key);
        if (key < p.key)
            p.left=temp;
        else
            p.right=temp;
        temp.parent = p;
		
	} 
	
	public void DFS(Node n)
	{
		if(n == null) return;
		if(n.right != null)
			DFS(n.right);
		if(n.left != null)
			DFS(n.left);
		stack.push(n.key);
	}
	
	

	public static void main(String[] args) { 
		BST tree = new BST(); 
		BST sortedtree = new BST(); 
		int a[] = new int[13];
		a[0] = 14;
		a[1] = 12;
		a[2] = 3;
		a[3] = 54;
		a[4] = 19;
		a[5] = 17;
		a[6] = 18;
		a[7] = 43;
		a[8] = 45;
		a[9] = 55;
		a[10] = 33;
		a[11] = 25;
		a[12] = 88;
		bubbleSort(a);
		for(int k : a) System.out.println(k);
		for(int k : a) tree.insert_node(k);
		tree.DFS(tree.root);
		System.out.println("\nPreorder Before sort: ");
		while(!tree.stack.isEmpty())
		{
			System.out.print(tree.stack.pop() +"\t");
		}
		bubbleSort(a);
		for(int k : a) sortedtree.insert_node(k);
		sortedtree.DFS(sortedtree.root);
		System.out.println("\nPreorder After sort: ");
		while(!sortedtree.stack.isEmpty())
		{
			System.out.print(sortedtree.stack.pop() +"\t");
		}
		

	} 
	
	public static void bubbleSort(int[] array) 
	{
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < array.length - j; i++) {
				if (array[i] > array[i + 1]) {
					tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}
} 
