public class MaxHeap {
	private int [] list ;
	private int count = 0;
	private int maxsize;
	
	MaxHeap(int size){
		this.maxsize = size;
		this.list = new int [size];
//		this.list[0] =0; // first element is not used
	}
	
	int getParent(int x) {
		return (x+1/2)-1;
	}
	
	int getleftChild(int x) {
		return getrightChild(x)-1;
	}
	
	int getrightChild(int x) {
		return (x+1)*2;
	}
	
//	void swap(int a, int b) {
//		int n= this.list[a];
//		this.list[a] = this.list[b];
//		this.list[b] = n;
//	}
	
	
	
	
	public int delMax() { 
		if (isEmpty()) 
			return -1;
		int k = list[0]; 
		list[0] = list[count]; 
		count--;
		percolatingDown(0);
		return k;
	}
	
	public boolean insert(int k) {
		if(!isFull()) {
			list[count] = k;
		}
		
		for(int i =0 ; i<count; i++) {
			if(k== list[i]) {
				System.out.println("There is a same index ");
				return false;
			}
		}

		percolatingUp(count);
		count++;
		return true;
	}
	
	
	
	


//	void insert(int data) {
//		this.list[this.count ] = data;
//		int current = this.count;
//		while(this.list[current]>this.list[getParent(current)]) {
//			swap(current, getParent(current));
//			current = getParent(current);
//		}
//		
//		count++;
//	}
	

	private void percolatingUp(int current) {  // c
		int k = list[current]; 
		int p = current; 
		while (current >= 0 && list[p] <= k) {  // first loop is doing nothing
		// need to satisfy the condition current is in the list and child is larger than parent 
			                                 // after first loop
			list[current] = list[p];          // check current and its parent
			current = p;                 // change the last parent to be a new child
			p = getParent(p);           // change the value to be new child's parent
			System.out.println("the current index is " + current);
			System.out.println("The parent is "+p);
			if(p<0) {
				break;
			}
			}
		
		list[current] = k;
		}
	
	private void percolatingDown(int p) {
		int k = list[p];         // start with the starting point (index 0)
		System.out.println("index " + p +" value is "+ k);
		int c = p, c1, c2;        
		while (c <= count && list[c] >= k) { 
			list[p] = list[c]; 
			p = c;                  // first time do nothing
			c1 = getleftChild(p);
			System.out.println("left child is "+c1);
			c2 = getrightChild(p); 
			System.out.println("right child is "+c2);
			System.out.println("maxsize is " +maxsize);
//			c = c2 <= maxsize && list[c2] > list[c1] ? c2 : c1;
			if(c2<=maxsize) {
				if(list[c2] > list[c1]) {
					c = c2;
				}else {
					c = c1;
				}
			}
			System.out.println("c value is " +c);
			// check the right child still in range 
			// compare right and left child
			// if left > right  , put right to its parent node
			// else put left to its parent node
			
			}
		list[p] = k;
		}
	
	boolean isFull() {
		if(count == maxsize) {
			return true;
		}else 
			return false;
	}
	
	boolean isEmpty()
	{
		if(count == 1) {
			return true;
		}else 
			return false;
	}
	// need to expand the array list
	
	void print () {
		for(int i =0; i<this.maxsize; i++) {
			System.out.println(list[i]);
		}
	}
	
	public static void main(String [] args) {
		MaxHeap h = new MaxHeap(11);
		h.insert(4);
		h.insert(5);
		h.insert(10);
		h.insert(11);
		h.print();
		h.delMax();
		h.print();
	}
	
	
}
