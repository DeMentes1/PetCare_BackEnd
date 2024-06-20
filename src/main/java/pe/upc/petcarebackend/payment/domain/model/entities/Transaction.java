package pe.upc.petcarebackend.payment.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.upc.petcarebackend.payment.domain.model.aggregates.Payment;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.Amount;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.TransactionID;
import pe.upc.petcarebackend.shared.domain.model.entities.AuditableModel;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Transaction extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @NotNull
    private TransactionID transactionId;

    @NotNull
    private LocalDateTime transactionDate;

    @Embedded
    @NotNull
    private Amount amount;

    @Setter
    @ManyToOne
    @JoinColumn(name = "payment_id")
    @NotNull
    private Payment payment;

    public Transaction(TransactionID transactionId, LocalDateTime transactionDate, Amount amount, Payment payment) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.payment = payment;
    }

}
