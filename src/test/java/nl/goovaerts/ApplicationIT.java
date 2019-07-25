package nl.goovaerts;

import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationIT {

    @LocalServerPort
    private int port;

    @Test
    void shouldReturnResponseForValidRequest() {
        RestTemplate template = new RestTemplate();
        String url = String.format("http://localhost:%d/bmi/calculate", port);
        BmiRequest request = new BmiRequest(2, 1, 1);

        ResponseEntity<BmiResponse> response = template.postForEntity(url, request, BmiResponse.class);

        Assertions.assertNotNull(response.getBody());
    }
}