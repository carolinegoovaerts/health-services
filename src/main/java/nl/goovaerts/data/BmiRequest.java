package nl.goovaerts.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BmiRequest {

    private int age;
    private double length;
    private double weight;

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
