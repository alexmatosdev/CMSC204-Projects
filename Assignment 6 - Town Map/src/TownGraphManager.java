
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TownGraphManager implements TownGraphManagerInterface {

	Graph graph = new Graph();
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		// TODO Auto-generated method stub
		graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		for (Road e : graph.edgeList)
			if ((e.getSource().name == town1) && (e.getDestination().name == town2))
				return e.getName();
		return null;
	}

	@Override
	public boolean addTown(String v) {
		// TODO Auto-generated method stub
		graph.addVertex(new Town(v));
		return true;
	}

	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		for (Town t : graph.vertexList)
			if (t.getName() == name)
				return t;
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		for(Town t : graph.vertexList)
	           if(t.equals(v))
	               return true;
	       return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		for (Road e : graph.edgeList)
			if ((e.getSource().getName() == town1) && (e.getDestination().getName() == town2))
				return true;
		return false;
	}

	@Override
	public ArrayList<String> allRoads() {
		// TODO Auto-generated method stub
		ArrayList<String> roadsInOrd = new ArrayList<>();
		for (Road r : graph.edgeList)
			roadsInOrd.add(r.getName());
		roadsInOrd.sort(String::compareToIgnoreCase);
		return roadsInOrd;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		for (Road r : graph.edgeList) {
			if (r.getDestination().getName() == town2 && r.getSource().getName() == town1 && r.getName() == road) {
				graph.edgeList.remove(r);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		for (Town t : graph.vertexList) {
			if (t.getName() == v) {
				graph.vertexList.remove(t);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		ArrayList<String> townsInOrd = new ArrayList<>();
		for (Town r : graph.vertexList)
			townsInOrd.add(r.getName());
		townsInOrd.sort(String::compareToIgnoreCase);
		return townsInOrd;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		String from = town1, goingTo = town2;
		int weight = 110;
		int i = 0;
		ArrayList<String> path = new ArrayList<>();
		path.add(town1);
		for (Town currTown : graph.vertexList) {
			for (Road currRoad : graph.edgeList) {
				if (currRoad.destination.name == town2 && currRoad.source.name == from) {
					path.add(town2);
					return path;
				}
				if (currRoad.source.name == from && currRoad.degrees < weight) {
					weight = currRoad.degrees;
					goingTo = currRoad.destination.name;
				}
			}
			i++;
			path.add(goingTo);
			from = goingTo;
			weight = 110;
			if (path.get(i-1) == goingTo) {
				path.remove(i);
				return path;
			}
		}
		return null;
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		
	}

}
