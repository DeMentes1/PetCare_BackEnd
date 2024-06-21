package pe.upc.petcarebackend.payment.interfaces.rest.resources;

public record PaymentResource(Long id, String transactionId, String paymentmethod, String amount) {
}
