package pe.upc.petcarebackend.payment.domain.model.queries;

import pe.upc.petcarebackend.payment.domain.model.valueObjects.PaymentStatus;

public record FindPaymentsByStatusQuery(PaymentStatus status) {}

