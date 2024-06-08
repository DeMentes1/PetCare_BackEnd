package pe.upc.petcarebackend.veterinaries.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileId(Long profileId) {
    public ProfileId {
        if (profileId < 0) {
            throw new IllegalArgumentException("ProfileId cannot be negative");
        }
    }

    public ProfileId() {
        this(0L);
    }
}
