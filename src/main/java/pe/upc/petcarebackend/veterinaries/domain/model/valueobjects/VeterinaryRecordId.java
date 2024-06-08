package pe.upc.petcarebackend.veterinaries.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record VeterinaryRecordId(String veterinaryId) {
    public VeterinaryRecordId() {this(UUID.randomUUID().toString()); }

    public VeterinaryRecordId {
        if (veterinaryId == null || veterinaryId.isBlank()) {
            throw new IllegalArgumentException("veterinaryId cannot be null or blank");
        }
    }
}
