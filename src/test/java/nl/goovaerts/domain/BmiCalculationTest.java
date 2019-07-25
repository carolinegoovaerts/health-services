package nl.goovaerts.domain;

import nl.goovaerts.DataFixtures;
import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BmiCalculationTest {

    private DefaultBmiCalculation bmiCalculation;

    @BeforeEach
    void setUp() {
        bmiCalculation = new DefaultBmiCalculation();
    }

    @Test
    void shouldReturnExpectedBmiResponse() {
        BmiRequest request = DataFixtures.bmiRequestForAgeLengthWeight(45, 1.75, 67.375);
        BmiResponse response = bmiCalculation.process(request);
        Assertions.assertEquals(22d, response.getValue());
    }

    @Test
    void shouldRejectRequestWhenAgeLessThan2() {
        BmiRequest request = DataFixtures.bmiRequestForAgeLengthWeight(1, 1, 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bmiCalculation.process(request));
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
}
