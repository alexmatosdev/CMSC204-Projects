import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class for course structure
 * @author Alex Matos
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	LinkedList<CourseDBElement>[] hashTable;
	
	/**
	 * Constructor for class
	 * @param i
	 */
	public CourseDBStructure(int i) {
		// TODO Auto-generated constructor stub
		hashTable = new LinkedList[i];
	}

	/**
	 * Test constructor for class
	 * @param str
	 * @param i
	 */
	public CourseDBStructure(String str, int i) {
		// TODO Auto-generated constructor stub
		hashTable = new LinkedList[i];
	}

	/**
	 * Adds CDE to hashtable
	 */
	@Override
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		if (hashTable[element.hashCode() % getTableSize()] != null) {
			hashTable[element.hashCode() % getTableSize()].add(element);
		}
		else {
			LinkedList<CourseDBElement> list = new LinkedList<>();
			list.add(element);
			hashTable[element.hashCode() % getTableSize()] = list;
		}
	}

	/**
	 * Finds CDE based on its crn in the hastable, throws IOException if it is not in hashtable
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		for (LinkedList<CourseDBElement> i : hashTable)
			for (CourseDBElement ei : i)
				if (ei.getCRN() == crn)
					return ei;
		throw new IOException();
	}

	/**
	 * Returns the size of the hashtable
	 */
	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return hashTable.length;
	}

	
}
