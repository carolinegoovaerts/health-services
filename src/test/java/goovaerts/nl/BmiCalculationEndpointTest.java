package goovaerts.nl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BmiCalculationEndpointTest {

    private BmiCalculationEndpoint endpoint;

    @BeforeEach
    void setUp() {
        endpoint = new BmiCalculationEndpoint();
    }

    @Test
    void shouldReturnBmiResponseForBmiRequest() {
        int age = 45;
        int length = 175;
        int weight = 65;

        Assertions.assertNotNull(endpoint.calculate(new BmiRequest(age, length, weight)));
    }
}
