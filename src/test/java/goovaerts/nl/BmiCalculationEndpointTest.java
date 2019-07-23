package goovaerts.nl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BmiCalculationEndpointTest {

    private BmiCalculationEndpoint endpoint;

    private static BmiRequest bmiRequestForAgeLengthWidth(int age, double length, double weight) {
        return new BmiRequest(age, length, weight);
    }

    @BeforeEach
    void setUp() {
        endpoint = new BmiCalculationEndpoint();
    }

    @Test
    void shouldReturnBmiResponseForBmiRequest() {
        BmiRequest request = bmiRequestForAgeLengthWidth(2, 1, 1);
        Assertions.assertNotNull(endpoint.calculate(request));
    }

    @Test
    void shouldReturnExpectedBmiResponse() {
        BmiRequest request = bmiRequestForAgeLengthWidth(45, 1.75, 67.375);
        BmiResponse response = endpoint.calculate(request);
        Assertions.assertEquals(22d, response.getValue());
    }

    // TODO reject age < 2
    // TODO reject weight < 1
    // TODO reject length < 1

    // TODO use Spring framework for bean wiring, REST interface and validation?
}
