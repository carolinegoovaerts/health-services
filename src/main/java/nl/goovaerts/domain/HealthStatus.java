package nl.goovaerts.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public final class HealthStatus {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dateOfReport;
    private Double lengthInMeters;
    private Double weightInKilograms;

    @ManyToOne
    private Person person;

    private HealthStatus(LocalDate date, double length, double weight) {
        this.dateOfReport = date;
        this.lengthInMeters = length;
        this.weightInKilograms = weight;
    }

    public static HealthStatus ofDateLengthAndWeight(LocalDate date, double length, double weight) {
        return new HealthStatus(date, length, weight);
    }

    @Override
    public String toString() {
        return "HealthStatus{" +
                "id=" + id +
                ", dateOfReport=" + dateOfReport +
                ", lengthInMeters=" + lengthInMeters +
                ", weightInKilograms=" + weightInKilograms +
                '}';
    }
}
