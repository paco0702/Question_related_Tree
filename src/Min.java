//package lab;
//
//public class MinHeap {
//	private int [] list ;
//	private int count = 0;
//	private int maxsize;
//	
//	MinHeap(int size){
//		this.maxsize = size;
//		this.list = new int [size];
//		this.list[0] =0; // first element is not used
//	}
//	
//	int getParent(int x) {
//		return x/2;
//	}
//	
//	int getleftChild(int x) {
//		return x*2;
//	}
//	
//	int getrightChild(int x) {
//		return x*2+1;
//	}
//	
//	void swap(int a, int b) {
//		int n= this.list[a];
//		this.list[a] = this.list[b];
//		this.list[b] = n;
//	}
//	
//	private void percolatingUp(int current) {  // c
//		int k = list[current]; 
//		int p = current; 
//		while (current > 1 && list[p] >= k) {  // first loop is doing nothing
//		// need to satisfy the condition current is in the list and child is larger than parent 
//			                                 // after first loop
//			list[current] = list[p];          // check current and its parent
//			current = p;                 // change the last parent to be a new child
//			p = getParent(p);           // change the value to be new child's parent
//			}
//		
//		list[current] = k;
//		}
//	
//	
//	public int delMin() { 
//		if (isEmpty()) 
//			return -1;
//		int k = list[1]; 
//		list[1] = list[count]; 
//		count--;
//		percolatingDown(1);
//		return k;
//	}
//	
//	
//	
//	private void percolatingDown(int p) {
//		int k = list[p];         // start with the starting point (index 1)
//		int c = p, c1, c2;        
//		while (c <= count && list[c] <= k) { 
//			list[p] = list[c]; 
//			p = c;                  // first time do nothing
//			c1 = getleftChild(p);  
//			c2 = getrightChild(p); 
//			c = c2 <= count && list[c2] < list[c1] ? c2 : c1;
//			// check the right child still in range 
//			// compare right and left child
//			// if left > right  , put right to its parent node
//			// else put left to its parent node
//			
//			}
//		list[p] = k;
//		}
//
//
////	void insert(int data) {
////		this.list[this.count ] = data;
////		int current = this.count;
////		while(this.list[current]>this.list[getParent(current)]) {
////			swap(current, getParent(current));
////			current = getParent(current);
////		}
////		
////		count++;
////	}
//	
//	public void insert(int k) {
//		if(!isFull()) {
//			count++;
//			list[count] = k;
//		}
//		
//		percolatingUp(count);
//	}
//	
//	boolean isFull() {
//		if(count == maxsize) {
//			return true;
//		}else 
//			return false;
//	}
//	
//	boolean isEmpty()
//	{
//		if(count == 1) {
//			return true;
//		}else 
//			return false;
//	}
//	// need to expand the array list
//	
//	void print () {
//		for(int i =0; i<this.maxsize; i++) {
//			System.out.println(list[i]);
//		}
//	}
//	
//	public static void main(String [] args) {
//		MinHeap h = new MinHeap(11);

//		h.print();
//	}
//}
