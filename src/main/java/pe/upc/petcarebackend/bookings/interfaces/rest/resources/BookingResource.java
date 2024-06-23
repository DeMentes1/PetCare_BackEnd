package pe.upc.petcarebackend.bookings.interfaces.rest.resources;

public record BookingResource(Long bookingId, String date, String ownerName, Integer ownerNumber, String services, String status, String reason, String details) {
}
