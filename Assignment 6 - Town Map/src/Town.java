public class Town extends Object implements Comparable<Town> {

	String name;
	
	Town (String name) {
		this.name = name;
	}
	
	Town (Town templateTown) {
		this.name = templateTown.name;
	}
	
	@Override
	public int compareTo(Town o) {
		// TODO Auto-generated method stub
		if (o == this) 
			if (o.toString() == name)
				return 0;
		return -1;
	}
	
	public boolean equals(Object obj) {
		if (obj.toString().compareToIgnoreCase(name) == 0)
			return true;
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public String toString() {
		return name;
	}
	
}