package pe.upc.petcarebackend.payment.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.upc.petcarebackend.payment.domain.model.entities.Transaction;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.Amount;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.PaymentMethod;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.PaymentStatus;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Payment extends AuditableAbstractAggregateRoot<Payment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @NotNull
    private PaymentMethod paymentMethod;

    @Embedded
    @NotNull
    private Amount amount;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PaymentStatus status;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Transaction> transactions = new ArrayList<>();

    public Payment(PaymentMethod paymentMethod, Amount amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        transaction.setPayment(this);
    }
}
