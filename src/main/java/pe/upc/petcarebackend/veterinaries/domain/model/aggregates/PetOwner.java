package pe.upc.petcarebackend.veterinaries.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.context.annotation.Profile;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.AppoinmentStatus;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.PetOwnerRecordId;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.ProfileId;

@Getter
@Entity
public class PetOwner extends AuditableAbstractAggregateRoot<PetOwner> {

   /*private String name;
    private String lastname;
    private String phone;
    private String email;
    private String address;*/

    @Getter
    @Embedded
    @Column(name="petowner_id")
    private PetOwnerRecordId petOwnerRecordId;

    @Getter
    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @Embedded
    private ProfileId profileId;

    private AppoinmentStatus status;

    public PetOwner() {}

    public PetOwner(Pet pet){
        //this.petOwnerRecordId = petOwnerRecordId;
        this.pet = pet;
        this.status=AppoinmentStatus.NOT_STARTED;
    }

    public PetOwner(Long profileId){
        this();
        this.profileId = new ProfileId(profileId);
    }

    public PetOwner(ProfileId profileId){
        this();
        this.profileId = profileId;
    }

    public Long getProfileId() {
        return this.profileId.profileId();
    }

    public void confirm(){
        this.status=AppoinmentStatus.CONFIRMED;
    }

    public void reschedule(){
        this.status=AppoinmentStatus.RESCHEDULED;
    }

    public void complete(){
        this.status=AppoinmentStatus.COMPLETED;
    }

    public void cancel(){
        this.status=AppoinmentStatus.CANCELLED;
    }

    public String getStatus(){return this.status.name().toLowerCase();}

    public boolean isConfirmed(){return this.status.equals(AppoinmentStatus.CONFIRMED);}

    public boolean isCancelled(){return this.status == AppoinmentStatus.CANCELLED;}

}
