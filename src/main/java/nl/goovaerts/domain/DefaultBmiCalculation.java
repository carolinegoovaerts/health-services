package nl.goovaerts.domain;

import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;

public class DefaultBmiCalculation implements BmiCalculation {

    private static double determineBmiFor(BmiRequest request) {
        final double weight = request.getWeight();
        final double length = request.getLength();
        final int age = request.getAge();

        if (age < 2 || weight < 1 || length < 1) {
            throw new IllegalArgumentException();
        }

        return weight / (length * length);
    }

    @Override
    public BmiResponse process(BmiRequest request) {
        return new BmiResponse(determineBmiFor(request));
    }
}
