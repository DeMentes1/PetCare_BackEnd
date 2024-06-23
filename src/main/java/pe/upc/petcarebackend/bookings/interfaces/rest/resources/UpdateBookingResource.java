package pe.upc.petcarebackend.bookings.interfaces.rest.resources;

import pe.upc.petcarebackend.bookings.domain.model.valueobjects.BookingServices;
import pe.upc.petcarebackend.bookings.domain.model.valueobjects.BookingStatus;

public record UpdateBookingResource(BookingServices service, String date, String ownerName, Integer ownerNumber, String reason, String details, BookingStatus status, Long bookingId) {
}
