package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
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
	
	private boolean add(E x, BinaryNode<E> n) {
		if(n == null) {
			n = new BinaryNode<E>(x);
			size++;
			return true;
		}
		else if(comparator.compare(x, n.element) < 0) {
			return add(x, n.left);
		}
		else if(comparator.compare(x, n.element) > 0) {
			return add(x, n.right);
		}
		else if(comparator.compare(x, n.element) < 0) {
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

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
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
