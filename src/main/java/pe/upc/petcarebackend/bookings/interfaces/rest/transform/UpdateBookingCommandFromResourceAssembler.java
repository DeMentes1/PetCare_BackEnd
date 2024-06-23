package pe.upc.petcarebackend.bookings.interfaces.rest.transform;

import pe.upc.petcarebackend.bookings.domain.model.commands.UpdateBookingCommand;
import pe.upc.petcarebackend.bookings.interfaces.rest.resources.UpdateBookingResource;

public class UpdateBookingCommandFromResourceAssembler {
    //bookingID?
    public static UpdateBookingCommand toCommandFromResource( UpdateBookingResource resource){
        return new UpdateBookingCommand(
                resource.service(),
                resource.date(),
                resource.ownerName(),
                resource.ownerNumber(),
                resource.reason(),
                resource.details(),
                resource.status(),
                resource.bookingId()
                );
    }
}
