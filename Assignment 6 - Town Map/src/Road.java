public class Road extends Object implements Comparable<Road> {

	Town source,destination;
	String name;
	int degrees;
	
	Road (Town source,Town destination,int degrees,String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		this.degrees = degrees;
	}
	
	Road(Town source,Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
	}
	
	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		if(o.getName() == name)
			return 0;
		return -1;
	}
	
	public boolean contains(Town town) {
		return source == town;
	}
	
	public boolean equals(Object r) {
		Road road = new Road(((Road) r).getSource(),((Road) r).getDestination(),((Road) r).getName());
		if (getDestination() == road.getDestination() && getSource() == road.getSource())
			return true;
		if (getDestination() == road.getSource() && getSource() == road.getDestination())
			return true;
		return false;
	}
	
	public Town getDestination() {
		return destination;
	}
	
	public String getName() {
		return name;
	}
	
	public Town getSource() {
		return source;
	}
	
	public int getWeight() {
		return degrees;
	}
	
	public String toString() {
		return name;
		
	}
	
}