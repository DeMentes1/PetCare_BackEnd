package pe.upc.petcarebackend.payment.domain.model.valueObjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record paymentID(String paymentID) {
    public paymentID() {
        this(UUID.randomUUID().toString());
    }

    public paymentID{
        if (paymentID == null || paymentID.isBlank()) {
            throw new IllegalArgumentException("id cannot be null or empty");
        }
    }
}
