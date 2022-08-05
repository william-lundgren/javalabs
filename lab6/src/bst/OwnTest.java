package bst;

public class OwnTest {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
		tree1.add(5);
		tree1.add(2);
		tree1.add(4);
		//tree1.add(9);
		
//		int first = tree1.getRoot().getElement();		
//		int second = tree1.getRoot().getLeft().getElement();		
//		int third = tree1.getRoot().getLeft().getRight().getElement();		
//		int fourth = tree1.getRoot().getRight().getElement();
//		
		print(tree1.getRoot().getElement());
		//print(tree1.getRoot().getRight().getElement());
		print(tree1.getRoot().getLeft().getRight().getElement());
	}
	
	public static void print() {
		System.out.println();
	}
	
	public static void print(Object message) {
		System.out.println(message);
	}
}
