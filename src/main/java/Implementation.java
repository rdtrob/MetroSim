/**
 * Created by robert on 11/28/14.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Implementation {
    private final List<Edge> edges;
    private Set<Node> settledNodes;
    private Set<Node> unSettledNodes;
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distance;

    public Implementation(Graph graph) {
        // create a copy of the array so that we can operate on this array
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    public void execute(Node source, int type) {
        this.settledNodes = new HashSet<Node>();
        this.unSettledNodes = new HashSet<Node>();
        this.distance = new HashMap<Node, Integer>();
        this.predecessors = new HashMap<Node, Node>();
        this.distance.put(source, 0);
        this.unSettledNodes.add(source);
        while (this.unSettledNodes.size() > 0) {
            Node node = getMinimum(this.unSettledNodes);
            this.settledNodes.add(node);
            this.unSettledNodes.remove(node);
            findMinimalDistances(node, type);
        }
    }

    private void findMinimalDistances(Node node, int type) {
        List<Node> adjacentNodes = getNeighbors(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target, type)) {
                this.distance.put(target, getShortestDistance(node)
                        + getDistance(node, target, type));
                this.predecessors.put(target, node);
                this.unSettledNodes.add(target);
            }
        }

    }

    private int getDistance(Node node, Node target, int type) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight(type);
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Node getMinimum(Set<Node> vertexes) {
        Node minimum = null;
        for (Node vertex : vertexes) {
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

    private boolean isSettled(Node vertex) {
        return this.settledNodes.contains(vertex);
    }

    private int getShortestDistance(Node destination) {
        Integer d = this.distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * Method returns the path from the source to the selected target &&
     * NULL if no path exists
     */
    public Route getPath(Node target, int type, Route path) {
        Node step = target;
        // path checker
        if (this.predecessors.get(step) == null) {
            return null;
        }
        path.addLocation(step);
        while (this.predecessors.get(step) != null) {
            step = this.predecessors.get(step);
            path.addLocation(step);
        }
        // sorts the order
        Collections.reverse(path.getLocations());
        path = this.saveEdges(path, type);
        return path;
    }

    public Route saveEdges(Route connection, int type) {
        for (int i = 0; i + 1 < connection.getLocations().size(); i++) {
            Edge toSave = new Line();
            int min = 200;
            for (Edge j : connection.getLocations().get(i).getLines()) {
                if (j.getDestination().equals(connection.getLocations().get(i + 1))) {
                    if (j.getWeight(type) < min) {
                        min = j.getWeight(type);
                        toSave = j;
                    }
                }
            }
            connection.addLine(toSave);
        }
        return connection;
    }
}