import java.util.ArrayList;
import java.util.List;


class WeightedGraph {
    private Vertex[] vertices;
    private ArrayList<Edge> edgeList;

    WeightedGraph() {
        vertices = new Vertex[50];
        edgeList = new ArrayList<>();
    }

    WeightedGraph(int numberOfVertex) {
        if (numberOfVertex <= 0) {
            vertices = new Vertex[1];
        } else {
            vertices = new Vertex[numberOfVertex];
        }
        edgeList = new ArrayList<>();
    }

    int getVertexDegree(int vertexValue) {
        return (int) edgeList.stream().filter(edge -> edge.getFirstVertex().getValue() == vertexValue ||
                edge.getSecondVertex().getValue() == vertexValue).count();
    }

    int getEdgeCount() {
        return edgeList.size();
    }

    double getEdgeWeight(int firstValue, int secondValue) {
        if (!vertexExist(firstValue) || !vertexExist(secondValue)) throw new IllegalArgumentException();
        else if (firstValue == secondValue) return 0;

        for (Edge edge : edgeList) {
            if (edge.getFirstVertex().getValue() == firstValue && edge.getSecondVertex().getValue() == secondValue)
                return edge.getWeight();
        }
        return Double.MAX_VALUE;
    }

    void insertEdge(int firstValue, int secondValue, double edgeWeight) {
        if (edgeWeight <= 0 || edgeWeight == Double.MAX_VALUE ||
                firstValue == secondValue || !vertexExist(firstValue) ||
                !vertexExist(secondValue))
            throw new IllegalArgumentException();

        boolean edgeExist = false;

        for (Edge edge : edgeList) {
            if (edge.getFirstVertex().getValue() == firstValue && edge.getSecondVertex().getValue() == secondValue /*||
                    edge.getSecondVertex().getValue() == firstValue && edge.getFirstVertex().getValue() == secondValue*/) {
                edge.setWeight(edgeWeight);
                edgeExist = true;
                break;
            }
        }
        if (!edgeExist) {
            edgeList.add(new Edge(edgeWeight, getVertex(firstValue), getVertex(secondValue)));
        }
    }

    void insertVertex(int vertexValue) {
        if (vertexValue <= 0 || vertexExist(vertexValue)) throw new IllegalArgumentException();
        else {
            for (int i = 0; i < vertices.length; i++) {
                if (vertices[i] == null) {
                    vertices[i] = new Vertex(vertexValue);
                    break;
                }
            }
        }
    }

    double getShortestDistance(int firstValue, int secondValue) {
        if (!vertexExist(firstValue) || !vertexExist(secondValue)) throw new IllegalArgumentException();
        else if (vertexExist(firstValue) && firstValue == secondValue) return 0;
        else {
            return shortestPathWeight(firstValue, secondValue);
        }
    }

    private boolean vertexExist(int value) {
        for (Vertex vertex : vertices) {
            if (vertex == null) break;
            else {
                if (vertex.getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private double shortestPathWeight(int firstValue, int secondValue) {
        setUpAll();
        getVertex(firstValue).setDistance(0);
        Vertex currentVertex = getVertex(firstValue);
        while (hasUnknown()) {
            if (currentVertex == null) currentVertex = getOneUnknownVertex();
            ArrayList<Edge> edges = getEdges(currentVertex.getValue());
            currentVertex.setKnown(true);
            double nextPathDistance = Double.MAX_VALUE;
            for (Edge edge : edges) {
                if (edge.getSecondVertex().getDistance() > currentVertex.getDistance() + edge.getWeight())
                    edge.getSecondVertex().setDistance(currentVertex.getDistance() + edge.getWeight());
                if (edge.getWeight() < nextPathDistance) {
                    nextPathDistance = edge.getWeight();
                }
            }
            currentVertex = getSecondVertex(currentVertex, nextPathDistance);
        }
        return getVertex(secondValue).getDistance();
    }

    private void setUpAll() {
        for (Vertex vertex : vertices) {
            if (vertex != null) {
                vertex.setDistance(Double.MAX_VALUE);
                vertex.setKnown(false);
            }
        }
    }

    private boolean hasUnknown() {
        for (Vertex vertex : vertices) {
            if (vertex != null && !vertex.isKnown()) return true;
        }
        return false;
    }

    private Vertex getVertex(int vertexValue) {
        for (Vertex vertex : vertices) {
            if (vertex.getValue() == vertexValue) return vertex;
        }
        return null;
    }

    private ArrayList<Edge> getEdges(int value) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (Edge edge : edgeList) {
            if (edge.getFirstVertex().getValue() == value)
                edges.add(edge);
        }
        return edges;
    }

    private Vertex getSecondVertex(Vertex firstVertex, double edgeWeight) {
        List<Edge> edges = getEdges(firstVertex.getValue());
        for (Edge edge : edges) {
            if (edge.getWeight() == edgeWeight && !edge.getSecondVertex().isKnown()) return edge.getSecondVertex();
        }
        return null;
    }

    private Vertex getOneUnknownVertex() {
        for (Vertex vertex : vertices) {
            if (!vertex.isKnown()) return vertex;
        }
        return null;
    }

}
