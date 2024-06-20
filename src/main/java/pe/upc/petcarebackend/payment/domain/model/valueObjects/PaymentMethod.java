package pe.upc.petcarebackend.payment.domain.model.valueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PaymentMethod(String method) {
    public PaymentMethod{
        if (method == null || method.isBlank()) {
            throw new IllegalArgumentException("Payment method cannot be null or blank");
        }
    }
}
