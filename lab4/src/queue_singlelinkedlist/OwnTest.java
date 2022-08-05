package queue_singlelinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class OwnTest {
	public static void main(String[] args) {
		Queue<Integer> myIntQueue = new FifoQueue<Integer>();

		int nbr = 5;
		for (int i = 1; i <= nbr; i++) {
			myIntQueue.offer(i);
		}
		Iterator<Integer> itr1 = myIntQueue.iterator();
		
		for(int i = 1; i <= 6; i++) {
			System.out.println(itr1.hasNext());
			System.out.println(itr1.next());
			
		}
	}
}
