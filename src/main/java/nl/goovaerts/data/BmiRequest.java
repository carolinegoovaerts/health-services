package nl.goovaerts.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class BmiRequest {

    private final int age;
    private final double length;
    private final double weight;

    @JsonCreator
    public BmiRequest(@JsonProperty("age") int age,
                      @JsonProperty("length") double length,
                      @JsonProperty("weight") double weight) {
        this.age = age;
        this.length = length;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BmiRequest request = (BmiRequest) o;
        return age == request.age &&
                Double.compare(request.length, length) == 0 &&
                Double.compare(request.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, length, weight);
    }

    @Override
    public String toString() {
        return "BmiRequest{" +
                "age=" + age +
                ", length=" + length +
                ", weight=" + weight +
                '}';
    }
}
