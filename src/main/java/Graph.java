import java.util.List;

/**
 * Created by robert on 11/24/14.
 */

public interface Graph {
    public void addNode(Node node);

    public List<Node> getNodes();

    public List<Edge> getEdges();

    public void addEdge(Edge edge);

    public Node getNode(int index);

    public int mapNodeToIndex(String name);

    public boolean containsNodeName(String name);
}
