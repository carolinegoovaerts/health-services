package nl.goovaerts.data;

public class BmiRequest {

    private int age;
    private double length;
    private double weight;

    // TODO use constructor injection with @JsonCreator
    public BmiRequest(int age, double length, double weight) {
        this.age = age;
        this.length = length;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
