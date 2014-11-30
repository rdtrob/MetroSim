/**
 * Created by robert on 11/28/14.
 */

import java.util.List;
import java.util.ArrayList;

//implements the graph using array lists
public class Metro implements Graph {
    private String name;
    private List<Node> locations;
    private List<Edge> lines;

    //constructor
    public Metro(String name) {
        this.name = name;
        this.locations = new ArrayList<Node>();
        this.lines = new ArrayList<Edge>();
    }

    //getter/setter functions
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNode(Node node) {
        this.locations.add(node);
    }

    public List<Node> getNodes() {
        return this.locations;
    }

    public void addEdge(Edge edge) {
        this.lines.add(edge);
    }

    public List<Edge> getEdges() {
        return this.lines;
    }

    public Node getNode(int index) {
        return this.locations.get(index);
    }

    public int mapNodeToIndex(String name) {
        int j = 0;
        for (Node i : this.getNodes()) {
            if (i.getName().equals(name)) {
                break;
            } else
                j++;
        }

        return j;
    }

    public boolean containsNodeName(String name) {
        boolean isFound = false;
        for (Node i : this.getNodes()) {
            if (i.getName().equals(name))
                isFound = true;
        }
        return isFound;
    }
}
