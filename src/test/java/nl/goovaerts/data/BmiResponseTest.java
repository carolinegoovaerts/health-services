package nl.goovaerts.data;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BmiResponseTest {

    @Test
    void shouldFollowEqualsContract() {
        EqualsVerifier.forClass(BmiResponse.class).verify();
    }

    @Test
    void shouldContainBmiValue() {
        String objectInfo = new BmiResponse(22d).toString();
        Assertions.assertTrue(objectInfo.contains("22"));
    }
}