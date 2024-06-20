package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Pet;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetByIdQuery;

import java.util.Optional;

public interface PetQueryService {
    Optional<Pet> handle(GetPetByIdQuery query);

}
