package pe.upc.petcarebackend.bookings.interfaces.rest.transform;

import pe.upc.petcarebackend.bookings.domain.model.commands.CreateBookingCommand;
import pe.upc.petcarebackend.bookings.interfaces.rest.resources.BookingResource;
import pe.upc.petcarebackend.bookings.interfaces.rest.resources.CreateBookingResource;

public class CreateBookingCommandFromResourceAssembler {
    public static CreateBookingCommand toCommandFromResource( CreateBookingResource resource) {
        return new CreateBookingCommand(
                resource.services(),
                resource.date(),
                resource.ownerName(),
                resource.ownerNumber(),
                resource.reason(),
                resource.details()
        );
    }
}
