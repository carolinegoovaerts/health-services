package nl.goovaerts.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class PersonTest {

    @Test
    void shouldCreateExpectedObject() {
        LocalDate dateOfBirth = LocalDate.of(2019, Month.APRIL, 1);

        Person person = Person.create("c", "g", dateOfBirth, Gender.FEMALE);

        Assertions.assertEquals("c", person.getFirstName());
        Assertions.assertEquals("g", person.getLastName());
        Assertions.assertEquals(dateOfBirth, person.getDateOfBirth());
        Assertions.assertEquals(Gender.FEMALE, person.getGender());
    }

    @Test
    void shouldFollowEqualsContract() {
        EqualsVerifier.forClass(Person.class)
                .withIgnoredFields("id")
                .verify();
    }
}
