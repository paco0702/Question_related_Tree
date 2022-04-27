
public class Minheap {
	int [] list ;
	private int maxsize; 
	private int count =0;
	
	public Minheap(int size) {
		this.maxsize = size;
		this.list = new int [size];
		list [0] = Integer.MIN_VALUE;   // what is this
	}
	
	
	private int getParent(int x) {
		return x/2;
	}
	
	private int getleftChild (int x) {
		return x*2;
	}
	
	private int getrightChild (int x) {
		return x*2 +1;
	}
	
	// igrone all the leave and start with the right non leaf node
	private boolean isLeaf(int x) {
		
		if(x >= (this.maxsize /2) && x<= this.maxsize) {
			return true;
		}else {
			return false;
		}
	}
	
	public void swap(int a, int b) {
			int n = list[a];
			list[a] = list [b];
			list [b] = n;
		
	}
	
	
	void insert (int data) {
//		if(this.count>=this.maxsize) {
//			System.out.println("The list is full");
//			return;
//		}else if(isEmpty() == true) {
//			list[0] = data; 
//		}else {
//			
//		}
		list[count]=data;
		System.out.println(count);
		int current = count;
		System.out.println(list[current]);
		
		while(list[current]<list[getParent(current)]) {
			swap(current, getParent(current));
			current = getParent(current);
		}
		count++;
	}
	
	
	boolean isEmpty() {
		if(count ==0) {
			return true;
		}else 
			return false;
	}
	
	public static void main(String [ ] args) {
		Minheap  h = new Minheap (10);
		h.insert(10);
	}
}
