import java.util.ArrayList;

/**
 * Generic Stack class that implements StackInterface
 * @author Alex Matos
 *
 * @param <T>
 */
public class NotationStack<T> implements StackInterface<T>{

	private ArrayList<T> stack;
	private final int size;
	
	/**
	 * Constructor class that initializes Stack and default size
	 */
	public NotationStack() {
		stack = new ArrayList<T>();
		this.size = 100;
	}
	
	/**
	 * Constructor class that initializes Stack and makes size
	 * @param size
	 */
	public NotationStack(int size) {
		// TODO Auto-generated constructor stub
		stack = new ArrayList<>(size);
		this.size = size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack.isEmpty();
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return stack.size() == size;
	}

	@Override
	public T pop() throws StackUnderflowException{
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new StackUnderflowException();
		T temp = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return temp;
	}

	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		return stack.get(stack.size()-1);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int i = 0;
		for (T data : stack)
			i++;
		return i;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		stack.add(e);
		return true;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String str = "";
		for (T data : stack)
			str += data + delimiter;
		str = str.substring(0, str.length()-1);
		return str;
	}

	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (T data : stack)
			str += data ;
		return str;
	}
	
	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		for (T data : list)
			stack.add(data);
	}
	
	public T get(int i) {
		return stack.get(i);
	}

}
