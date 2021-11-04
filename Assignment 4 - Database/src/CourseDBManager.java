import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.stage.FileChooser;  

/**
 * Class for the manager of classes
 * @author Alex Matos
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	LinkedList<CourseDBElement> list = new LinkedList<>();
	
	/**
	 * Adds courses to the linked list
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		CourseDBElement course = new CourseDBElement(id,crn,credits,roomNum,instructor);
		if (list.size() == 0) {
			list.add(course);
			return ;
		}
		else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCRN() >= course.getCRN()) {
					list.add(i, course);
					return ;
				}
			}
		}
		list.add(course);
		
	}

	/**
	 * gets the course from the linkedlist based on position in linked list
	 */
	@Override
	public CourseDBElement get(int i) {
		// TODO Auto-generated method stub
		return list.get(i);
	}

	/**
	 * Reads file and makes it into a course
	 * @param input
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner courseFile = new Scanner(input);
		while (courseFile.hasNext()) {
			String courseID = courseFile.next();
			int courseCRN = courseFile.nextInt();
			int numOfCredits = courseFile.nextInt();
			String roomNum = courseFile.next();
			String instructName = courseFile.nextLine();
			add(courseID,courseCRN,numOfCredits,roomNum,instructName);		
		}
	}

	/**
	 * Returns an ArrayList with courses in linked list as Strings
	 */
	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		ArrayList<String> listStr = new ArrayList<>();
		for (CourseDBElement c : list) {
			listStr.add("\nCourse:" + c.courseID + " CRN:" + c.courseCRN + " Credits:" + c.numOfCredits + " Instructor:" + c.instructName + " Room:" + c.roomNum);
		}
		return listStr;
	}

}
