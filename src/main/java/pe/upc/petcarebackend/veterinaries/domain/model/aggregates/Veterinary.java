package pe.upc.petcarebackend.veterinaries.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.ProfileId;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.VeterinaryRecordId;

@Getter
@Entity
public class Veterinary extends AuditableAbstractAggregateRoot<Veterinary> {

    @Getter
    @Embedded
    @Column(name = "veterinary_id")
    private final VeterinaryRecordId veterinaryRecordId;

    @Embedded
    private ProfileId profileId;


    /*
    private String name;
    private String address;
    private String description;
    private String phone;
     */

    public Veterinary(){
        this.veterinaryRecordId = new VeterinaryRecordId();
        //agregar uno mas - Veterinary status
    }

    public Veterinary(Long profileId){
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Veterinary(ProfileId profileId){
        this();
        this.profileId = profileId;
    }

    //agregar veterinary-status

    //record?
    public String getVeterinaryId(){return this.veterinaryRecordId.toString(); }

    public Long getProfileId(){return this.profileId.profileId(); }


    //agregar gets de vet-status

}
