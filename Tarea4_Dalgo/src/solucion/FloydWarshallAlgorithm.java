package solucion;

import java.util.HashMap;

import grafos.Edge;
import grafos.Graph;
import grafos.Node;

public class FloydWarshallAlgorithm extends GraphAlgorithm{

	@Override
	int[][] algorithm(Graph graph) {
		// TODO Auto-generated method stub
		return FloydWarshall(graph);
	}
	
	public int[][] FloydWarshall(Graph graph){
		int n = graph.nodes().size();
		int[][] minimalCost = new int[n][n];
		HashMap<Node, Integer> labels = new HashMap<Node, Integer>();
		int i = 0;
		for (Node node: graph.nodes()) {
			labels.put(node, i);
			i++;
		}
		
		for (i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) minimalCost[i][j] = 0;
				else minimalCost[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (Edge edge: graph.edges()) {
			minimalCost[labels.get(edge.nodeU())][labels.get(edge.nodeV())] = edge.edgeWeight();
		}
		
		for (int k = 0; k < n; k++) {
			for (i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (minimalCost[i][k] != Integer.MAX_VALUE && minimalCost[k][j] != Integer.MAX_VALUE) {
						minimalCost[i][j] = Math.min(minimalCost[i][j], minimalCost[i][k] + minimalCost[k][j]);
                    }
				}
			}
		}
		return minimalCost;
	}

}
