package pe.upc.petcarebackend.veterinaries.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Pet extends AuditableAbstractAggregateRoot<Pet> {

    private String name;
    private String lastname;
    private Number age;

    public Pet() {
        this.name= Strings.EMPTY;
        this.lastname= Strings.EMPTY;
        this.age= null;
    }

    public Pet(String name) {
        this();
        this.name = name;
    }



}
