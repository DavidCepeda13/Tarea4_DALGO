package grafos;

public class Node implements Comparable<Node> {
	private String value;
	private int distance;
	private Node predecessor;
	
	public Node(String value) {
		this.value = value;
	}

	//< Return the value of this >
	public String getValue() {
		return this.value;
	}
	
	//< Return the accumulate distance of this >
	public int d() {
		return this.distance;
	}
	
	//< Return the predecessor of this >
	public Node p() {
		return this.predecessor;
	}
	
	//< Set a new distance to this >
	public void d(int distance) {
		this.distance = distance;
	}
	
	//< Set a new predecessor to this >
	public void p(Node predecessor) {
		this.predecessor = predecessor;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.distance, o.distance);
	}
}
