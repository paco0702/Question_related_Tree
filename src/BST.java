import java.util.Stack;

public class BST {
	
	private static class Node{
		private int data;
		private Node left, right;
		
		public Node(int value) {
			data = value;
			left = right = null;
		}
	}
	
	private Node root;
	
	public BST() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public boolean isLeaf(Node root) {
		if(root.left == null && root.right==null) 
		{
			return true;
		}else return false;
	}
	
	public int size() {
		Node current = root;
		int size =0;
		Stack <Node> stack = new Stack<Node>();
		while(!stack.isEmpty()|| current != null) {
			if(current != null) {
				stack.push(current);
				current = current.left;  //search left first
			}else {
				size++;    // when there are no more node on the left 
				             // go to right and 
				current = stack.pop();
				current = current.right;
			}
		}
		return size;
	}
	
	public void clear() {
		root = null;
	}
	
	
	public Node search(Node root, int key) {   // search the specific node of the binary search tree
		if(root.equals(null)) {
			System.out.println("There is no element in the tree yet");
			return null;
		}else 
		if(root.data==key)                                           // the key only depend on the data key
		return root;
		else if(root.data <key) {
			// go right
			return  search(root.right, key);
		}
		else if(root.data > key) {
			// go left
			return search(root.left, key);
		}else {
			System.out.println("The element is not in this binary search tree yet");
			return null;
		}
	}
	public void insert(int key) {
		root = insert(root, key);
	}
	
	
	
	public Node insert(Node node, int key) {
		//the tree is empty, return the new node as root
		if(node ==null) {
			node = new Node (key);
			return node;
		}else
		if(node.data == key) {
			System.out.println("The inserting key is exist already, it is the root");
			return node;
		}else if(node.data <key) {
			node.right= insert(node.right, key);
		} else if(node.data > key) {
			node.left = insert (node.left , key);
		}
		
		return node ; // ?? 
	}
	
	public void deleteNode(int key) {
		root = deleteNode(root, key);
	}
	
	
	private Node deleteNode( Node node, int key) {
		if (root == null ) return root;
		
		if(node.data > key) {
			node.left = deleteNode(node.left, key);
			
		}else if(node.data < key) {
			node.right = deleteNode(node.right, key);
		
			
		}else {
			
			// test the target node has children or not 
			 if(node.left == null && root.right == null) {
				System.out.println("deleting " + key);
				return null;
			 }else if(node.left== null) {
				 System.out.println("deleting " + key);
				 return node.right;
			 }else if(node.right == null) {
				 System.out.println("deleting " + key);
				 return node.left;
			 }
			 
			 node.data = minValue (node.right);  // get the smallest value in the right sub tree
			 // and replace it
			 
			 
			 node.right = deleteNode(node.right, node.data);
			 //delete the replacement node
			 
			 System.out.println("deleting " + key);
//			 System.out.println("The node right is "+ node.right);
		}
		
		return node;
	}
	
	int minValue(Node node) {
		int minD = node.data;
		while (node.left!= null) {
			return minValue(node.left);
		}
		return minD;
	}
	
	public void inOrder () {
		inOrder(root);
	}
	
	private void inOrder(Node node) {
		if(root==null) {
			return;
		}
		try {
		inOrder(node.left);
		}catch(NullPointerException e) {
//			System.out.println("The left node is empty");
		}
		System.out.printf("%d ",node.data);
		
		try {
		inOrder(node.right);
		}catch (NullPointerException e) {
//			System.out.println("The right node is empty");
		}
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node node) {
		if(node == null) {
			return;
		}
		try {
		postOrder(node.left);
		}catch(NullPointerException e) {
			
		}
		try {
		postOrder(node.right);
		}catch (NullPointerException e) {
			
		}
		System.out.printf("%d ", node.data);
	}

	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.printf("%d ", node.data);
		try {
		preOrder(node.left);
		}catch(NullPointerException e) {
			
		}
		try {
		preOrder(node.right);
		} catch (NullPointerException e){
			
		}
	}
	
	public int getDepth() {
		return getDepth(root);
	}

	private int getDepth(Node node) {
		
		if(node == null) {
			return 0;
		}
//		else if(isLeaf(node)== true) {
//			return 1;
//		}
		else {
		int leftD =getDepth(node.left);
		
		int rightD= getDepth(node.right);
		
		
		if(leftD>rightD) {
			return leftD+1;
		}else {
			return rightD+1;
		}
		
	}
	}
}