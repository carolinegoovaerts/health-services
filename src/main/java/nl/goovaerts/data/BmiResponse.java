package nl.goovaerts.data;

public class BmiResponse {

    private final double value;

    public BmiResponse(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
