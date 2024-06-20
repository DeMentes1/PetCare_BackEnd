package pe.upc.petcarebackend.payment.domain.model.valueObjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record TransactionID(String transactionID) {
    public TransactionID(){
        this(UUID.randomUUID().toString());
    }

    public TransactionID{
        if (transactionID == null || transactionID.isBlank()){
            throw new IllegalArgumentException("Transaction ID cannot be null or empty");
        }
    }
}
