/**
 * Created by robert on 11/24/14.
 */

public class GraphCreator {
    private Graph graph;

    public GraphCreator() {
        this.graph = new Metro("Timisoara");
    }

    public Graph getGraph() {
        return this.graph;
    }

    public void createDefaultMap() {
        /**
         * As arrays start from an index 0, the first location will be of pos 0
         */
        graph.addNode(new Station("UMT"));
        graph.addNode(new Station("Statia Meteo"));
        graph.addNode(new Station("Spitalul Victor Babes"));
        graph.addNode(new Station("Dorobantilor"));
        /**
         * Commented nodes below for Bus routes
         */
        //graph.addNode(new Station("Simion Barnutiu"));
        //graph.addNode(new Station("Renasterii"));
        //graph.addNode(new Station("Samuel Micu"));
        //graph.addNode(new Station("Badea Cartan"));
        //graph.addNode(new Station("IJPT"));
        //graph.addNode(new Station("Aurel Popovici"));
        //graph.addNode(new Station("Bastion"));
        //graph.addNode(new Station("Oituz"));
        //graph.addNode(new Station("Marasti"));
        //graph.addNode(new Station("Spitalul Louis Turcanu"));
        //graph.addNode(new Station("Republicii"));
        //graph.addNode(new Station("Pop de Basesti"));
        //graph.addNode(new Station("Gheorghe Baritiu"));
        graph.addNode(new Station("Lalelelor"));
        graph.addNode(new Station("Andrei Saguna"));
        graph.addNode(new Station("Ion Mihalache"));
        graph.addNode(new Station("Piata Traian"));
        graph.addNode(new Station("Bvd. 3 August"));
        graph.addNode(new Station("Prefectura"));
        graph.addNode(new Station("Hotel Continental"));
        graph.addNode(new Station("Piata Libertatii"));
        graph.addNode(new Station("Piata 700"));
        graph.addNode(new Station("Catedrala"));
        graph.addNode(new Station("Piata Maria"));
        graph.addNode(new Station("Sinaia"));
        graph.addNode(new Station("Carol I"));
        graph.addNode(new Station("Gara Nord"));

        //create transport lines
        //Tramway 4
        graph.addEdge(new Line("Tramway 4", graph.getNode(0), graph.getNode(1), 10, 40, 2, true));
        graph.addEdge(new Line("Tramway 4", graph.getNode(1), graph.getNode(2), 5, 30, 2, true));
        graph.addEdge(new Line("Tramway 4", graph.getNode(2), graph.getNode(10), 15, 100, 4, true));
        graph.addEdge(new Line("Tramway 4",graph.getNode(10),graph.getNode(13),10,50,2,true));
        graph.addEdge(new Line("Tramway 4",graph.getNode(13),graph.getNode(14),5,30,2,true));
        graph.addEdge(new Line("Tramway 4",graph.getNode(14),graph.getNode(15),5,30,2,true));
        //Tramway 8
        graph.addEdge(new Line("Tramway 8", graph.getNode(1), graph.getNode(2), 5, 30, 2, true));
        graph.addEdge(new Line("Tramway 8", graph.getNode(2), graph.getNode(3), 20, 40, 2, true));
        graph.addEdge(new Line("Tramway 8", graph.getNode(3), graph.getNode(4), 10, 50, 2, true));
        graph.addEdge(new Line("Tramway 8", graph.getNode(4), graph.getNode(9), 10, 80, 4, true));
        graph.addEdge(new Line("Tramway 8",graph.getNode(9),graph.getNode(11),5,100,4,true));
        //Tramway 9
        graph.addEdge(new Line("Tramway 9", graph.getNode(1), graph.getNode(5), 10, 60, 4, true));
        graph.addEdge(new Line("Tramway 9", graph.getNode(5), graph.getNode(6), 15, 20, 2, true));
        graph.addEdge(new Line("Tramway 9", graph.getNode(6), graph.getNode(7), 15, 50, 2, true));
        //Tramway 5
        graph.addEdge(new Line("Tramway 5",graph.getNode(15),graph.getNode(14),10,30,2,true));
        graph.addEdge(new Line("Tramway 5",graph.getNode(14),graph.getNode(13),50,30,2,true));
        graph.addEdge(new Line("Tramway 5",graph.getNode(13),graph.getNode(10),15,50,2,true));
        //graph.addEdge(new Line("Tramway 5",graph.getNode(10),graph.getNode(2),10,100,4,true));
        //graph.addEdge(new Line("Tramway 5", graph.getNode(2), graph.getNode(3), 15, 40, 2, true));
        //graph.addEdge(new Line("Tramway 5", graph.getNode(3), graph.getNode(4), 10, 50, 2, true));
        //graph.addEdge(new Line("Tramway 5", graph.getNode(4), graph.getNode(9), 15, 80, 4, true));
        //graph.addEdge(new Line("Tramway 5",graph.getNode(9),graph.getNode(11),10,100,4,true));
        //graph.addEdge(new Line("Tramway 5",graph.getNode(11),graph.getNode(12),10,40,2,true));
        //graph.addEdge(new Line("Tramway 5",graph.getNode(12),graph.getNode(15),5,50,2,true));
        //Bus 15
        graph.addEdge(new Line("Bus 15", graph.getNode(6), graph.getNode(4), 15, 40, 2, true));
        graph.addEdge(new Line("Bus 15", graph.getNode(4), graph.getNode(8), 15, 30, 2, true));
        graph.addEdge(new Line("Bus 15",graph.getNode(8),graph.getNode(16),10,60,4,true));
        //Bus 16
        graph.addEdge(new Line("Bus 16", graph.getNode(5), graph.getNode(4), 10, 40, 2, true));
        graph.addEdge(new Line("Bus 16", graph.getNode(4), graph.getNode(8), 10, 30, 2, true));
        graph.addEdge(new Line("Bus 16",graph.getNode(8),graph.getNode(16),10,60,4,true));
        //Bus E2
        graph.addEdge(new Line("Bus E2", graph.getNode(1), graph.getNode(5), 20, 70, 4, true));
        graph.addEdge(new Line("Bus E2", graph.getNode(5), graph.getNode(4), 10, 50, 2, true));
        graph.addEdge(new Line("Bus E2", graph.getNode(4), graph.getNode(8), 15, 30, 2, true));
        //graph.addEdge(new Line("Bus E2",graph.getNode(8),graph.getNode(16),15,60,4,true));
        //graph.addEdge(new Line("Bus E2",graph.getNode(16),graph.getNode(17),5,50,2,true));
        //graph.addEdge(new Line("Bus E2",graph.getNode(17),graph.getNode(15),10,40,2,true));
    }
}