package pe.upc.petcarebackend.bookings.domain.services;

import pe.upc.petcarebackend.bookings.domain.model.commands.ConfirmBookingCommand;
import pe.upc.petcarebackend.bookings.domain.model.commands.CreateBookingCommand;
import pe.upc.petcarebackend.bookings.domain.model.commands.UpdateBookingCommand;

public interface BookingCommandService {
    Long handle(CreateBookingCommand command);
    /*
    Long handle (ConfirmBookingCommand command);
    Long handle (UpdateBookingCommand command);

     */
}
