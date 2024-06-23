package pe.upc.petcarebackend.bookings.domain.model.queries;

import pe.upc.petcarebackend.bookings.domain.model.valueobjects.PetId;

public record GetBookingsByPetIdQuery(PetId petId) {
}
