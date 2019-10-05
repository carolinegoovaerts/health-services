package nl.goovaerts.orm;

import nl.goovaerts.domain.Gender;
import nl.goovaerts.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PersonRepositoryIT {

    @Autowired
    private PersonRepository repository;

    @Test
    void shouldReadAndWriteWithDatabase() {
        // Arrange
        LocalDate dateOfBirth = LocalDate.of(1935, Month.JANUARY, 8);
        Person elvis = Person.create("Elvis", "Presley", dateOfBirth, Gender.MALE);

        // Act
        Person elvisJustWritten = repository.save(elvis);
        Optional<Person> elvisJustRead = repository.findById(elvisJustWritten.getId());

        // Assert
        Assertions.assertEquals(Optional.of(elvis), elvisJustRead);
    }
}
