package bst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBinarySearchTree {
	private BinarySearchTree<Integer> tree1;
	private BinarySearchTree<Integer> tree2;
	private BinarySearchTree<String> tree3;

	@BeforeEach
	void setUp() throws Exception {
		tree1 = new BinarySearchTree<Integer>();
		tree2 = new BinarySearchTree<Integer>((p1, p2) -> p2 - p1);
		tree3 = new BinarySearchTree<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree1 = null;
	}
	
	@Test
	void testAdd() {
		tree1.add(2);
		assertEquals(2, tree1.getRoot().getElement(), 2, "Root is not set correctly");
		tree1.add(3);
		assertEquals(3, tree1.getRoot().getRight().getElement(), "Root doesnt get right children properly");
		tree1.add(1);
		assertEquals(1, tree1.getRoot().getLeft().getElement(), "Root doesnt get left children properly");
		tree1.add(4);
		assertEquals(4, tree1.getRoot().getRight().getRight().getElement(), "Root doesnt get right right children properly");
	}

	@Test
	void testAddOrder() {
		tree1.add(5);
		tree1.add(2);
		tree1.add(4);
		tree1.add(9);
		
		int first = tree1.getRoot().getElement();		
		int second = tree1.getRoot().getLeft().getElement();		
		int third = tree1.getRoot().getLeft().getRight().getElement();		
		int fourth = tree1.getRoot().getRight().getElement();
		
		assertEquals(5, first, "First is incorrect");
		assertEquals(2, second, "Second is incorrect");
		assertEquals(4, third, "Third is incorrect");
		assertEquals(9, fourth, "Fourth is incorrect");
	}
	
	@Test
	void testDoublesAdd() {
		tree1.add(5);
		boolean res = tree1.add(5);
		assertEquals(false, res, "Could add duplicates.");
	}
	
	@Test
	void testAddOrderCustomComparator() {
		boolean res1 = tree2.add(5);
		boolean res2 = tree2.add(2);
		boolean res3 = tree2.add(4);
		boolean res4 = tree2.add(9);
		
		int first = tree2.getRoot().getElement();		
		int second = tree2.getRoot().getRight().getElement();		
		int third = tree2.getRoot().getRight().getLeft().getElement();		
		int fourth = tree2.getRoot().getLeft().getElement();
		
		assertEquals(5, first, "First is incorrect");
		assertEquals(2, second, "Second is incorrect");
		assertEquals(4, third, "Third is incorrect");
		assertEquals(9, fourth, "Fourth is incorrect");
		
		assertTrue(res1, "Wrong return from add 1.");
		assertTrue(res2, "Wrong return from add 2.");		
		assertTrue(res3, "Wrong return from add 3.");
		assertTrue(res4, "Wrong return from add 4.");
	}
	
	@Test
	void testHeight() {
		tree1.add(5);
		tree1.add(2);
		tree1.add(4);
		tree1.add(9);
		
		assertEquals(3, tree1.height(), "Wrong height");
	}
	@Test
	void testHeightEmpty() {
		assertEquals(0, tree1.height(), "Wrong height for empty tree");
	}
	
	@Test
	void testClear() {
		tree3.add("A");
		tree3.add("L");
		tree3.clear();
		assertEquals(0, tree3.size(), "Clear not working");
	}
	
	@Test
	void testSize() {
		tree1.add(5);
		tree1.add(2);
		tree1.add(4);
		tree1.add(9);
		assertEquals(4, tree1.size(), "Size is not correct");
	}
	
	@Test
	void testSizeEmpty() {
		assertEquals(0, tree1.size(), "Size is not correct for empty tree");
	}

	@Test
	void testToArray() {
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		ArrayList<Integer> correct = new ArrayList<Integer>();
		
		correct.add(2);
		correct.add(4);
		correct.add(5);
		correct.add(9);
		
		tree1.add(5);
		tree1.add(2);
		tree1.add(4);
		tree1.add(9);
		
		tree1.toArray(tree1.getRoot(), sorted);
		
		assertEquals(correct, sorted);
	}
}
