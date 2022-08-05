package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
  	public static void main(String[] args) {
  		BSTVisualizer visual = new BSTVisualizer("BigMountain", 200, 200);
  		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		bst.add(5);
		bst.add(2);
		bst.add(4);
		bst.add(9);
		bst.add(9);
		bst.add(6);
		bst.add(8);

  		bst.add(1);
  		bst.add(2);
  		bst.add(3);
  		bst.add(4);
  		bst.add(5);
  		bst.add(6);
  		bst.add(7);
  		
		//bst.rebuild();
		visual.drawTree(bst);
  	}
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		comparator = (e1, e2) ->  ((Comparable<E>) e1).compareTo(e2);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		this.comparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		return add(x, root);
	}
	
	private boolean add(E x, BinaryNode<E> n, BinaryNode<E> parent) {
		if(n == null) {
			size++;
			if(comparator.compare(x, parent.element) < 0) {
				parent.left = new BinaryNode<E>(x);
			}
			else if(comparator.compare(x, parent.element) > 0) {
				parent.right = new BinaryNode<E>(x);
			}
			return true;
		}
		else {
			if(comparator.compare(x, parent.element) < 0) {
				return add(x, parent.left, n);
			}
			else if(comparator.compare(x, parent.element) > 0) {
				return add(x, parent.right, n);
			}
		}
		return false;
	}
	
	private boolean add(E x, BinaryNode<E> n) {
		if(root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}

		else if(comparator.compare(x, n.element) < 0) {
			return add(x, n.left, n);
		}
		else if(comparator.compare(x, n.element) > 0) {
			return add(x, n.right, n);
		}
		else if(comparator.compare(x, n.element) == 0) {
			return false;
		}
		return false;
	}
		
	public BinaryNode<E> getRoot() {
		return root;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}
	
	private int height(BinaryNode<E> n) {
		if(n == null) {
			return 0;
		}else {
			return 1+Math.max(height(n.left), height(n.right));
		}
	}


	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(BinaryNode<E> n) {
		if(n == null) {
			return;
		}
		else if(n.left == null){
			System.out.println(n.element);
			printTree(n.right);
		}
		else {
			printTree(n.left);
			System.out.println(n.element);
			printTree(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<E>();
		toArray(root, sorted);
		this.root = buildTree(sorted, 0, sorted.size() - 1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	public void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if(n == null) {
			return;
		}
		else if(n.left == null){
			sorted.add(n.element);
			toArray(n.right, sorted);
		}
		else {
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if(first == last) {
			BinaryNode<E> newRoot = new BinaryNode<E>(sorted.get(first));
			return newRoot;
		}
		else if (last < first) {
			return null;
		}
		
		else{
			int middle = (last + first) / 2;
			E middleEle = sorted.get(middle);
			BinaryNode<E> middleNode = new BinaryNode<E>(middleEle);
			
			if(middle - 1 >= 0) { 
				middleNode.left = buildTree(sorted, first, middle - 1);
			}
			
			if(middle + 1 < sorted.size()) {
				middleNode.right = buildTree(sorted, middle + 1, last);
			}
			return middleNode;
		}
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
		
		public BinaryNode<E> getLeft(){
			return left;
		}
		
		public BinaryNode<E> getRight(){
			return right;
		}
		
		public E getElement(){
			return element;
		}
		
	}
	
}
