package pe.upc.petcarebackend.payment.interfaces.rest.transform;

import pe.upc.petcarebackend.payment.domain.model.commands.CreatePaymentCommand;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.Amount;
import pe.upc.petcarebackend.payment.domain.model.valueObjects.PaymentMethod;
import pe.upc.petcarebackend.payment.interfaces.rest.resources.CreatePaymentResource;

import java.math.BigDecimal;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        BigDecimal amountValue = new BigDecimal(resource.amount());
        Amount amount = new Amount(amountValue);
        PaymentMethod paymentMethod = new PaymentMethod(resource.paymentmethod());
        return new CreatePaymentCommand(paymentMethod, amount);
    }
}
