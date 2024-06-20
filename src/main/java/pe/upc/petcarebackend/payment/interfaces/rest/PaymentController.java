package pe.upc.petcarebackend.payment.interfaces.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.petcarebackend.payment.domain.model.queries.FindPaymentByIdQuery;
import pe.upc.petcarebackend.payment.domain.services.PaymentCommandService;
import pe.upc.petcarebackend.payment.domain.services.PaymentQueryService;
import pe.upc.petcarebackend.payment.interfaces.rest.resources.CreatePaymentResource;
import pe.upc.petcarebackend.payment.interfaces.rest.resources.PaymentResource;
import pe.upc.petcarebackend.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import pe.upc.petcarebackend.payment.interfaces.rest.transform.PaymentResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v1/payments", produces = APPLICATION_JSON_VALUE)
public class PaymentController {

    private final PaymentCommandService paymentCommandService;
    private final PaymentQueryService paymentQueryService;

    public PaymentController(PaymentCommandService paymentCommandService, PaymentQueryService paymentQueryService) {
        this.paymentCommandService = paymentCommandService;
        this.paymentQueryService = paymentQueryService;
    }

    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource createPaymentResource) {
        var createPaymentCommand = CreatePaymentCommandFromResourceAssembler.toCommandFromResource(createPaymentResource);
        var payment = paymentCommandService.handle(createPaymentCommand);

        if (payment.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Retrieve the created payment by its ID
        var getPaymentByIdQuery = new FindPaymentByIdQuery(payment.get().getId()); // Pass paymentId here
        // Check if payment exists
        if (payment.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Convert payment entity to payment resource
        var paymentResource = PaymentResourceFromEntityAssembler.toResourceFromEntity(payment.get());

        // Return response with created payment resource and HTTP status CREATED
        return new ResponseEntity<>(paymentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResource> getPaymentById(@PathVariable Long paymentId) {
        var getPaymentByIdQuery = new FindPaymentByIdQuery(paymentId);
        var payment = paymentQueryService.handle(getPaymentByIdQuery);

        // Check if payment exists
        if (payment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Convert payment entity to payment resource
        var paymentResource = PaymentResourceFromEntityAssembler.toResourceFromEntity(payment.get());

        // Return response with payment resource and HTTP status OK
        return ResponseEntity.ok(paymentResource);
    }
}
