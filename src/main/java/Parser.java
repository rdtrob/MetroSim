/**
 * Created by robert on 11/24/14.
 */

public class Parser {
    public OutputHandler printer;

    public Parser() {
        printer = new OutputHandler();
    }

    public void parse(Route connection) {
        printer.printString("\nStarting simulation \n\n");
        Edge j = new Line();
        j = connection.getLines().getFirst();
        for (Edge i : connection.getLines()) {
            if (i.getType().equals(j.getType())) {
                printer.printString("Departed from station " + i.getSource().getName() + " via " + i.getType() + "\n");
                printer.printString("Travelled " + i.getWeight(1) / i.getWeight(0) + " seconds with an average speed of "
                        + i.getWeight(0) + " km/h\n");
                if (i.equals(connection.getLines().getLast())) {
                    printer.printString("Arrived at " + i.getDestination().getName() + " station\n");
                }
            } else {
                printer.printString("Changed " + j.getType() + " with " + i.getType() + "\n");
                printer.printString("Departed from  " + i.getSource().getName() + " station " + " via " + i.getType() + "\n");
                printer.printString("Travelled " + i.getWeight(1) / i.getWeight(0) + " seconds with an average speed of "
                        + i.getWeight(0) + " km/h\n\n");
                if (i.equals(connection.getLines().getLast())) {
                    printer.printString("Arrived at " + i.getDestination().getName() + " station\n");
                }
            }
            j = i;
        }
    }
}