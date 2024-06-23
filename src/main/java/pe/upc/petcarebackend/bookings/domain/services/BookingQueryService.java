package pe.upc.petcarebackend.bookings.domain.services;

import pe.upc.petcarebackend.bookings.domain.model.aggregates.Booking;
import pe.upc.petcarebackend.bookings.domain.model.queries.*;
import pe.upc.petcarebackend.bookings.interfaces.rest.resources.BookingResource;

import java.util.List;
import java.util.Optional;

public interface BookingQueryService {
    Optional<Booking> handle(GetBookingByIdQuery query);

    List<Booking> handle(GetAllBookings query);

    /*
    List<Booking> handle(GetAllBookingsByServicesQuery query);

    List<Booking> handle(GetBookingsByDate query);
    List<Booking> handle(GetBookingsByPetIdQuery query);
*/
}
