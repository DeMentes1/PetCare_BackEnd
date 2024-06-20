package pe.upc.petcarebackend.payment.application.internal;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.payment.domain.model.aggregates.Payment;
import pe.upc.petcarebackend.payment.domain.model.queries.FindPaymentByIdQuery;
import pe.upc.petcarebackend.payment.domain.model.queries.FindPaymentsByStatusQuery;
import pe.upc.petcarebackend.payment.domain.services.PaymentQueryService;
import pe.upc.petcarebackend.payment.infraestructure.persistence.jpa.repositories.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Optional<Payment> handle(FindPaymentByIdQuery query) {
        return paymentRepository.findById(query.paymentId());
    }

    @Override
    public List<Payment> handle(FindPaymentsByStatusQuery query) {
        return paymentRepository.findByStatus(query.status());
    }
}
