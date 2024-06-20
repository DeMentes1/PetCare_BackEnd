package pe.upc.petcarebackend.payment.domain.services;

import pe.upc.petcarebackend.payment.domain.model.aggregates.Payment;
import pe.upc.petcarebackend.payment.domain.model.commands.CreatePaymentCommand;
import pe.upc.petcarebackend.payment.domain.model.commands.ProcessTransactionCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle(CreatePaymentCommand command);
    Optional<Payment> handle(ProcessTransactionCommand command);
}
