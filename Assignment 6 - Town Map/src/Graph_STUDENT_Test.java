import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {

	private GraphInterface<Town,Road> graphInter;
	private Town[] t;

	@Before
	public void setUp() throws Exception {
		 graphInter = new Graph();
		  t = new Town[12];
		  
		  for (int i = 1; i < 12; i++) {
			  t[i] = new Town("Town_" + i);
			  graphInter.addVertex(t[i]);
		  }
		  
		  graphInter.addEdge(t[1], t[2], 2, "Road_1");
		  graphInter.addEdge(t[1], t[3], 4, "Road_2");
		  graphInter.addEdge(t[1], t[5], 6, "Road_3");
		  graphInter.addEdge(t[3], t[7], 1, "Road_4");
		  graphInter.addEdge(t[3], t[8], 2, "Road_5");
		  graphInter.addEdge(t[4], t[8], 3, "Road_6");
		  graphInter.addEdge(t[6], t[9], 3, "Road_7");
		  graphInter.addEdge(t[9], t[10], 4, "Road_8");
		  graphInter.addEdge(t[8], t[10], 2, "Road_9");
		  graphInter.addEdge(t[5], t[10], 5, "Road_10");
		  graphInter.addEdge(t[10], t[11], 3, "Road_11");
		  graphInter.addEdge(t[2], t[11], 6, "Road_12");
	}

	@After
	public void tearDown() throws Exception {
		graphInter = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(t[2], t[11],6, "Road_12"), graphInter.getEdge(t[2], t[11]));
		assertEquals(new Road(t[3], t[7],1, "Road_4"), graphInter.getEdge(t[3], t[7]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graphInter.containsEdge(t[3], t[5]));
		graphInter.addEdge(t[3], t[5], 1, "Road_13");
		assertEquals(true, graphInter.containsEdge(t[3], t[5]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_12");
		assertEquals(false, graphInter.containsVertex(newTown));
		graphInter.addVertex(newTown);
		assertEquals(true, graphInter.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graphInter.containsEdge(t[2], t[11]));
		assertEquals(false, graphInter.containsEdge(t[3], t[5]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graphInter.containsVertex(new Town("Town_2")));
		assertEquals(false, graphInter.containsVertex(new Town("Town_12")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graphInter.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_10", roadArrayList.get(1));
		assertEquals("Road_11", roadArrayList.get(2));
		assertEquals("Road_12", roadArrayList.get(3));
		assertEquals("Road_2", roadArrayList.get(4));
		assertEquals("Road_8", roadArrayList.get(10));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graphInter.edgesOf(t[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_2", roadArrayList.get(1));
		assertEquals("Road_3", roadArrayList.get(2));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graphInter.containsEdge(t[2], t[11]));
		graphInter.removeEdge(t[2], t[11], 6, "Road_12");
		assertEquals(false, graphInter.containsEdge(t[2], t[11]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graphInter.containsVertex(t[2]));
		graphInter.removeVertex(t[2]);
		assertEquals(false, graphInter.containsVertex(t[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graphInter.vertexSet();
		assertEquals(true,roads.contains(t[1]));
		assertEquals(true, roads.contains(t[10]));
		assertEquals(true, roads.contains(t[11]));
		assertEquals(true, roads.contains(t[2]));
		assertEquals(true, roads.contains(t[3]));
	}

	 @Test
	  public void testTown_1ToTown_11() {
		  String beginTown = "Town_1", endTown = "Town_11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graphInter.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graphInter.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
			  assertEquals("Town_2 via Road_12 to Town_11 6 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown1ToTown_10() {
		  String beginTown = "Town_1", endTown = "Town_10";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graphInter.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graphInter.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_2 to Town_3 4 mi",path.get(0).trim());
			  assertEquals("Town_3 via Road_5 to Town_8 2 mi",path.get(1).trim());
			  assertEquals("Town_8 via Road_9 to Town_10 2 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_4ToTown_11() {
		  String beginTown = "Town_4", endTown = "Town_11";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graphInter.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graphInter.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_4 via Road_6 to Town_8 3 mi",path.get(0).trim());
			  assertEquals("Town_8 via Road_9 to Town_10 2 mi",path.get(1).trim());
			  assertEquals("Town_10 via Road_11 to Town_11 3 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }

}
