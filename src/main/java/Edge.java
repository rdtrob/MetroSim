/**
 * Created by robert on 11/28/14.
 */

public interface Edge {
    public Node getSource();
    public void setSource(Node startNode);
    public Node getDestination();
    public void setDestination(Node endNode);
    public int getWeight(int type);
    public void setWeight(int weight, int type);
    public String getType();
    public void setType(String type);
    public void createReverseEdge(String type, Node source, Node destination, int speed, int distance, int cost);
}

