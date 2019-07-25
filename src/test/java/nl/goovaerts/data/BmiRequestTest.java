package nl.goovaerts.data;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.stream.Stream;

class BmiRequestTest {

    private static Consumer<Integer> verify(String info) {
        return integer -> Assertions.assertTrue(info.contains(Integer.toString(integer)), failMessage(integer));
    }

    private static String failMessage(Integer integer) {
        return String.format("Should contain %d", integer);
    }

    @Test
    void shouldFollowEqualsContract() {
        EqualsVerifier.forClass(BmiRequest.class).verify();
    }

    @Test
    void shouldContainAllAccessibleInformation() {
        String info = new BmiRequest(2, 1, 30).toString();
        Stream.of(2, 1, 30).forEach(verify(info));
    }
}