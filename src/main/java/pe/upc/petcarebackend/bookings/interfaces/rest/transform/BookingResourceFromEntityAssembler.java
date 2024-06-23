package pe.upc.petcarebackend.bookings.interfaces.rest.transform;

import pe.upc.petcarebackend.bookings.domain.model.aggregates.Booking;
import pe.upc.petcarebackend.bookings.interfaces.rest.resources.BookingResource;

public class BookingResourceFromEntityAssembler {
    public static BookingResource toResourceFromEntity(Booking entity) {
        return new BookingResource(
                entity.getId(),
                entity.getDate(),
                entity.getOwnerName(),
                entity.getOwnerNumber(),
                entity.getService(),
                entity.getStatus(),
                entity.getReason(),
                entity.getDetails());
    }
}
