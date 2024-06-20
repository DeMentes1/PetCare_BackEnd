package pe.upc.petcarebackend.payment.domain.model.commands;

import pe.upc.petcarebackend.payment.domain.model.valueObjects.Amount;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.PaymentMethod;

public record CreatePaymentCommand(PaymentMethod paymentMethod, Amount amount) {
}
