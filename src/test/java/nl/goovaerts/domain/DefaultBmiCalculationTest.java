package nl.goovaerts.domain;

import nl.goovaerts.DataFixtures;
import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class DefaultBmiCalculationTest {

    private DefaultBmiCalculation bmiCalculation;

    @BeforeEach
    void setUp() {
        bmiCalculation = new DefaultBmiCalculation();
    }

    @Test
    void shouldReturnExpectedBmiResponse() {
        BmiRequest request = DataFixtures.bmiRequestForAgeLengthWeight(25, 1.75, 67);
        BmiResponse response = bmiCalculation.process(request);

        Assertions.assertEquals(BigDecimal.valueOf(21.9), response.getValue());
    }

    @Test
    void shouldRejectRequestWhenAgeLessThan2() {
        BmiRequest request = DataFixtures.bmiRequestForAgeLengthWeight(1, 1.75, 60);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bmiCalculation.process(request));
    }

    @Test
    void shouldRejectRequestWhenWeightLessThan1() {
        BmiRequest request = DataFixtures.bmiRequestForAgeLengthWeight(2, 1, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bmiCalculation.process(request));
    }

    @Test
    void shouldRejectRequestWhenLengthLessThan1() {
        BmiRequest request = DataFixtures.bmiRequestForAgeLengthWeight(2, 0, 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bmiCalculation.process(request));
    }

    @Test
    void shouldRoundValueAtOneDecimal() {
        BmiRequest request = DataFixtures.bmiRequestForAgeLengthWeight(20, 1.73, 64.5);
        Assertions.assertEquals(BigDecimal.valueOf(21.6), bmiCalculation.process(request).getValue());
    }
}
