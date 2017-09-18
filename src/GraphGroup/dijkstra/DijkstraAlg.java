package GraphGroup.dijkstra;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import GraphGroup.dijkstra.Vertex;
import GraphGroup.dijkstra.Edge;
import GraphGroup.dijkstra.Graph;

/**
 * Created by baiwe on 2017/7/28.
 */
public class DijkstraAlg {

    private final List<Vertex> nodes;
    private final List<Edge> edges;

    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public DijkstraAlg(Graph graph){
        this.nodes = new ArrayList<Vertex>(graph.getVertexes());
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    public void execute(Vertex source){
        settledNodes = new HashSet<Vertex>();
        unSettledNodes = new HashSet<Vertex>();
        distance = new HashMap<Vertex, Integer>();
        predecessors = new HashMap<Vertex, Vertex>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0){
            Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistance(node);
        }
    }

    private void findMinimalDistance(Vertex node){
        List<Vertex> adjacentNodes = getNeighbors(node);
        for (Vertex target : adjacentNodes){
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)){
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private int getDistance(Vertex node, Vertex target){
        for (Edge edge : edges){
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)){
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex node){
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for (Edge edge : edges){
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())){
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex){
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Vertex destination){
        Integer d = distance.get(destination);
        if (d == null){
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

}
