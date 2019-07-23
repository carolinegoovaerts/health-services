package goovaerts.nl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BmiCalculationEndpointTest {

    @Test
    void shouldReturnBmiResponse() {
        BmiCalculationEndpoint endpoint = new BmiCalculationEndpoint();
        BmiResponse response = endpoint.calculate(new Object());

        Assertions.assertNotNull(response);
    }
}
