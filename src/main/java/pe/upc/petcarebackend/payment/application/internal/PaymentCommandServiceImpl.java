package pe.upc.petcarebackend.payment.application.internal;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.payment.domain.model.aggregates.Payment;
import pe.upc.petcarebackend.payment.domain.model.commands.CreatePaymentCommand;
import pe.upc.petcarebackend.payment.domain.model.commands.ProcessTransactionCommand;
import pe.upc.petcarebackend.payment.domain.model.entities.Transaction;
import pe.upc.petcarebackend.payment.domain.services.PaymentCommandService;
import pe.upc.petcarebackend.payment.infraestructure.persistence.jpa.repositories.PaymentRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        Payment payment = new Payment(
                command.paymentMethod(),
                command.amount()
        );
        return Optional.of(paymentRepository.save(payment));
    }

    @Override
    public Optional<Payment> handle(ProcessTransactionCommand command) {
        Optional<Payment> optionalPayment = paymentRepository.findById(command.paymentId());
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            Transaction transaction = new Transaction(
                    command.transactionId(),
                    LocalDateTime.now(),
                    command.amount(),
                    payment
            );
            payment.addTransaction(transaction);
            return Optional.of(paymentRepository.save(payment));
        } else {
            return Optional.empty();
        }
    }
}
