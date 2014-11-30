/**
 * Created by robert on 11/28/14.
 */

class Controller {
    public static void main(String args[]) {
        String cmd = "";
        Graph map;
        GraphCreator mapCreator = new GraphCreator();
        RouteHandler planner = new RouteHandler();
        mapCreator.createDefaultMap();
        map = mapCreator.getGraph();
        Implementation dijkstra = new Implementation(map);
        Route route = new Route();
        InputDevice keyboard = new InputDevice();
        OutputDevice printer = new OutputDevice();
        Parser simulator = new Parser();
        printer.printString("\n");
        printer.printString("Metro system planner \n");
        printer.printString("Here's a list of what you can do: \n");
        while (cmd.contentEquals("5") != true) {
            printer.printString("\n");
            printer.printString("1 View all location names \n");
            printer.printString("2 View all connections from point A to point B \n");
            printer.printString("3 Get the fastest/shortest/cheapest connection from point A to point B \n");
            printer.printString("4 Simulate the travel from on location to another \n");
            printer.printString("5 Exit \n");
            printer.printString("What would you like to do? \n");
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
                        planner.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        printer.printString("\nInput destination: ");
                        cmd = keyboard.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            planner.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            printer.printString("\nAll available connections:\n\n");
                            planner.findAllConnections();
                        } else
                            printer.print("Not an available location \n");
                    } else
                        printer.print("Not an available location \n");
                    break;
                case "3":
                    int type = 0;
                    printer.printString("Which type of connection would you like to get? (fastest/shortest/cheapest)\n");
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
                            printer.printString("Not a valid connection /n");
                            break;
                    }
                    printer.printString("Input current location: ");
                    cmd = keyboard.getKeyboardInput();
                    if (map.containsNodeName(cmd) == true) {
                        planner.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        dijkstra.execute(map.getNode(map.mapNodeToIndex(cmd)), type);
                        printer.printString("\nInput destination: ");
                        cmd = keyboard.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            planner.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            route = dijkstra.getPath(map.getNode(map.mapNodeToIndex(cmd)), type, route);
                            printer.printString("Connection: \n");
                            printer.print(route);
                        } else
                            printer.print("Unavailable location \n");
                    } else
                        printer.print("Unavailable location \n");
                    break;
                case "4":
                    printer.printString("Input current location: ");
                    cmd = keyboard.getKeyboardInput();
                    if (map.containsNodeName(cmd) == true) {
                        planner.setStartLocation(map.getNode(map.mapNodeToIndex(cmd)));
                        dijkstra.execute(map.getNode(map.mapNodeToIndex(cmd)), 1);
                        printer.printString("\nInput destination: ");
                        cmd = keyboard.getKeyboardInput();
                        if (map.containsNodeName(cmd) == true) {
                            planner.setEndLocation(map.getNode(map.mapNodeToIndex(cmd)));
                            route = dijkstra.getPath(map.getNode(map.mapNodeToIndex(cmd)), 1, route);
                            simulator.simulate(route);
                        } else
                            printer.print("Unavailable location \n");
                    } else
                        printer.print("Unavailable location \n");
                    break;
                case "5":
                    break;
                default:
                    printer.printString("Invalid option \n");
            }
        }
    }


}