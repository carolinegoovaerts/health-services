package nl.goovaerts.orm;

import nl.goovaerts.domain.Gender;
import nl.goovaerts.domain.HealthStatus;
import nl.goovaerts.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PersonRepositoryIT {

    @Autowired
    private PersonRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void shouldStoreAndFetchPerson() {
        // Arrange
        LocalDate dateOfBirth = LocalDate.of(1935, Month.JANUARY, 8);
        Person elvis = Person.full("Elvis", "Presley", dateOfBirth, Gender.MALE);

        // Act
        Person storedElvis = repository.save(elvis);
        Optional<Person> fetchedElvis = repository.findById(storedElvis.getId());

        // Assert
        Assertions.assertEquals(Optional.of(elvis), fetchedElvis);
    }

    @Test
    void x() {
        LocalDate farPastDate = LocalDate.MIN;
        double weight = 117.9;
        double length = 1.83;

        HealthStatus healthStatus = HealthStatus.ofDateLengthAndWeight(farPastDate.plusYears(1), length, weight);

        Person person = Person.fullWithHealthStatus("A", "B", farPastDate, Gender.FEMALE, healthStatus);

        Person persisted = repository.save(person);
        Optional<Person> optionalPerson = repository.findById(persisted.getId());

        Person fetchedPerson = optionalPerson.orElseThrow();
        Assertions.assertEquals(Set.of(healthStatus), fetchedPerson.getHealthStatuses());
    }
}
