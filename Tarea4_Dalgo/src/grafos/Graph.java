package grafos;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<String, Node> nodes;
	private List<Edge> edges;
	private Map<Node, List<Edge>> adjList;
	
	public Graph() {
		this.nodes = new HashMap<String, Node>();
		this.edges = new LinkedList<Edge>();
	}
	
	
	//< Add a new node to this >
	public void addNode(Node node) {
		this.nodes.put(node.getValue(), node);
	}
	
	//< Add a new edge to this >
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}
	
	//< Return the list of edges of this >
	public List<Edge> edges(){
		return this.edges;
	}
	
	//< Return the representation of this as adjacent map >
	public Map<Node, List<Edge>> getAdjList(){
		Map<Node, List<Edge>> graph = new HashMap<Node, List<Edge>>();
		for (Edge edge: this.edges) {
			if (!graph.containsKey(edge.nodeU())) {
				graph.put(edge.nodeU(), new LinkedList<Edge>());
				graph.get(edge.nodeU()).add(edge);
			} else {
				graph.get(edge.nodeU()).add(edge);
			}
		}
		return graph;
	}
	
	//< Return the list of edges of this >
	public Collection<Node> nodes() {
		return this.nodes.values();
	}
	
	//< Return and remove the edge from this >
	public Edge removeEdge(Edge edge) {
		this.edges.remove(edge);
		return edge;
	}
	
	public Node getNode(String value) {
		return this.nodes.get(value);
	}
	
	//< Return if this has a node >
	public Boolean hasNode(String value) {
		return this.nodes.containsKey(value);
	}
	
	//< Return if this has an edge >
	public Boolean hasEdge(Edge edge) {
		return this.edges.contains(edge);
	}
	
	
}
