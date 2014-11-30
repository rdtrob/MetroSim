/**
 * Created by robert on 11/28/14.
 */

public class RouteHandler {
    private Node startLocation;
    private Node endLocation;

    public Node getStartLocation() {
        return this.startLocation;
    }

    public void setStartLocation(Node source) {
        this.startLocation = source;
    }

    public Node getEndLocation() {
        return this.endLocation;
    }

    public void setEndLocation(Node destination) {
        this.endLocation = destination;
    }

    public void findAllConnections() {
        findAll(new Route(), startLocation, endLocation);
    }

    private void findAll(Route route, Node A, Node B) {
        route.addLocation(A);
        if (A == B) {
            OutputDevice printer = new OutputDevice();
            printer.print(route);
        } else {
            for (Edge i : A.getLines()) {
                if (route.isLocationIn(i.getDestination())) {
                    // do nothing
                } else {
                    route.addLine(i);
                    findAll(route, i.getDestination(), B);
                    if (route.getLines().isEmpty()) {
                        // do nothing
                    } else {
                        route.removeLastLine();
                    }
                    route.removeLastLocation();
                }
            }
        }
    }
}