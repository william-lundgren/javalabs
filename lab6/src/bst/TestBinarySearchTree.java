package bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBinarySearchTree {
	private BinarySearchTree<Integer> tree1;

	@BeforeEach
	void setUp() throws Exception {
		tree1 = new BinarySearchTree<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree1 = null;
	}

	@Test
	void testAddOrder() {
		tree1.add(5);
		tree1.add(2);
		tree1.add(4);
		tree1.add(9);
		
		int first = tree1.getRoot().getElement();		
		int second = tree1.getRoot().getLeft().getElement();		
		int third = tree1.getRoot().getLeft().getLeft().getElement();		
		int fourth = tree1.getRoot().getRight().getElement();
		
		assertEquals(first, 5, "First is incorrect");
		assertEquals(second, 2, "Second is incorrect");
		assertEquals(third, 4, "Third is incorrect");
		assertEquals(fourth, 9, "Fourth is incorrect");
	}
	
	@Test
	void testHeight() {
		
	}
	@Test
	void testPrintTree() {
		fail("Not yet implemented");
	}
	@Test
	void testClear() {
		fail("Not yet implemented");
	}
	@Test
	void testSize() {
		fail("Not yet implemented");
	}

}
