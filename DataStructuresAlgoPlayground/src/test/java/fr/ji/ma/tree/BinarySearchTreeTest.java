package fr.ji.ma.tree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
		
		bst1.insert(3);
		bst1.insert(1);
		bst1.insert(4);
		bst1.insert(2);
		bst1.insert(0);
		bst1.insert(5);
		
		System.out.println("starts inorder traversal");
		bst1.recursiveInOrderTraverse(bst1.getRoot());
		
		System.out.println("starts preorder traversal");
		bst1.recursivePreOrderTraverse(bst1.getRoot());
		
		System.out.println("starts postorder traversal");
		bst1.recursivePostOrderTraverse(bst1.getRoot());
		
		System.out.println("smallest value is " + bst1.getMinimum().getValue());
		
		System.out.println("biggest value is " + bst1.getMaxmimum().getValue());
		
		
		System.out.println(bst1.find(5) != null ? "5 is found" : "5 doesn't exist in the given BST");
		
		System.out.println(bst1.find(10) != null ? "10 is found" : "10 doesn't exist in the given BST");
	}
}
