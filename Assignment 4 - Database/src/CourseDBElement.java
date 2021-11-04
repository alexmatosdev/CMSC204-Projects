

/**
 * Class that represents a course
 * @author Alex Matos
 *
 */
public class CourseDBElement implements Comparable{

	// Variable that each course will have
	protected String courseID;
	protected int courseCRN;
	protected int numOfCredits;
	protected String roomNum;
	protected String instructName;
	
	/**
	 * Constructor that initializes all variables for the class
	 * @param courseID
	 * @param courseCRN
	 * @param numOfCredits
	 * @param roomNum
	 * @param instructName
	 */
	public CourseDBElement(String courseID, int courseCRN, int numOfCredits, String roomNum, String instructName) {
		// TODO Auto-generated constructor stub
		this.courseID = courseID;
		this.courseCRN = courseCRN;
		this.numOfCredits = numOfCredits;
		this.roomNum = roomNum;
		this.instructName = instructName;
	}

	/**
	 * Constructor initializes all variables to null
	 */
	public CourseDBElement() {
		// TODO Auto-generated constructor stub
		this.courseID = null;
		this.courseCRN = (Integer) null;
		this.numOfCredits = (Integer) null;
		this.roomNum = null;
		this.instructName = null;
	}

	/**
	 * Compares two to see if they are equal
	 */
	@Override
	public int compareTo(Object cde) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns the crn of this CDE
	 * @return
	 */
	public int getCRN() {
		// TODO Auto-generated method stub
		return courseCRN;
	}

	/**
	 * Sets the crn for this CDE
	 * @param crn
	 */
	public void setCRN(int crn) {
		// TODO Auto-generated method stub
		courseCRN = crn;
	}

}
