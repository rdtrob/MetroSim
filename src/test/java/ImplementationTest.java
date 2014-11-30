/**
 * Created by robert on 11/30/14.
 */

import org.junit.Test;
import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ImplementationTest {

    private List<Vertex> nodes;
    private List<Edge> edges;

    @Test
    public void testExcute() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 11; i++) {
            Vertex station = new Vertex("Node_" + i);
            nodes.add(station);
        }

        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 217);
        addLane("Edge_2", 0, 4, 173);
        addLane("Edge_3", 2, 6, 186);
        addLane("Edge_4", 2, 7, 103);
        addLane("Edge_5", 3, 7, 183);
        addLane("Edge_6", 5, 8, 250);
        addLane("Edge_7", 8, 9, 84);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 4, 9, 502);
        addLane("Edge_10", 9, 10, 40);
        addLane("Edge_11", 1, 10, 600);

        // check from location Loc_1 to Loc_10
        GraphCreator graph = new GraphCreator();
        Implementation dijkstra = new Implementation(graph);
        dijkstra.execute(nodes.get());
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get());

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Graph lane = new Graph(laneId, nodes.get(), nodes.get(), duration) {
            @Override
            public void addNode(Node node) {
                //TODO
            }

            @Override
            public List<Node> getNodes() {
                return null;
            }

            @Override
            public List<Edge> getEdges() {
                return null;
            }

            @Override
            public void addEdge(Edge edge) {

            }

            @Override
            public Node getNode(int index) {
                return null;
            }

            @Override
            public int mapNodeToIndex(String name) {
                return 0;
            }

            @Override
            public boolean containsNodeName(String name) {
                return false;
            }
        };
        edges.add(lane);
    }
}
