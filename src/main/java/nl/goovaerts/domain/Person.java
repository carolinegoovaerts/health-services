package nl.goovaerts.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public final class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<HealthStatus> healthStatuses = new HashSet<>();

    // Hide constructor since it is only used internally
    private Person(String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public static Person full(String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        return new Person(firstName, lastName, dateOfBirth, gender);
    }

    public static Person fullWithHealthStatus(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, HealthStatus status) {
        Person person = new Person(firstName, lastName, dateOfBirth, gender);
        person.addHealthStatus(status);
        return person;
    }

    public Long getId() {
        return id;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    Gender getGender() {
        return gender;
    }

    private void addHealthStatus(HealthStatus status) {
        this.healthStatuses.add(status);
    }

    public Set<HealthStatus> getHealthStatuses() {
        return healthStatuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(dateOfBirth, person.dateOfBirth) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }
}
