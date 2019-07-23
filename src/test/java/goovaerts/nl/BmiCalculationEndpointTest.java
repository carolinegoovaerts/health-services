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
        Assertions.assertNotNull(endpoint.calculate(new BmiRequest()));
    }
}
