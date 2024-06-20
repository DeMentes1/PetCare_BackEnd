package pe.upc.petcarebackend.veterinaries.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreatePetCommand;

@Getter
@Entity
public class Pet extends AuditableAbstractAggregateRoot<Pet> {

    private String name;
    private String lastname;
    private Integer age;

    public Pet() {
        this.name= Strings.EMPTY;
        this.lastname= Strings.EMPTY;
        this.age= 0;
    }

    public Pet(String name, String lastname, Integer age) {
        this();
        this.name = name;
        this.lastname= lastname;
        this.age= age;
    }

    public Pet(CreatePetCommand command) {
        this();
        this.name = command.name();
        this.lastname= command.lastname();
        this.age = command.age();
    }

}
