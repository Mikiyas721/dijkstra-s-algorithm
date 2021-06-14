public class Main {
    public static void main(String[] args) {
        WeightedGraph weightedGraph = new WeightedGraph(5);
        weightedGraph.insertVertex(1);
        weightedGraph.insertVertex(2);
        weightedGraph.insertVertex(3);
        weightedGraph.insertVertex(4);
        weightedGraph.insertVertex(5);

        weightedGraph.insertEdge(1, 2, 10);
        weightedGraph.insertEdge(2, 3, 1);
        weightedGraph.insertEdge(1, 4, 5);
        weightedGraph.insertEdge(4, 2, 3);
        weightedGraph.insertEdge(4, 3, 9);
        weightedGraph.insertEdge(4, 5, 2);
        weightedGraph.insertEdge(5, 3, 6);

        System.out.println("The number of edges is " + weightedGraph.getEdgeCount());
        System.out.println("The number of vertices is " + weightedGraph.getVertexCount());

        weightedGraph.shortestPathWeight(1);
        System.out.println("\nVertices\tDistance from vertex "+1+"\tPrevious Vertex");
        for (Vertex vertex:weightedGraph.getVertices()) {
            System.out.print("\t"+vertex.getValue()+"\t\t\t\t  "+vertex.getDistance()+"\t\t\t\t\t"+vertex.getPreviousVertexValue()+"\n");
        }


    }
}
