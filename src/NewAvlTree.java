
public class NewAvlTree {
	
	class Node{
		public int key , height;
		
		Node left , right;
		
		Node(int key){
			this.key = key;
			left = right = null;
			height = 1;
		}
	}
	
	Node root;
	private static int count  =0;
	
	
	void insert (int key) {
		root = insert (root , key);
		
	}
	
	private Node insert (Node node , int key) {
		if(node == null) {
			Node N = new Node(key);
			return N;
		}else if(node.key > key) {
			node.left = insert(node.left, key);
		}else if(node.key <key) {
			node.right = insert(node.right, key);
		}else {
			return null;
		}
		setHeight ( node, max(getHeight(node.left), getHeight(node.right)));
		
		int balance = getBalance(node);
		
		if(balance > 1 && key<node.left.key) {         // LL CASE 
			
		}else if (balance >1 && key>node.left.key){    // LR CASE 
			 
		}else  if(balance <-1 && key>node.right.key) { // RR CASE 
			
		}else if(balance <-1 && key<node.right.key ) {   // RL CASE 
			
		}
		return node;
	}
	
//	public Node leftRotate (Node node) {
//		Node firstUB = node;
//		Node moveN = node.right;
//		Node cpn = moveN.left;
//		
//		
//	}
	
	void inOrder() {
		inOrder(root);
	}
	
	
	private void inOrder(Node node) {
		if(node == null) {
			return ;
		}
		inOrder(node.left);
		System.out.printf("%d ", node.key);
		inOrder(node.right);
	}
	
	public int getBalance(Node node ) {
		if(node == null) {
			return 0;
		}
		return getHeight(node.left)-getHeight(node.right);
	}
	
	public void setHeight(Node node, int height) {
		node.height = height;
	}
	
	public int getHeight (Node node) {
		return node.height ;
	}
	
	int max(int a, int b) {
		if(a > b) {
			return a;
		}else 
			return b;
	}
}
