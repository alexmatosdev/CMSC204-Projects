import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {

	Road road , road2;
	Town town1,town2;
	
	@Before
	public void setUp() throws Exception{
		town1 = new Town("town1");
		town2 = new Town("town2");
		road = new Road(new Town("town1"),new Town("town2"),8,"Jefferson");
		road2 = new Road(new Town("town1"),new Town("town2"),8,"Jefferson");
	}
	
	@After
	public void tearDown() throws Exception {
		road = null;
		road2 = null;
	}
	
	@Test
	public void getDestination() {
		assertEquals(town2,road.getDestination());
	}
	
	@Test
	public void getName() {
		assertEquals("Jefferson",road.getName());
	}
	
	@Test
	public void getSource() {
		assertEquals(town1,road.getSource());
	}
	
	@Test
	public void getWeight() {
		assertEquals(8,road.getWeight());
	}
	
	@Test
	public void equalsTest() {
		assertEquals(false,road.equals(road2));
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Jefferson",road.toString());
	}
}
