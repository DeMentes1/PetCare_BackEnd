package pe.upc.petcarebackend.veterinaries.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record PetOwnerRecordId(String petOwnerId) {
    public PetOwnerRecordId() {this(UUID.randomUUID().toString());}

    public PetOwnerRecordId {
        if(petOwnerId == null || petOwnerId.isBlank()){
            throw new IllegalArgumentException("Pet owner profileId cannot be null or blank");
        }
    }
}
