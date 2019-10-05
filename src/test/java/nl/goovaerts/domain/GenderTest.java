package nl.goovaerts.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GenderTest {

    @Test
    void shouldContainExpectedValues() {
        Set<String> expected = Set.of("FEMALE", "MALE", "OTHER");

        Set<String> actual = Stream.of(Gender.values())
                .map(Gender::toString)
                .collect(Collectors.toSet());

        Assertions.assertEquals(expected, actual);
    }
}
