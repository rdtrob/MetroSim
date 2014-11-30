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
        InputDevice inputDevice = new InputDevice();
        OutputHandler outputHandler = new OutputHandler();
        Parser parser = new Parser();
        outputHandler.printString("\n");
        outputHandler.printString("Metro system planner \n");
        outputHandler.printString("Available commands: \n");
        while (cmd.contentEquals("5") != true) {
            outputHandler.printString("\n");
            outputHandler.printString("1. Print locations \n");
            outputHandler.printString("2. Print routes \n");
            outputHandler.printString("3. Get the fastest/shortest/cheapest route \n");
            outputHandler.printString("4. Simulate \n");
            outputHandler.printString("5. Exit \n");
            cmd = inputDevice.getKeyboardInput();
            switch (cmd) {
                case "1":
                    for (Node i : map.getNodes()) {
                        outputHandler.printString(i.getName() + " \n");
                    }
                    break;
                case "2":
                    outputHandler.printString("Input current location: ");
                    cmd = inputDevice.getKeyboardInput();
                    if (map.containsNodeName(cmd) == true) {
                        routeHandler.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        outputHandler.printString("\nInput destination: ");
                        cmd = inputDevice.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            routeHandler.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            outputHandler.printString("\nAvailable connections:\n\n");
                            routeHandler.findAllConnections();
                        } else
                            outputHandler.print("Location unavailable \n");
                    } else
                        outputHandler.print("Location unavailable \n");
                    break;
                case "3":
                    int type = 0;
                    outputHandler.printString("Would you like to know the quickest, shortest or cheapest route? \n");
                    cmd = inputDevice.getKeyboardInput();
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
                            outputHandler.printString("Invalid route /n");
                            break;
                    }
                    outputHandler.printString("Input current location: ");
                    cmd = inputDevice.getKeyboardInput();
                    if (map.containsNodeName(cmd) == true) {
                        routeHandler.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        dijkstra.execute(map.getNode(map.mapNodeToIndex(cmd)), type);
                        outputHandler.printString("\nInput destination: ");
                        cmd = inputDevice.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            routeHandler.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            route = dijkstra.getPath(map.getNode(map.mapNodeToIndex(cmd)), type, route);
                            outputHandler.printString("Connection: \n");
                            outputHandler.print(route);
                        } else
                            outputHandler.print("Location unavailable \n");
                    } else
                        outputHandler.print("Location unavailable \n");
                    break;
                case "4":
                    outputHandler.printString("Input current location: ");
                    cmd = inputDevice.getKeyboardInput();
                    if (map.containsNodeName(cmd) == true) {
                        routeHandler.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        dijkstra.execute(map.getNode(map.mapNodeToIndex(cmd)), 1);
                        outputHandler.printString("\nInput destination: ");
                        cmd = inputDevice.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            routeHandler.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            route = dijkstra.getPath(map.getNode(map.mapNodeToIndex(cmd)), 1, route);
                            parser.parse(route);
                        } else
                            outputHandler.print("Location unavailable \n");
                    } else
                        outputHandler.print("Location unavailable \n");
                    break;
                case "5":
                    break;
                default:
                    outputHandler.printString("Invalid option \n");
            }
        }
    }


}