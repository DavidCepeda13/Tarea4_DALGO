package solucion;

import grafos.Edge;
import grafos.Graph;
import grafos.Node;

public abstract class GraphAlgorithm {
	abstract int[][] algorithm(Graph graph);
	
	public void initialize(Graph graph, Node origin) {
		int maxEdgeWeight = maxWeight(graph);
		for (Node node: graph.nodes()) {
			node.d(Integer.MAX_VALUE - maxEdgeWeight - 1);
			node.p(null);
		}
		origin.d(0);
	}
	
	public void relax(Edge edge) {
		if (edge.nodeV().d() > edge.nodeU().d() + edge.edgeWeight()) {
			edge.nodeV().d(edge.nodeU().d() + edge.edgeWeight());
			edge.nodeV().p(edge.nodeU());
		}
	}
	
	private int maxWeight(Graph graph) {
		int max = Integer.MIN_VALUE;
		for (Edge edge: graph.edges()) {
			if (edge.edgeWeight() > max) max = edge.edgeWeight();
		}
		return max;
	}
}
