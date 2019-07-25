package nl.goovaerts.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BmiRequest {

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
}
