package solucion;

import grafos.Edge;
import grafos.Graph;
import grafos.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFSAlgorithm{

    public List<List<String>> componentesConectados(Graph graph){
        Map<Node,Boolean> visitados = new HashMap<>();
        List<Node> nodos= new ArrayList<>();
        List<List<String>> respuesta= new ArrayList<>();
        List<String> parte= new ArrayList<>();
        Map<Node, List<Edge>>listaAdyacencia=graph.getAdjList();
        for (Node nodo : graph.nodes()) {
            nodos.add(nodo);
            visitados.put(nodo, false);
        }
        for (Node nodo : nodos){
            if (!visitados.get(nodo)){
                algorithmBFS(graph, nodo, visitados, listaAdyacencia);
            }
            for (int i=0; i<nodos.size();i++){
                if (nodos.get(i).getValue() != "ya"){
                    if (visitados.get(nodos.get(i))){
                        respuesta.add(new ArrayList<>());
                        parte=respuesta.get((respuesta.size()-1));
                        parte.add(nodos.get(i).getValue());
                        nodos.get(i).setValue("ya");
                    }
                }
            }
        }
        
        return respuesta;
    }

    public void algorithmBFS(Graph graph, Node nodoInicial, Map<Node,Boolean> visitados, Map<Node, List<Edge>>listaAdyacencia){
        //Cola Queue
        List<Node> salaEspera = new ArrayList<>();
        
        salaEspera.add(nodoInicial);
        
        while(salaEspera.size()!=0){
            visitados.put(salaEspera.get(0), true);
            Node revisando=salaEspera.get(0);
            salaEspera.remove(0);
    
            List<Edge> hijos=listaAdyacencia.get(revisando);
    
            for (Edge arco: hijos){
                Node nodo=arco.nodeV();
                if (!visitados.get(nodo))
                    salaEspera.add(nodo);
            }
        }
    }
}
