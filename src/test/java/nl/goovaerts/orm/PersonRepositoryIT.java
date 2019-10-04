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
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PersonRepositoryIT {

    @Autowired
    private PersonRepository repository;

    @Test
    void shouldReadAndWriteWithDatabase() {
        // Arrange
        LocalDate farPastDate = LocalDate.MIN;
        Person person = Person.create("C", "G", farPastDate, Gender.FEMALE);

        // Act
        Person persistedPerson = repository.save(person);
        Optional<Person> optionalPerson = repository.findById(persistedPerson.getId());

        // Assert
        Assertions.assertEquals(Optional.of(person), optionalPerson);
    }
}
