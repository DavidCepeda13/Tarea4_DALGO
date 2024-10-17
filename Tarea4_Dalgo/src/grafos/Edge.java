package grafos;

public class Edge {
	private Node origin;
	private Node destiny;
	private Integer weight;
	
	public Edge(Node origin, Node destiny, Integer weight) {
		this.origin = origin;
		this.destiny = destiny;
		this.weight = weight;
	}
	
	//< Return the weight of this >
	public Integer edgeWeight() {
		return this.weight;
	}
	
	//< Return the origin of this >
	public Node nodeU() {
		return this.origin;
	}
	
	//< Return the destiny of this >
	public Node nodeV() {
		return this.destiny;
	}
}
