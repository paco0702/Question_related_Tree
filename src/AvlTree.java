
class Node {
	public int key;
	private int height;
	
	Node left, right;
	
	Node(int key){
		this.key = key;
		left = right = null;
		height =1;
	}
	
	Node(){
		this(0);
		left = right = null;
		height = 1;
	}
	


	
	int getheight() {
		return this.height;
	}
	
	void setHeight(int height) {
		this.height = height;
	}
	
}

public class AvlTree {
	Node root;
	private static int count =0;
//	
//	
//	int height(Node node) {
//		if(node==null) {
//			return 0;
//		}else return node.height;
//	}
//	
//	int max(int a, int b) {
//		 if(a > b){
//			 return a;
//		 }else return b;
//	}
	
	public void insert(int key) {
		root = insert (root, key);
	}
	
	private Node insert(Node node, int key) {
		
		if(node == null) {
			
			Node N = new Node(key);
			return N;
			
		}else if(node.key > key) {
			
			node.left = insert(node.left , key);
			
		}else if(node.key < key) {
			
			node.right = insert(node.right, key);
			
		}else {
			
			System.out.println("The node has been dulipcated. ");
			
			return node;
		}
		
		//that is my method
//		if(balance(node)==false) {
//			//do rotation;
//			System.out.println("The balance of the tree is false ("+ balance(node));
//		}else 
//		System.out.println("The balance of the tree is true ("+ balance(node));
//		// AVL tree need to balance and rotate the node
		
		// the other method to do the balance
//		
		try {
			
		System.out.println("The height of "+node.key+"'s left node "+ node.left.key+ " is "+ node.left.getheight());
		System.out.println("The height of "+node.key+"'s  right node is "+ node.right.key+" is "+ node.right.getheight());
		}catch (NullPointerException e) {
			
		}
		System.out.println("setting the height of the node ");
		
		node.setHeight(1 + max(getheight(node.right), getheight(node.left)));  // update the height of node
		
		System.out.println("after setting, the height of "+node.key+" is "+ node.getheight());
	
		int balance = getBalance(node);               // get the difference between the children'node
		
		System.out.println("The difference between "+node.key+"'s children nodes is "+ balance);
		System.out.println();
		
		if(balance > 1 && key < node.left.key) {          // it is LL case 
			return rightRotate(node);
		}else if(balance > 1 && key>node.left.key) {         // it is LR case 
			
		}else if(balance < -1 && key < node.right.key) {    // it is RL case 
			
		}else if(balance <-1 && key>node.right.key ) {   // it is RR case 
			return leftRotate(node);
		}
		
		return node;
	}
	
	
	  int getBalance (Node N) {
			int rightheight ,leftheight =0;
			if(N == null) {
				return 0;
			}
			System.out.println("In ths balance stage.");
			System.out.println("This is node "+ N.key);
			
			try {
			System.out.println("The height of "+N.key+"'s left node "+ N.left.key +" is "+ N.left.getheight());
			leftheight=N.left.getheight();
			}catch(NullPointerException e) {
			System.out.println("There is not "+N.key+"'s left node");
			leftheight =0;
			}
			
			try{
				System.out.println("The height of "+N.key+"'s right node "+ N.right.key +" is "+  N.right.getheight());
				rightheight=N.right.getheight();
			}catch(NullPointerException e) {
				System.out.println("There is not "+N.key+"'s right node");
				rightheight=0;
				
			}
			System.out.println();
			return leftheight- rightheight;
		}
	  
	  
	
