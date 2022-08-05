package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue_singlelinkedlist.FifoQueue;

class TestAppendFifoQueue {
	private FifoQueue<Integer> queue1;
	private FifoQueue<Integer> queue2;

	@BeforeEach
	void setUp() throws Exception {
		queue1 = new FifoQueue<Integer>();
		queue2 = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
		queue1 = null;
		queue2 = null;
	}

	@Test
	void testTwoNonEmpty() {
		String order = "123246";
		String newOrder = "";
		
		for(int i = 1; i <= 3; i++) {
			queue1.offer(i);
			queue2.offer(i*2);
		}
		queue1.append(queue2);
		assertEquals(6, queue1.size(), "Size wrong for two non empty queues");
		assertEquals(0, queue2.size(), "Appended queue not 0 size");

		for(int i = 1; i <= 6; i++) {
			newOrder += queue1.poll().toString();
		}
		assertEquals(order, newOrder, "Order is incorrect for new queue");
	}
	
	@Test
	void testTwoEmpty() {
		queue1.append(queue2);
		assertEquals(0, queue1.size(), "Size wrong for two empty queues");
		assertEquals(0, queue2.size(), "Appended queue not 0 size");

	}
	
	@Test
	void testEmptyToNonEmpty() {
		for(int i = 1; i <= 3; i++) {
			queue1.offer(i);
		}
		queue1.append(queue2);
		assertEquals(3, queue1.size(), "Size wrong for empty to non empty queue");
		assertEquals(0, queue2.size(), "Appended queue not 0 size");
	}
	
	@Test
	void testNonEmptyToEmpty() {
		String order = "123";
		String newOrder = "";
		for(int i = 1; i <= 3; i++) {
			queue2.offer(i);
		}
		
		queue1.append(queue2);
		assertEquals(3, queue1.size(), "Size wrong for non empty to empty queue");
		assertEquals(0, queue2.size(), "Appended queue not 0 size");

		for(int i = 1; i <= 3; i++) {
			newOrder += queue1.poll().toString();
		}
		assertEquals(order, newOrder, "Order is incorrect for new queue");
	}
	
	@Test
	void testAppendToSelf() {
		for(int i = 1; i <= 3; i++) {
			queue1.offer(i);
		}
		try {
			queue1.append(queue1);
		    fail( "Doesnt throw illegal argument when append to self" );
		}
		catch (IllegalArgumentException e) {
		}
	}
}
