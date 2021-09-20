import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;

public class GradebookTester {

	GradeBook wilson;
	GradeBook joseph;

	
	@Before
	public void setUp() {
		wilson = new GradeBook(5);
		joseph = new GradeBook(5);
		
		wilson.addScore(88); wilson.addScore(91);
		joseph.addScore(21); joseph.addScore(99);
		
	}
	
	@After
	public void tearDown() {
		wilson = null;
		joseph = null;
	}
	
	@Test
	public void testAddScore() {
		assertTrue(wilson.toString().equals( "88.0 91.0"));
		assertTrue(joseph.toString().equals("21.0 99.0"));
		
		assertEquals(wilson.getScoreSize(), 2);
		assertEquals(joseph.getScoreSize(), 2);
	}
	
	@Test
	public void testSum() {
		assertEquals(wilson.sum(), 179);
		assertEquals(joseph.sum(), 120);
	}
	
	@Test
	public void testMinimum() {
		assertEquals(wilson.minimum(), 88);
		assertEquals(joseph.minimum(), 21);
	}
	
	@Test
	public void testFinalScore() {
		assertEquals(wilson.finalScore(), 91);
		assertEquals(joseph.finalScore(), 99);
	}
	
	@Test
	public void testGetScoreSize() {
		assertEquals(wilson.getScoreSize(), 2);
		assertEquals(joseph.getScoreSize(), 2);
	}
	
	@Test
	public void testToString() {
		assertEquals(joseph.toString(), "21.0 99.0");
	}
}
