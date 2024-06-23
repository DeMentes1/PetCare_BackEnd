package pe.upc.petcarebackend.bookings.domain.model.commands;

import pe.upc.petcarebackend.bookings.domain.model.valueobjects.BookingServices;
import pe.upc.petcarebackend.bookings.domain.model.valueobjects.BookingStatus;

import java.time.LocalDate;

public record CreateBookingCommand(BookingServices service, String date, String ownerName, Integer ownerNumber, String reason, String details) {
}
