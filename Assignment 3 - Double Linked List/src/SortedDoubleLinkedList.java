import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Class for a sorted double array
 * @author Alex Matos
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{

	Node head,tail = null;
	int size = 0;
	Comparator<T> comparator;
	
	/**
	 * Constructor for class
	 * @param comparator
	 */
	public SortedDoubleLinkedList(Comparator comparator) {
		// TODO Auto-generated constructor stub
		this.comparator = comparator;
	}

	/**
	 * Adds @param in order
	 * @param data
	 * @return
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		// TODO Auto-generated method stub
		int i = 0;
		int s = size;
		Node temp = new Node (null,data,null);
		if (size==0) {
			head=temp;
			tail=temp;
			size++;
			return this;
		}
		else {
			head.previous=temp;
			temp.next=head;
		}
		if (comparator.compare(data, temp.next.data) < 0) {
			head = temp;
		}
		while (i < size && comparator.compare(data, temp.next.data) > 0 ) {
			Node tP = temp.previous,nP = temp;
			Node nN = temp.next.next,tN = temp.next;
			
			temp.next = nN; temp.previous = tN;
			tN.previous = tP; tN.next = nP;
			
			i++;
			s = size;
		}
		if (i == size) {
			if (i == 2) {
				head.next = tail;
			}

			tail = temp;
		}
		
		size++;
		return this;
	}
	
	/**
	 * Gets tail data
	 */
	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return tail.data;
	}

	/**
	 * Gets head data
	 */
	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return head.data;
	}
	
	/**
	 * Returns the first element and deletes it
	 */
	@Override
	public T retrieveFirstElement() {
		// TODO Auto-generated method stub
		Node tH = head;
		head = head.next;
		head.previous = null;
		size--;
		return tH.data;
	}

	/**
	 * Returns the last element and deletes it
	 */
	@Override
	public T retrieveLastElement() {
		// TODO Auto-generated method stub
		Node tT = tail;
		tail = tail.previous;
		tail.next = null;
		size--;
		return tT.data;
	}
	
	/**
	 * Method not needed for this class
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Method not needed for this class
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * instantiates iteratorr
	 */
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return new iteratorr();
	}
	
	/**
	 * removes elements linked list
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		// TODO Auto-generated method stub
		Node tempH = head;
		if (comparator.compare(data, tempH.data) == 0) {
			head = tempH.next;
		}
		Node tempT = tail;
		if (comparator.compare(data, tempT.data) == 0) {
			tail = tempT.previous;
		}
		size--;
		return this;
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
				i = prev.previous.next.data;
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
