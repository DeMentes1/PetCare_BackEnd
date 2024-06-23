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

    @Getter
    @Embedded
    @Column(name="petowner_id")
    private final PetOwnerRecordId petOwnerRecordId;

    @Getter
    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @Embedded
    private ProfileId profileId;

    private AppoinmentStatus status;

    public PetOwner() {

        this.petOwnerRecordId = new PetOwnerRecordId();
        this.status=AppoinmentStatus.NOT_STARTED;
    }

    public PetOwner(Long profileId, Pet pet){
        this();
        this.profileId = new ProfileId(profileId);
        this.pet = pet != null ? pet : new Pet();
        this.status=AppoinmentStatus.NOT_STARTED;
    }

    public PetOwner(ProfileId profileId){
        this();
        this.profileId = profileId;
    }



    public String getOwnerRecordId() {
        return this.petOwnerRecordId != null ? this.petOwnerRecordId.petOwnerId() : "unknown";
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

    public String getStatus() {
        return this.status != null ? this.status.name(): "NOT_STARTED";
    }

    public boolean isConfirmed(){return this.status.equals(AppoinmentStatus.CONFIRMED);}

    public boolean isCancelled(){return this.status == AppoinmentStatus.CANCELLED;}

}
