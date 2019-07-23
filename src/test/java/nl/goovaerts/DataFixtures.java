package nl.goovaerts;

import nl.goovaerts.data.BmiRequest;

public final class DataFixtures {

    public static BmiRequest bmiRequestForAgeLengthWeight(int age, double length, double weight) {
        return new BmiRequest(age, length, weight);
    }
}