	public Node leftRotate (Node node) {
		Node firstUB = node;       // first unbalanced node 
		Node moveN = node.right;   // first change node
		Node cpn = moveN.left;     // the node need to change parent 
		
		System.out.println("left rotating the node " +node.key);
		moveN.left = node;
		firstUB.right = cpn;
		
		try {
			System.out.println("The height of "+firstUB.key+"'s left node "+ firstUB.left.key+ " is "+ firstUB.left.getheight());
			System.out.println("The height of "+firstUB.key+"'s right node is "+ firstUB.right.key+" is "+ firstUB.right.getheight());
			}catch (NullPointerException e) {
				
			}
		System.out.println("setting the height of the node ");
		
		node.setHeight(1 + max(getheight(firstUB.left), getheight(firstUB.right)));
		
		System.out.println("after setting, the height of "+firstUB.key+" is "+ getheight(node));
		System.out.println();
		
		
		try {
			System.out.println("The height of left node "+ moveN.left.key+ " is "+ getheight(moveN.left));
			System.out.println("The height of right node is "+ moveN.right.key+" is "+ getheight(moveN.right));
			}catch (NullPointerException e) {
				
			}
		System.out.println("setting the height of the node ");
		moveN.setHeight(1+ max(getheight(moveN.left), getheight(moveN.right)));
		System.out.println("after setting, the height of "+moveN.key+" is "+ getheight(moveN));
		System.out.println();
		
		// test the difference 
		int balance = getBalance(moveN);
		System.out.println("The difference between children nodes is "+ balance);
		
		return moveN;  // first change node become parent 
	}

	public Node rightRotate (Node node) {
		Node firstUB = node;       // first unbalanced node 
		Node moveN = node.left;   // first change node
		Node cpn = moveN.right;     // the node need to change parent 
		
		System.out.println("right rotating the node " +node.key);
		moveN.right = firstUB;
		firstUB.left = cpn;
		
		try {
			System.out.println("The height of "+firstUB.key+"'s left node "+ firstUB.left.key+ " is "+ getheight(firstUB.left));
			System.out.println("The height of "+firstUB.key+"'s right node is "+ firstUB.right.key+" is "+ getheight(firstUB.right));
			}catch (NullPointerException e) {
				
			}
		System.out.println("setting the height of the node ");
		
		node.setHeight(1 + max(getheight(firstUB.left), getheight(firstUB.right)));
		
		System.out.println("after setting, the height of "+firstUB.key+" is "+ getheight(firstUB));
		System.out.println();
		
		
		try {
			System.out.println("The height of left node "+ moveN.left.key+ " is "+ getheight(moveN.left));
			System.out.println("The height of right node is "+ moveN.right.key+" is "+ getheight(moveN.right));
			}catch (NullPointerException e) {
				
			}
		System.out.println("setting the height of the node ");
		moveN.setHeight(1+ max(getheight(moveN.left), getheight(moveN.right)));
		System.out.println("after setting, the height of "+moveN.key+" is "+ getheight(moveN));
		System.out.println();
		
		// test the difference 
		int balance = getBalance(moveN);
		System.out.println("The difference between children nodes is "+ balance);
		
		return moveN;  // first change node become parent 
	}

	
	private int max(int a, int b) {
		 if(a > b){
			 return a;
		 }else return b;
	}
	

	public int getheight(Node node) {
		try {
			return node.getheight();
		}catch(NullPointerException e) {
			return 0;
		}
	}
	
	
	
  

	//that is my method
//	
//	boolean balance(Node node) {
//		int d1 = getHeightLeft(node)-getHeightRight(node);
//		int d2 = getHeightRight(node)-getHeightLeft(node);
//		System.out.println("The difference is "+ d1 + " and " + d2 );
//		if(d1>1 || d2>1){
//			return false;
//		}else return true;
//	}
//	
//	int getHeightLeft(Node node) {
//		int height=0;
//		while (node.left!=null) {
//			node=node.left;
//			height = height +1;
//		}
//		System.out.println("The height of the left is "+ height);
//		return height;
//	}
//	int getHeightRight(Node node) {
//		int height=0;
//		while(node.right!=null) {
//			node = node.right;
//			height = height +1;
//		}
//		System.out.println("The height of the right is "+ height);
//		return height;
//	}
	
	// other way to do balance
	
	
	
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.printf("%d ", node.key);
		inOrder(node.right);
		
	}
	
	
}
