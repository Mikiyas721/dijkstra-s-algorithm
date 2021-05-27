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

        System.out.println("The number of edges are " + weightedGraph.getEdgeCount());
        System.out.println("The weight of the edge between vertex 1 and vertex 2 " + weightedGraph.getEdgeWeight(1, 2));
        System.out.println("The Degree of vertex 4 is " + weightedGraph.getVertexDegree(4));

        System.out.println("\n********* Result of evaluating the graph for shortest path, taking the vertex with value 1 as starting vertex ***********");
        System.out.println("Distance between vertex 1 and vertex 3 is " + weightedGraph.getShortestDistance(1, 3));
        System.out.println("Distance between vertex 1 and vertex 2 is " + weightedGraph.getShortestDistance(1, 2));
        System.out.println("Distance between vertex 1 and vertex 4 is " + weightedGraph.getShortestDistance(1, 4));
        System.out.println("Distance between vertex 1 and vertex 5 is " + weightedGraph.getShortestDistance(1, 5));


    }
}
