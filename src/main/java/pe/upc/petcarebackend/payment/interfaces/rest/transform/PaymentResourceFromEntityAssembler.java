package pe.upc.petcarebackend.payment.interfaces.rest.transform;

import pe.upc.petcarebackend.payment.domain.model.aggregates.Payment;
import pe.upc.petcarebackend.payment.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {
    public static PaymentResource toResourceFromEntity(Payment entity){
        return new PaymentResource(entity.getId(),entity.getTransactionId().toString(), entity.getPaymentMethod().toString(), entity.getAmount().toString());
    }
}
