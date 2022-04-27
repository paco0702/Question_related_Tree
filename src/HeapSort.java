
public class HeapSort {
	int count =1;
	int [] list;
	int maxsize;
	
	HeapSort(int size){
		this.maxsize= size;
		list = new int [size];
		list [0] = 0;
	}
	
	private int getParent(int x) {
		return x/2;
		
	}
	
	private int getLeftChild(int x) {
		return x*2;
	}
	
	private int getRightChild(int x) {
		return x*2 +1;
	}
	
	
	
	boolean isFull() {
		if( count == maxsize ) {
			return true;
		}else return false;
	}
	
	void insert(int index, int data) {
		if(isFull() == false) {
			list[index] = data;
		}
		bubbleUp(count);
		count++;
	}
	
	void bubbleUp(int current) {
		int c = list[current];  // save the current(original) data 
		int p = current;  // save the current index
		while(current > 1 && list[p]>=c) {   
			// after first loop
			// check  parent index data > original index data
			// if yes, parent data = child data, child data moved up
			// the index move to parent index, continues checking
			list [current] = list [p];  
			current = p;
			p = getParent(p);
		}
		list [current] = c;
	}
	
	void print () {
		for(int i = 1; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}

	
	boolean isEmpty() {
		if(count ==1) {
			return true;
		}else 
			return false;
	}
	int delMin() {
		if(isEmpty()==true)
			return -1;
		int k= list[1];   // return the last element
		list [1] = list[count-1];  // put the last element into the top
		count --;
		bubbleDown(1);  // and then bubble down
		return k;
	}
	
	void bubbleDown(int current) {
		int c = list[current];
		int p = current, leftchild, rightchild;
		
		while(p<= count && list[p] <= c) {
			list [current] = list [p];
			current = p; 
			leftchild = getLeftChild(p);
			rightchild = getRightChild(p);
			if(p<=count) {
			if(leftchild<maxsize && rightchild < maxsize ) {
				if(list[leftchild] < list[rightchild]) {
					p = leftchild;
				}
				else {
					p = rightchild;
				}
			}else if(leftchild>maxsize && rightchild <= maxsize) {
				p = rightchild;
				}else {
					p = leftchild;
				}
			}
		list[current] = c;
	}
	}
	
	public static void sort (int [] data) {
		HeapSort h =new HeapSort(data.length+1);
		for(int i = 1 ; i<h.list.length ;i++) {
			h.insert(i, data[i-1]);
		}
		

		System.out.println();
		for(int i = 1 ; i<h.list.length ;i++) {
		System.out.print(h.delMin()+" ");
		}
	}
	
	public static void main(String [] args ) {
		int [] data = new int [10];
		data [0] = 16;
		data [1] = 3;
		data [2] = 4;
		data [3] = 10;
		data [4] = 5;
		data [5] = 8;
		data [6] = 25;
		data [7] = 46;
		data [8] = 33;
		data [9] = 11;
		
		sort(data);
	}
	
}
