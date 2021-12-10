import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface townGraphM;
	private String[] t;
	  
	@Before
	public void setUp() throws Exception {
		  townGraphM = new TownGraphManager();
		  t = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  t[i] = "Town_" + i;
			  townGraphM.addTown(t[i]);
		  }
		  
		  townGraphM.addRoad(t[1], t[2], 2, "Road_1");
		  townGraphM.addRoad(t[1], t[3], 4, "Road_2");
		  townGraphM.addRoad(t[1], t[5], 6, "Road_3");
		  townGraphM.addRoad(t[3], t[7], 1, "Road_4");
		  townGraphM.addRoad(t[3], t[8], 2, "Road_5");
		  townGraphM.addRoad(t[4], t[8], 3, "Road_6");
		  townGraphM.addRoad(t[6], t[9], 3, "Road_7");
		  townGraphM.addRoad(t[9], t[10], 4, "Road_8");
		  townGraphM.addRoad(t[8], t[10], 2, "Road_9");
		  townGraphM.addRoad(t[5], t[10], 5, "Road_10");
		  townGraphM.addRoad(t[10], t[11], 3, "Road_11");
		  townGraphM.addRoad(t[2], t[11], 6, "Road_12");
		 
	}

	@After
	public void tearDown() throws Exception {
		townGraphM = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = townGraphM.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		townGraphM.addRoad(t[4], t[11], 1,"Road_13");
		roads = townGraphM.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		assertEquals("Road_13", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_12", townGraphM.getRoad(t[2], t[11]));
		assertEquals("Road_4", townGraphM.getRoad(t[3], t[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, townGraphM.containsTown("Town_12"));
		townGraphM.addTown("Town_12");
		assertEquals(true, townGraphM.containsTown("Town_12"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, townGraphM.containsTown("Town_12"));
		townGraphM.addTown("Town_12");
		ArrayList<String> path = townGraphM.getPath(t[1],"Town_12");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, townGraphM.containsTown("Town_2"));
		assertEquals(false, townGraphM.containsTown("Town_12"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, townGraphM.containsRoadConnection(t[2], t[11]));
		assertEquals(false, townGraphM.containsRoadConnection(t[3], t[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = townGraphM.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_8", roads.get(10));
		assertEquals("Road_9", roads.get(11));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, townGraphM.containsRoadConnection(t[2], t[11]));
		townGraphM.deleteRoadConnection(t[2], t[11], "Road_12");
		assertEquals(false, townGraphM.containsRoadConnection(t[2], t[11]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, townGraphM.containsTown("Town_2"));
		townGraphM.deleteTown(t[2]);
		assertEquals(false, townGraphM.containsTown("Town_2"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = townGraphM.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_10", roads.get(1));
		assertEquals("Town_11", roads.get(2));
		assertEquals("Town_2", roads.get(3));
		assertEquals("Town_8", roads.get(9));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = townGraphM.getPath(t[1],t[11]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_12 to Town_11 6 mi",path.get(1).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = townGraphM.getPath(t[1],t[10]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_2 to Town_3 4 mi",path.get(0).trim());
		  assertEquals("Town_3 via Road_5 to Town_8 2 mi",path.get(1).trim());
		  assertEquals("Town_8 via Road_9 to Town_10 2 mi",path.get(2).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = townGraphM.getPath(t[1],t[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_2 to Town_3 4 mi",path.get(0).trim());
		  assertEquals("Town_3 via Road_5 to Town_8 2 mi",path.get(1).trim());
		  assertEquals("Town_8 via Road_9 to Town_10 2 mi",path.get(2).trim());
		  assertEquals("Town_10 via Road_8 to Town_9 4 mi",path.get(3).trim());
		  assertEquals("Town_9 via Road_7 to Town_6 3 mi",path.get(4).trim());

	}

}
