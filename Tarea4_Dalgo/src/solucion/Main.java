package solucion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

import grafos.Edge;
import grafos.Graph;
import grafos.Node;

public class Main {
	
	public Graph buildGraph(String fileName) throws FileNotFoundException, IOException {
		Graph grafo = new Graph();
		
		try (FileReader reader = new FileReader(fileName);
			 BufferedReader in = new BufferedReader(reader)) { 
			String line = in.readLine();
			for (int i=0;line != null;i++) {
				try {
					System.out.println(line);
					String[] values = line.split(" ");
					if (!grafo.hasNode(values[0])) grafo.addNode(new Node(values[0]));
					if (!grafo.hasNode(values[1])) grafo.addNode(new Node(values[1]));
					Edge edge = new Edge(grafo.getNode(values[0]), grafo.getNode(values[1]), Integer.valueOf(values[2]));
					if (!grafo.edges().contains(edge)) grafo.addEdge(edge);
				} catch (Exception e) {
					System.err.println("Can not read number from line "+i+" content: "+line);
					e.printStackTrace();
				}
				line = in.readLine();
			}
		}
		return grafo;
	}
	
	
	
	public void selector(String outFilename, Graph grafo) throws FileNotFoundException {
		Boolean state = true;
		GraphAlgorithm algorithm;
		while (state){
			String value = input("Ingrese la opción que desea ejecutar: \n"
					+ "> 1. Dijkstra\n"
					+ "> 2. Bellman Ford\n"
					+ "> 3. Floyd Warshall\n"
					+ "> 4. BFS (particiones)\n"
					+ "> 5. Camino minimo\n"
					+ "> 6. Flujo máximo\n"
					+ "> 0. Salir");
			int opcion = Integer.valueOf(value);
			long startTime = -1L;
			long endTime = -1L;
			int[][] matriz;
			switch (opcion) {
			case 1:
				algorithm = new DijkstraAlgorithm();
				startTime = System.currentTimeMillis();
				matriz = algorithm.algorithm(grafo);
				endTime = System.currentTimeMillis();
				printMatriz(outFilename+"_dijkstra", matriz);
				break;
			case 2:
				algorithm = new BellmanFordAlgorithm();
				startTime = System.currentTimeMillis();
				matriz = algorithm.algorithm(grafo);
				endTime = System.currentTimeMillis();
				printMatriz(outFilename+"_bellmanford", algorithm.algorithm(grafo));
				break;
			case 3:
				algorithm = new FloydWarshallAlgorithm();
				startTime = System.currentTimeMillis();
				matriz = algorithm.algorithm(grafo);
				endTime = System.currentTimeMillis();
				printMatriz(outFilename+"_floydwarshall", algorithm.algorithm(grafo));
				break;
			case 4:
				BFSAlgorithm bfs = new BFSAlgorithm();
				List<List<String>> respuestas=bfs.componentesConectados(grafo);
				String cadena="{{";
				for (List<String> partes: respuestas){
					for (String parte: partes) {
						cadena+=parte+",";
					}
					cadena+="},";
				}
				String nuevaCadena = cadena.substring(0, cadena.length() - 1);
				nuevaCadena+="}";
				System.out.println(nuevaCadena);
				break;
			case 5:
				break;
			case 6:
				break;
			case 0:
				state = false;
				break;
			}
			System.out.println("El tiempo de ejecución fue de: "+String.valueOf(endTime-startTime));
		}
	}

	
	/**
	 * Main method for the recursion example. It has three parameters:
	 * args[0]: Path to the input file with numbers to process. It must be a text file with one number per line
	 * args[1]: Path to the output file with the numbers sorted
	 * @param args Array with the arguments described above 
	 */
	public static void main(String[] args) {
		//Read parameters
		Main main = new Main();
		String inFilename = args[0];
		String outFilename = args[1];
		
		try {
			Graph grafo = main.buildGraph(inFilename);
			System.out.println("El grafo se cargó correctamente");
			main.printGraph(grafo.edges());
			main.selector(outFilename, grafo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String input(String mensaje) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String value = "";

        try {
        	System.out.println(mensaje);
            value = reader.readLine();  // Leer una línea de texto

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada.");
            e.printStackTrace();
        }
		return value;
	}
	
	//< Print the uploaded graph >
	public void printGraph(List<Edge> edges) {
		for(Edge edge: edges) {
			System.out.println("v1: "+edge.nodeU().getValue()+" v2: "+edge.nodeV().getValue()+" weight: "+edge.edgeWeight());
		}
	}
	
	//< Print the matriz to the file >
	public void printMatriz(String fileName, int[][] matriz) throws FileNotFoundException {
		try (PrintStream out=new PrintStream(fileName)) {
			for (int[] fila: matriz) {
				for (int columna: fila) {
					out.print(String.valueOf(columna)+"\t");
				}
				out.println();
			}
		}
	}

}
