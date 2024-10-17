package solucion;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import grafos.Edge;
import grafos.Graph;
import grafos.Node;

public class DijkstraAlgorithm extends GraphAlgorithm{
	@Override
	public int[][] algorithm(Graph graph) {
		return dijkstraMinimalCost(graph);
	}
	
	public int[][] dijkstraMinimalCost(Graph graph){
		int[][] minimalCost = new int[graph.nodes().size()][graph.nodes().size()];
		HashMap<Node, Integer> labels = new HashMap<Node, Integer>();
		int i = 0;
		for (Node node: graph.nodes()) {
			labels.put(node, i);
			i++;
		}
		for (Node node: graph.nodes()) {
			Dijkstra(graph, node);
			for (Node nodeM: graph.nodes()) {
				minimalCost[labels.get(node)][labels.get(nodeM)] = nodeM.d();
			}
		}
		return minimalCost;
	}
	
	public void Dijkstra(Graph graph, Node s) {
		initialize(graph, s);
		Set<Node> S = new TreeSet<Node>();
		PriorityQueue<Node> Q = new PriorityQueue<Node>(graph.nodes());
		while (!Q.isEmpty()) {
			Node u = Q.poll();
			S.add(u);
		}
	}
}
