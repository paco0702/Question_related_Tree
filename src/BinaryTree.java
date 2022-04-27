

class BinaryTree {
    	
    	
	TreeNode root;  // root of binary tree

    	static class TreeNode{
    		
    		String data;
    		TreeNode left, right;
    		
    		
    		TreeNode(String value){
    			this.data = value;
    			left = right = null;
    		}

    		boolean isLeaf(TreeNode node) {
    			if(node.left==null && node.right == null)
    				return true;
    			else return false;
    		}
    		
    		
    	}
    	
    	
	public void preOrder() {   //it is default 
		preOrder(root);
	}
	
	void preOrder(TreeNode node) {
		if(node == null) {    // test the root
			return;
		}
		System.out.printf("%s ", node.data);
		preOrder(node.left);    // go deep to left
		preOrder(node.right);   // and then go to right to search
	}
	
	public void inOrder () {
		inOrder(root);
	}
	
	private void inOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		
		System.out.print(node.data+" "); // because you are not printing the -->
		                             // --> the node.data.left, so it will print the parent node 
		                                                                      // if the node has both null child
		inOrder(node.right);
		
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	
	
	public int countLeaves() {
		return countLeaves(root);
	}
	
	private int countLeaves(TreeNode node) {
		if(node == null)
		return 0;
		if(node.isLeaf(node)) {  // test it is a children or not, 
//			if it is a child, both left and right is null
			return 1;   
		}else {
			return countLeaves(node.left)+countLeaves(node.right);
		}
	}
	
	public int getDepth() {
		return getDepth(root);
	}

	private int getDepth(TreeNode node) {
		
		if(node == null) {
			return 0;
		}
		else if(node.isLeaf(node)== true) {
			return 1;
		}
		else {
		System.out.print(node.left.data+" ");
		int leftD =getDepth(node.left);
		
		System.out.print(node.right.data+" ");
		int rightD= getDepth(node.right);
		
		
		if(leftD>rightD) {
			return leftD+1;
		}else {
			return rightD+1;
		}
		
	}
	}
	
	
	public static void main(String [] args) {
		BinaryTree bt = new BinaryTree();
		BinaryTree.TreeNode root= new BinaryTree.TreeNode("A");
		
		bt.root = root;
		bt.root.left = new BinaryTree.TreeNode("B");
		bt.root.left.left = new BinaryTree.TreeNode("C");
		
		bt.root.left.right = new BinaryTree.TreeNode("D");
		bt.root.right = new BinaryTree.TreeNode("E");
		bt.root.right.left = new BinaryTree.TreeNode("F");
		bt.root.right.right = new BinaryTree.TreeNode("G");
		
		bt.preOrder();
		System.out.println();
		bt.inOrder();
		System.out.println();
		bt.postOrder();
		System.out.println();
		
		int d =bt.getDepth();
		System.out.println(d);
		System.out.println(bt.countLeaves());
	}
	
	
}
