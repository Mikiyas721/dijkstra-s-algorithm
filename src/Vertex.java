public class Vertex {
    private int value;
    private boolean known;
    private double distance;

   /* Vertex(int value, boolean known, double distance) {
        this.value = value;
        this.known = known;
        this.distance = distance;
    }*/

    Vertex(int value) {
        this.value = value;
        this.known = false;
        this.distance = 0;
    }

    boolean isKnown() {
        return known;
    }

    void setKnown(boolean known) {
        this.known = known;
    }

    double getDistance() {
        return distance;
    }

    void setDistance(double distance) {
        this.distance = distance;
    }

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
