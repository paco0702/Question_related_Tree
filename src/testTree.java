
public class testTree {
	public static void main (String [] args)throws Exception {
//		BinaryTree bt = new BinaryTree();
//		BinaryTree.TreeNode root= new BinaryTree.TreeNode("A");
//		
//		bt.root = root;
//		bt.root.left = new BinaryTree.TreeNode("B");
//		bt.root.left.left = new BinaryTree.TreeNode("C");
//		
//		bt.root.left.right = new BinaryTree.TreeNode("D");
//		bt.root.right = new BinaryTree.TreeNode("E");
//		bt.root.right.left = new BinaryTree.TreeNode("F");
//		bt.root.right.right = new BinaryTree.TreeNode("G");
//		
//		bt.preOrder();
//		System.out.println();
//		bt.inOrder();
//		System.out.println();
//		bt.postOrder();
//		System.out.println();
//		
//		int d =bt.getDepth();
//		System.out.println(d);
//		
//		
//		// the above is setting all the Node		
//				
//		System.out.println("counting the number of leave");
//		System.out.println("number of leave is: "+ bt.countLeaves());
		
//		 do binary search tree
//		BST bst = new BST ();
//		bst.insert(3);
//		bst.insert(2);
//		bst.insert(1);
//		bst.insert(5);
//		bst.insert(4);
//		bst.insert(7);
//		bst.insert(6);
//		bst.insert(8);
////		 inOrder to show the tree
//		bst.inOrder();
//		System.out.println();
////		 postOrder to show the tree
//		
//		bst.postOrder();
//		System.out.println();
////		 preOrder to shoe the tree
//		bst.preOrder();
//		System.out.println();
//		
//		System.out.println("Try to get the depth of the tree");
//		System.out.println(bst.getDepth());
//		System.out.println();
//		
//		bst.deleteNode(5);
//		
//		bst.inOrder();
		
		// other binary tree test
		
//		BinaryTree tree = new BinaryTree();
//		
//		BinaryTree.TreeNode root = new BinaryTree.TreeNode ("1");
//		
//		tree.root = root;
//		tree.root.left = new BinaryTree.TreeNode("2");
//		tree.root.right = new BinaryTree.TreeNode("3");
//		tree.root.left.left = new BinaryTree.TreeNode("4");
//		tree.root.left.right = new BinaryTree.TreeNode("5");
//		System.out.println();
//		tree.inOrder();
//		System.out.println();
//		System.out.println("The depth of the above tree is "+tree.getDepth());
		
		
		
		
		AvlTree at = new AvlTree();
		System.out.println("Inserting 30");
		at.insert(30);
		System.out.println("Inserting 5");
		at.insert(5);
		System.out.println();
		System.out.println("Inserting 35");
		at.insert(35);
		at.inOrder();
		System.out.println();
		System.out.println("Inserting 32");
		at.insert(32);
		at.inOrder();
		System.out.println();
		
		System.out.println("Inserting 40");
		at.insert(40);
		System.out.println();
		System.out.println("Inserting 45");
		at.insert(45);
		at.inOrder();
		System.out.println();
		System.out.println("Inserting 2");
		at.insert(2);
		System.out.println("inserting 1");
		at.insert(1);
//		
//		
		
	}
}
