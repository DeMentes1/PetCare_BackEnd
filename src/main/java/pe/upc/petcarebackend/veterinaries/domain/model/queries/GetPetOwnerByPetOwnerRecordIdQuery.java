package pe.upc.petcarebackend.veterinaries.domain.model.queries;

import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.PetOwnerRecordId;

public record GetPetOwnerByPetOwnerRecordIdQuery(PetOwnerRecordId petOwnerRecordId) {
}
