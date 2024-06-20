package pe.upc.petcarebackend.payment.domain.services;

import pe.upc.petcarebackend.payment.domain.model.aggregates.Payment;
import pe.upc.petcarebackend.payment.domain.model.queries.FindPaymentByIdQuery;
import pe.upc.petcarebackend.payment.domain.model.queries.FindPaymentsByStatusQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    Optional<Payment> handle(FindPaymentByIdQuery query);
    List<Payment> handle(FindPaymentsByStatusQuery query);
}
