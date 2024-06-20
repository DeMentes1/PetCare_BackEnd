package pe.upc.petcarebackend.veterinaries.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.*;

@Getter
@Entity
public class Veterinary extends AuditableAbstractAggregateRoot<Veterinary> {

    @Getter
    @Embedded
    @Column(name = "veterinary_id")
    private final VeterinaryRecordId veterinaryRecordId;

    @Embedded
    private ProfileId profileId;
    private String description;
    private VeterinaryStatus status;

    /*
    private String name;
    private String description;
    private String phone;
     */

    public Veterinary() {
        this.veterinaryRecordId = new VeterinaryRecordId();
        this.description= Strings.EMPTY;
    }

    public Veterinary(Long profileId, String description){
        this();
        this.profileId = new ProfileId(profileId);
        this.description=description;
        this.status= VeterinaryStatus.CLOSED;

    }

    public Veterinary(ProfileId profileId){
        this();
        this.profileId = profileId;
    }

    public String getVeterinaryId(){return this.veterinaryRecordId.veterinaryId(); }

    public Long getProfileId(){return this.profileId.profileId(); }

    public String getStatus(){return this.status.name().toLowerCase();}

    public void open(){
        this.status=VeterinaryStatus.OPENED;
    }

    public void close(){
        this.status=VeterinaryStatus.CLOSED;
    }

    public void allday(){ this.status=VeterinaryStatus.ALL_DAY; }

    public boolean isOpened(){return this.status.equals(VeterinaryStatus.OPENED);}

    public boolean isClosed(){return this.status == VeterinaryStatus.CLOSED;}
    public boolean isAllDay(){return this.status == VeterinaryStatus.ALL_DAY;}


}
