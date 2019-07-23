package nl.goovaerts.api;

import nl.goovaerts.DataFixtures;
import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BmiCalculationEndpointTest {

    @Test
    void shouldReturnBmiResponseForBmiRequest() {
        // Arrange
        BmiResponse expected = new BmiResponse(22d);
        BmiCalculationEndpoint endpoint = new BmiCalculationEndpoint(request -> expected);

        // Act
        BmiRequest request = DataFixtures.bmiRequestForAgeLengthWeight(2, 1, 1);

        // Assert
        Assertions.assertEquals(expected, endpoint.calculate(request));
    }
}
