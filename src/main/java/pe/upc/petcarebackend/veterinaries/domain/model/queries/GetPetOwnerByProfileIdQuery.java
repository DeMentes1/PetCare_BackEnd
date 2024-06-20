package pe.upc.petcarebackend.veterinaries.domain.model.queries;

import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.ProfileId;

public record GetPetOwnerByProfileIdQuery(ProfileId profileId) {
}
