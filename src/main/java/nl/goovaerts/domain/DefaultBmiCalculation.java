package nl.goovaerts.domain;

import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class DefaultBmiCalculation implements BmiCalculation {

    private static final MathContext PRECISION_3_HALF_UP = new MathContext(3, RoundingMode.HALF_UP);

    private static double determineBmiFor(BmiRequest request) {
        final double weight = request.getWeight();
        final double length = request.getLength();
        final int age = request.getAge();

        if (age < 2 || weight < 1 || length < 1) {
            throw new IllegalArgumentException();
        }

        return weight / (length * length);
    }

    private static BigDecimal rounded(double bmi) {
        return BigDecimal.valueOf(bmi).round(PRECISION_3_HALF_UP);
    }

    @Override
    public BmiResponse process(BmiRequest request) {
        double bmi = determineBmiFor(request);
        return new BmiResponse(rounded(bmi));
    }
}
