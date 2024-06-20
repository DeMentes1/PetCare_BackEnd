package pe.upc.petcarebackend.payment.domain.model.valueObjects;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record Amount(BigDecimal value) {
    public Amount{
        if(value == null || value.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}

