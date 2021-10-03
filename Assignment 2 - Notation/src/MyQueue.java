import java.util.ArrayList;

/**
 * 
 * @author Alex Matos
 *
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T>{

	private ArrayList<T> queue;
	private final int size;
	
	/**
	 * Constructor class that initializes MyQueue and default size
	 */
	public MyQueue() {
		queue = new ArrayList<T>();
		this.size = 100;
	}
	
	/**
	 * Constructor class that initializes MyQueue and makes size
	 * @param size
	 */
	public MyQueue(int size) {
		queue = new ArrayList<T>(size);
		this.size = size;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return queue.size() == size;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new QueueUnderflowException();
		T temp = queue.get(0);
		queue.remove(0);
		return temp;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int i = 0;
		for (T data : queue)
			i++;
		return i;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if (isFull())
			throw new QueueOverflowException();
		queue.add(e);
		return true;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String str = "";
		for (T data : queue)
			str += data + delimiter;
		str = str.substring(0, str.length()-1);
		return str;
	}

	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (T data : queue)
			str += data ;
		return str;
	}
	
	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		for (T data : list)
			queue.add(data);
	}
	
}
