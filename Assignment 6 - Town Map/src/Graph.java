import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {

	ArrayList<Town> vertexList = new ArrayList<>();
	ArrayList<Road> edgeList = new ArrayList<>();
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		if (edgeList.size() == 1)
			for (Road e : edgeList)
				if ((e.getSource() == destinationVertex) && (e.getDestination() == sourceVertex))
					return e;
		for (Road e : edgeList)
			if ((e.getSource() == sourceVertex) && (e.getDestination() == destinationVertex))
				return e;
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException,NullPointerException {
		// TODO Auto-generated method stub
		Road edge = new Road(sourceVertex,destinationVertex,weight,description);
		edgeList.add(edge);
		return edge;
	}

	@Override
	public boolean addVertex(Town v) throws NullPointerException{
		// TODO Auto-generated method stub
		for (Town t : vertexList) {
			if (t.equals(v))
				return false;
		}
		vertexList.add(v);
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		for (Road e : edgeList)
			if ((e.getSource() == sourceVertex) && (e.getDestination() == destinationVertex))
				return true;
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		// TODO Auto-generated method stub
		 for(Town t : vertexList)
	           if(t.equals(v))
	               return true;
	       return false;
	}

	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		Set<Road> setOfEdges = new HashSet<>();
		for (Road e : edgeList)
			setOfEdges.add(e);
		return setOfEdges;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		Set<Road> edgesAdjVertex = new HashSet<>();
		for (Road e : edgeList)
			if (e.getDestination() == vertex || e.getSource() == vertex)
				edgesAdjVertex.add(e);
		return edgesAdjVertex;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		for (Road e : edgeList)
			if (e.getDestination() == destinationVertex && e.getSource() == sourceVertex && e.getWeight() == weight && e.getName() == description) {
				edgeList.remove(e);
				return e;
			}
				
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub

		for (Town t : vertexList) {
			if (t.equals(v)) {
				vertexList.remove(v);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		Set<Town> setOfVertex = new HashSet<>();
		for (Town e : vertexList)
			setOfVertex.add(e);
		return setOfVertex;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		String from = sourceVertex.name, goingTo = destinationVertex.name;
		int weight = 110;
		int i = 0;
		ArrayList<String> path = new ArrayList<>();
		path.add(sourceVertex.name);
		for (Town currTown : vertexList) {
			for (Road currRoad : edgeList) {
				if (currRoad.destination.name == destinationVertex.name && currRoad.source.name == from) {
					path.add(destinationVertex.name);
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

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}

}
