package pe.upc.petcarebackend.payment.infraestructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.petcarebackend.payment.domain.model.aggregates.Payment;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.PaymentStatus;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStatus(PaymentStatus status);
}
