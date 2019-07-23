package goovaerts.nl;

class BmiRequest {

    private final int age;
    private final double length;
    private final double weight;

    BmiRequest(int age, double length, double weight) {
        this.age = age;
        this.length = length;
        this.weight = weight;
    }

    double getLength() {
        return length;
    }

    double getWeight() {
        return weight;
    }
}
