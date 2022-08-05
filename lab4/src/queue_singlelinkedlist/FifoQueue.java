package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		if(last == null) {
			QueueNode<E> q = new QueueNode<E>(e);
			last = q;
			q.next = q;
			size++;
			return true;
		}
		else {
			QueueNode<E> q = new QueueNode<E>(e);
			q.next = last.next;
			last.next = q;
			last = q;
			size++;
			return true;
		}
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(size == 0) {
			return null;
		}
		else {
			return last.next.element;
		}
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if(size == 0) {
			return null;
		}
		else if(size == 1) {
			E toReturn = last.element;
			last = null;
			size = 0;
			return toReturn;
		}
		else {
			E ret = last.next.element;
			last.next = last.next.next;
			size--;
			return ret;
		}
	}
	
	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/
	public void append(FifoQueue<E> q) {
		if(this.equals(q)) {
			throw new IllegalArgumentException();
		}
		else if (q.size() > 0 && size > 0){
			size += q.size();
			QueueNode<E> temp = q.last.next;
			q.last.next = last.next;
			last.next = temp;
			last = q.last;
			q.size = 0;
		}
		else if (q.size() == 0 && size > 0){
			return;
		}
		else if (q.size() > 0 && size == 0){
			size = q.size();
			last = q.last;
			q.size = 0;
		}
		else if (q.size() == 0 && size == 0){
			return;
		}
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		/* Konstruktor */
		private QueueIterator() {
			if(size > 1) {
				pos = last.next;
			}
			else if (size == 1) {
				pos = last;
			}
			else {
				pos = null;
			}
		}
		
		public boolean hasNext() {
			return  pos != null;
		}
		
		public E next() {
			E toReturn;
			if(pos != null) {
				toReturn = pos.element;
				pos = pos.next;
			}
			else {
				throw new NoSuchElementException();
			}
			if(size > 1 && pos.equals(last.next)) {
				pos = null;
			}
			return toReturn;
		}
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
