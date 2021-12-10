import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {

	Town town ,town2;
	
	@Before
	public void setUp() throws Exception{
		town = new Town("town1");
		town2 = new Town("town2");
	}
	
	@After
	public void tearDown() throws Exception {
		town2 = null;
		town = null;
	}
	
	@Test
	public void getName() {
		assertEquals("town1",town.getName());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(110553055,town.hashCode());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("town1",town.toString());
	}
	
	@Test
	public void equalsTest() {
		assertEquals(false,town.equals(town2));
	}
}
