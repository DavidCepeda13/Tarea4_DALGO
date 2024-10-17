package solucion;

import grafos.Edge;
import grafos.Graph;
import grafos.Node;

public abstract class GraphAlgorithm {
	abstract int[][] algorithm(Graph graph);
	
	public void initialize(Graph graph, Node origin) {
		for (Node node: graph.nodes()) {
			node.d(Integer.MAX_VALUE);
			node.p(null);
		}
		origin.d(0);
	}
	
	public Boolean relax(Edge edge) {
		if (edge.nodeU().d() != Integer.MAX_VALUE && (edge.nodeV().d() > edge.nodeU().d() + edge.edgeWeight())) {
			edge.nodeV().d(edge.nodeU().d() + edge.edgeWeight());
			edge.nodeV().p(edge.nodeU());
			return true;
		}
		return false;
	}
}
