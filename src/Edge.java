public class Edge {

    private double weight;
    private Vertex firstVertex;
    private Vertex secondVertex;

    Edge(double weight, Vertex firstVertex, Vertex secondVertex) {
        this.weight = weight;
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    double getWeight() {
        return weight;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }

    Vertex getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(Vertex firstVertex) {
        this.firstVertex = firstVertex;
    }

    Vertex getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(Vertex secondVertex) {
        this.secondVertex = secondVertex;
    }

}
