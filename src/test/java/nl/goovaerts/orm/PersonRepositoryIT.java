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
        Person person = aPerson();

        Person writtenPerson = repository.save(person);
        Optional<Person> readPerson = repository.findById(writtenPerson.getId());

        Assertions.assertTrue(readPerson.isPresent());
        Assertions.assertEquals(person, readPerson.get());
    }

    private static Person aPerson() {
        return Person.create("c", "g", LocalDate.MIN, Gender.FEMALE);
    }
}
