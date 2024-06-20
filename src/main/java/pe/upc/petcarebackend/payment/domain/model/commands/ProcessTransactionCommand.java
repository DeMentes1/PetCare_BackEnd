package pe.upc.petcarebackend.payment.domain.model.commands;

import pe.upc.petcarebackend.payment.domain.model.valueObjects.Amount;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.TransactionID;

import java.time.LocalDateTime;

public record ProcessTransactionCommand(Long paymentId, TransactionID transactionId, LocalDateTime transactionDate, Amount amount) {}

