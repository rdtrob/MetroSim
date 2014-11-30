/**
 * Created by robert on 11/24/14.
 */

public class Main {
    public static void main(String args[]) {
        String cmd = "";
        Graph map;
        GraphCreator mapCreator = new GraphCreator();
        RouteHandler routeHandler = new RouteHandler();
        mapCreator.createDefaultMap();
        map = mapCreator.getGraph();
        Implementation dijkstra = new Implementation(map);
        Route route = new Route();
        InputDevice keyboard = new InputDevice();
        OutputHandler printer = new OutputHandler();
        Parser parser = new Parser();
        printer.printString("\n");
        printer.printString("Metro system planner \n");
        printer.printString("Available commands: \n");
        while (cmd.contentEquals("5") != true) {
            printer.printString("\n");
            printer.printString("1. Print locations \n");
            printer.printString("2. Print routes \n");
            printer.printString("3. Get the fastest/shortest/cheapest route \n");
            printer.printString("4. Simulate \n");
            printer.printString("5. Exit \n");
            cmd = keyboard.getKeyboardInput();
            switch (cmd) {
                case "1":
                    for (Node i : map.getNodes()) {
                        printer.printString(i.getName() + " \n");
                    }
                    break;
                case "2":
                    printer.printString("Input current location: ");
                    cmd = keyboard.getKeyboardInput();
                    if (map.containsNodeName(cmd) == true) {
                        routeHandler.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        printer.printString("\nInput destination: ");
                        cmd = keyboard.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            routeHandler.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            printer.printString("\nAvailable connections:\n\n");
                            routeHandler.findAllConnections();
                        } else
                            printer.print("Location unavailable \n");
                    } else
                        printer.print("Location unavailable \n");
                    break;
                case "3":
                    int type = 0;
                    printer.printString("Would you like to know the quickest, shortest or cheapest route? \n");
                    cmd = keyboard.getKeyboardInput();
                    switch (cmd) {
                        case "quickest":
                            type = 0;
                            break;
                        case "shortest":
                            type = 1;
                            break;
                        case "cheapest":
                            type = 2;
                            break;
                        default:
                            //Logger
                            printer.printString("Invalid route /n");
                            break;
                    }
                    printer.printString("Input current location: ");
                    cmd = keyboard.getKeyboardInput();
                    if (map.containsNodeName(cmd) == true) {
                        routeHandler.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        dijkstra.execute(map.getNode(map.mapNodeToIndex(cmd)), type);
                        printer.printString("\nInput destination: ");
                        cmd = keyboard.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            routeHandler.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            route = dijkstra.getPath(map.getNode(map.mapNodeToIndex(cmd)), type, route);
                            printer.printString("Connection: \n");
                            printer.print(route);
                        } else
                            printer.print("Location unavailable \n");
                    } else
                        printer.print("Location unavailable \n");
                    break;
                case "4":
                    printer.printString("Input current location: ");
                    cmd = keyboard.getKeyboardInput();
                    if (map.containsNodeName(cmd) == true) {
                        routeHandler.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        dijkstra.execute(map.getNode(map.mapNodeToIndex(cmd)), 1);
                        printer.printString("\nInput destination: ");
                        cmd = keyboard.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            routeHandler.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            route = dijkstra.getPath(map.getNode(map.mapNodeToIndex(cmd)), 1, route);
                            parser.parse(route);
                        } else
                            printer.print("Location unavailable \n");
                    } else
                        printer.print("Location unavailable \n");
                    break;
                case "5":
                    break;
                default:
                    printer.printString("Invalid option \n");
            }
        }
    }


}