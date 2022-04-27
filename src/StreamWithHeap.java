
public class StreamWithHeap {
	// this is based on min heap
	int [] heap;
	int count;
	int sum = 0;
	StreamWithHeap(){
		this.heap = new int [10];
		this.count = 0;
		
	}
	
	StreamWithHeap(int n) {
		this.heap = new int[n];
	}
	
	boolean isEmpty() {
		if(this.count ==0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	// return the value of parent of left or right child
	int getParent(int i) {
		if(i>0) {
			int index = (i-1)/2;
			return this.heap[index];
		}else {
			System.out.println("This node has no parent");
			return 0;
		}
	}
	
	int getLeftChild(int i) {
		int index = (2*i)+1;
		return this.heap[index];
	}
	
	int getRightChild(int i) {
		int index = (2*i)+2;
		return this.heap[index];
	}
	
	//return the index of parent or child 
	int getParentIndex(int i) {
		if(i>0) {
			int index = (i-1)/2;
			return index;
		}else {
			System.out.println("This node has no parent");
			return 0;
		}
	}
	
	int getLeftChildIndex(int i) {
		if(i<this.heap.length) {
			int index = (2*i)+1;
			return index;
		}else {
			return 0;
		}
	}
	
	int getRightChildIndex(int i) {
		if(i<this.heap.length) {
			int index = (2*i)+2;
			return index;
		}else {
			return 0;
		}
	}
	
	public void insert(int data) {
		if(isEmpty()) {
			this.heap[0] = data;
			this.sum = sum + data;
			count++;
			getMedian(count);
		}else {
			this.heap[count] = data;
			// check parent, if parent is larger 
			// rotate the parent down 
			this.sum = sum + data;
			checkValue(count);
			count++;
			getMedian(count);
		}
	}
	
	private void checkValue(int index) {
		if(index == 0) {
			return;
		}else {
			int parent = getParent(index);
			int parentIndex = getParentIndex(index);
			if(parent>this.heap[index]) {
				int kid = this.heap[index];
				this.heap[parentIndex] = kid;
				this.heap[index] = parent;
				checkValue(parentIndex);
			}
		}
	}
	
	public void printTree() {
		for(int i=0; i<this.count;i++) {
			System.out.println(this.heap[i]);
		}
	}
	
	public int getMedian(int count) {
		if(count==1) {
			System.out.println("The median is "+ this.sum);
			return this.sum;
		}else {
			System.out.println("The median is "+ (float)this.sum/count);
			return this.sum/count;
		}
	}
	public static void main(String [] args) {
		StreamWithHeap h = new StreamWithHeap();
		h.insert(5);
		h.insert(10);
		h.insert(15);
		h.insert(3);
		h.insert(13);
		h.printTree();
		
		//System.out.println(h.getParent(3));
		//System.out.println(h.getParent(4));
	}
}
