/**
 * Created by robert on 11/28/14.
 */

import java.util.LinkedList;

/**
 * saves the route between two locations
 */
public class Route {
    private LinkedList<Edge> lines;
    private LinkedList<Node> locations;
    private int averageSpeed = 1000;    // could be float for better accuracy
    private int distance = 1000;        // total distance from point A to point B
    private int cost = 1000;            // total cost from point A to point B

    public Route() {
        this.lines = new LinkedList<Edge>();
        this.locations = new LinkedList<Node>();
    }

    public Route(Route copy) {
        for (Edge i : copy.getLines())
            this.lines.add(new Line(i));
        for (Node i : copy.getLocations())
            this.locations.add(new Station(i));
        this.averageSpeed = copy.averageSpeed;
        this.distance = copy.distance;
        this.cost = copy.cost;
    }

    public void addLocation(Node location) {
        this.locations.addLast(location);
    }

    public void removeLastLocation() {
        this.locations.removeLast();
    }

    public void removeLastLine() {
        this.lines.removeLast();
    }

    public Boolean isLocationIn(Node node) {
        if (this.locations.contains(node))
            return true;
        else
            return false;
    }

    public void addLine(Edge line) {
        this.lines.addLast(line);
    }

    public LinkedList<Edge> getLines() {
        return this.lines;
    }

    public LinkedList<Node> getLocations() {
        return this.locations;
    }

    public int getRouteWeight(int type) {
        if (this.getLines().size() == 0) {
            return 0;
        } else {
            this.averageSpeed = 0;
            this.distance = 0;
            this.cost = 0;
            switch (type) {
                case 0:
                    for (Edge i : this.getLines())
                        this.averageSpeed += i.getWeight(0);
                    this.averageSpeed = this.averageSpeed / this.getLines().size();
                    /**
                     * avg speed calculated based on how many lines the Route has
                     */
                    return this.averageSpeed;
                case 1:
                    for (Edge i : this.getLines())
                        this.distance += i.getWeight(1);
                    return this.distance;
                case 2:
                    for (Edge i : this.getLines())
                        this.cost += i.getWeight(2);
                    return this.cost;
                default:
                    return 0;
            }
        }

    }

    public String toString() {
        StringBuilder printable = new StringBuilder();
        if (this.getLines().isEmpty()) {
            /**
             * TODO
             */
        } else {
            for (Edge i : this.getLines()) {
                printable.append(i.getSource().getName() + " -> ");
                if (i.equals(this.getLines().getLast()))
                    printable.append(this.getLines().getLast().getDestination().getName());
            }
            printable.append("\nAverage speed of " + this.getRouteWeight(0));
            printable.append("\nDistance of " + this.getRouteWeight(1));
            printable.append("\nTotal cost of " + this.getRouteWeight(2) + " \n\n");
        }
        this.averageSpeed = 0;
        this.distance = 0;
        this.cost = 0;
        return printable.toString();
    }
}