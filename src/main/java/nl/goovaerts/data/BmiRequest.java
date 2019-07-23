package nl.goovaerts.data;

public class BmiRequest {

    private final int age;
    private final double length;
    private final double weight;

    public BmiRequest(int age, double length, double weight) {
        this.age = age;
        this.length = length;
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }
}
