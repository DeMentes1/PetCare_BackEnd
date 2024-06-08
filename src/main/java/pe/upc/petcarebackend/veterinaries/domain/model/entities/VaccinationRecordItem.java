package pe.upc.petcarebackend.veterinaries.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.upc.petcarebackend.shared.domain.model.entities.AuditableModel;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Pet;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.VaccinationStatus;

import java.util.Date;

@Getter
@Entity
public class VaccinationRecordItem extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    @JoinColumn(name="pet_id")
    private Pet pet;

    @OneToOne
    @NotNull
    @JoinColumn(name="veterinary_id")
    private Veterinary veterinary;

    @Getter
    private String vaccineName;
    private VaccinationStatus status;

    private Date startedAt;

    private Date completedAt;

    public VaccinationRecordItem(Pet pet, Veterinary veterinary, String vaccineName) {
        this.pet = pet;
        this.veterinary = veterinary;
        this.vaccineName = vaccineName;
        this.status = VaccinationStatus.NOT_STARTED;
    }

    public VaccinationRecordItem(){}

    public void start(){
        this.status = VaccinationStatus.STARTED;
        this.startedAt = new Date();
    }

    public void complete(){
        this.status = VaccinationStatus.COMPLETED;
        this.completedAt = new Date();
    }

    public boolean isCompleted(){return this.status == VaccinationStatus.COMPLETED;}

    public boolean isStarted(){return this.status == VaccinationStatus.STARTED;}

    public boolean isNotStarted(){return this.status == VaccinationStatus.NOT_STARTED;}
}
