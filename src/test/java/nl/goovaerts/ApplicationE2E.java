package nl.goovaerts;

import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationE2E {

    private RestTemplate template;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        template = new RestTemplate();
    }

    @Test
    void shouldReturnResponseForValidRequest() {
        String bmiCalculatorUrl = String.format("http://localhost:%d/bmi/calculate", port);
        BmiRequest request = new BmiRequest(2, 1, 1);

        ResponseEntity<BmiResponse> response = template.postForEntity(bmiCalculatorUrl, request, BmiResponse.class);

        Assertions.assertNotNull(response.getBody());
    }

    //TODO verify contents of <h1/> using Webdriver

}
