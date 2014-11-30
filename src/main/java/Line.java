/**
 * Created by robert on 11/24/14.
 */

public class Line implements Edge {
    private Node source;
    private Node destination;
    private String type;    //type of transportation method made at edge level
    private int averageSpeed;
    private int distance;
    private int cost;

    public Line() {
        //TODO
    }

    public Line(String type) {
        this.type = type;
    }

    public Line(String type, Node source, Node destination, int speed, int distance, int cost) {
        this.type = type;
        this.source = source;
        this.destination = destination;
        this.averageSpeed = speed;
        this.distance = distance;
        this.cost = cost;
        source.addLine(this);
    }

    public Line(String type, Node source, Node destination, int speed, int distance, int cost, boolean isBidirectional) {
        this.type = type;
        this.source = source;
        this.destination = destination;
        this.averageSpeed = speed;
        this.distance = distance;
        this.cost = cost;
        source.addLine(this);
        createReverseEdge(type, source, destination, speed, distance, cost);
    }

    public Line(Edge copy) {
        this.type = copy.getType();
        this.source = new Station(copy.getSource());
        this.destination = new Station(copy.getDestination());
        this.averageSpeed = copy.getWeight(0);
        this.distance = copy.getWeight(1);
        this.cost = copy.getWeight(2);
    }

    //getter/setter functions
    public Node getSource() {
        return this.source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return this.destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight(int type) {
        switch (type) {
            case 0:
                return this.averageSpeed;
            case 1:
                return this.distance;
            case 2:
                return this.cost;
            default:
                return 0;
        }
    }

    public void setWeight(int weight, int type) {
        switch (type) {
            case 0:
                this.averageSpeed = weight;
            case 1:
                this.distance = weight;
            case 2:
                this.cost = weight;
            default:
                //do nothing
        }
    }

    public void createReverseEdge(String type, Node source, Node destination, int speed, int distance, int cost) {
        new Line(type, destination, source, speed, distance, cost);
    }
}