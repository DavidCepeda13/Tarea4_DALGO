package solucion;

import java.util.HashMap;

import grafos.Edge;
import grafos.Graph;
import grafos.Node;

public class BellmanFordAlgorithm extends GraphAlgorithm{
	@Override
	public int[][] algorithm(Graph graph) {
		return bellmanFordMinimalCost(graph);
	}
	
	public int[][] bellmanFordMinimalCost(Graph graph){
		int[][] minimalCost = new int[graph.nodes().size()][graph.nodes().size()];
		HashMap<Node, Integer> labels = new HashMap<Node, Integer>();
		int i = 0;
		for (Node node: graph.nodes()) {
			labels.put(node, i);
			i++;
		}
		for (Node node: graph.nodes()) {
			BellmanFord(graph, node);
			for (Node nodeM: graph.nodes()) {
				minimalCost[labels.get(node)][labels.get(nodeM)] = nodeM.d();
			}
		}
		return minimalCost;
	}
	
	public Boolean BellmanFord(Graph graph, Node s) {
		initialize(graph, s);
		for (int i = 0; i < graph.nodes().size() - 1; i++) {
			for (Edge edge: graph.edges()) {
				relax(edge);
			}
		}
		for (Edge edge: graph.edges()) {
			if (edge.nodeV().d() > edge.nodeU().d() + edge.edgeWeight()) return false;
		}
		return true;
	}

}
