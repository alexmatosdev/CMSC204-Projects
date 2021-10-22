import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A class for a BasicDoubleLinkedList
 * @author Alex Matos
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{

	Node head,tail = null;
	int size = 0;

	@Override
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return new iteratorr();
	}
	
	/**
	 * adds data to end 
	 * @param data
	 * @return this
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		// TODO Auto-generated method stub
		Node temp = new Node(tail,data,null);
		if (tail != null)
			tail.next = temp;
		tail = temp;
		if (head == null)
			head = temp;
		size++;
		return this;
	}

	/**
	 * gets size
	 * @return size
	 */
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * gets tail data
	 * @return tail.data
	 */
	public T getLast() {
		// TODO Auto-generated method stub
		return tail.data;
	}

	/**
	 * gets head data
	 * @return head.data
	 */
	public T getFirst() {
		// TODO Auto-generated method stub
		return head.data;
	}

	/**
	 * adds data to front
	 * @param data
	 * @return this
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		// TODO Auto-generated method stub
		Node temp = new Node(null,data,head);
		head.previous = temp;
		head = temp;
		if (tail == null)
			tail = temp;
		return this;
	}

	/**
	 * returns linkedlist in arrayList frm
	 * @return list
	 */
	public ArrayList<T> toArrayList() {
		// TODO Auto-generated method stub
		ArrayList<T> list = new ArrayList<T>();
		
		while(head.next != null) {
			list.add(head.data);
			head = head.next;
		}
		list.add(tail.data);
		return list;
	}

	/**
	 * removes data from linked list
	 * @param targetData
	 * @param comparator
	 * @return this
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		// TODO Auto-generated method stub
		Node tempH = head;
		if (comparator.compare(targetData, tempH.data) == 0) {
			head = tempH.next;
		}
		Node tempT = tail;
		if (comparator.compare(targetData, tempT.data) == 0) {
			tail = tempT.previous;
		}
		size--;
		return this;
	}

	/**
	 * gets first element data
	 * @return head.data
	 */
	public T retrieveFirstElement() {
		// TODO Auto-generated method stub
		Node tH = head;
		head = head.next;
		head.previous = null;
		size--;
		return tH.data;
	}

	/**
	 * returns last element data
	 * @return tail.data
	 */
	public T retrieveLastElement() {
		// TODO Auto-generated method stub
		Node tT = tail;
		tail = tail.previous;
		tail.next = null;
		size--;
		return tT.data;
	}
	
	/**
	 * Node Class
	 *
	 */
	protected class Node {
		
		protected T data;
		protected Node next,previous;
		
		public Node (Node previous, T data, Node next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}
	
	/**
	 * Iterator class that implements some ListIterator methods
	 *
	 */
	protected class iteratorr implements ListIterator<T> {

		Node next,prev;
		
		protected iteratorr() {
			next = head;
			prev = tail;
		} 
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return next != null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return prev != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (this.next == null) {
				throw  new NoSuchElementException();
			}
			T i = null;
			if (hasNext()) {
				i = next.data;
				next = next.next;
			}
			return i;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			
			T i = null;
			if (hasPrevious()) {
				i = prev.data;
				prev = prev.previous;
			}
			else {
				throw  new NoSuchElementException();
			}
			return i;
		}
		
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(Object arg0) throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(Object arg0) throws UnsupportedOperationException{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}


}
