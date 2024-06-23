package pe.upc.petcarebackend.bookings.interfaces.rest.resources;

import pe.upc.petcarebackend.bookings.domain.model.valueobjects.BookingServices;
import pe.upc.petcarebackend.bookings.domain.model.valueobjects.BookingStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateBookingResource(BookingServices services, String date, String ownerName, String reason, Integer ownerNumber, String details) {
}
