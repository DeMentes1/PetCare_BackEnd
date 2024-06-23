package pe.upc.petcarebackend.bookings.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PetId(Long petId) {
    public PetId {
        if (petId < 0) {
            throw new IllegalArgumentException("ProfileId cannot be negative");
        }
    }

    public PetId() {
        this(0L);
    }
}
