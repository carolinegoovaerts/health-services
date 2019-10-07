package nl.goovaerts.orm;

import nl.goovaerts.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    // Spring Data JPA magic
}
