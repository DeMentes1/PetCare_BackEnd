package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Pet;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetAllPetOwnersQuery;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetOwnerByPetIdQuery;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetOwnerByPetOwnerRecordIdQuery;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetOwnerByProfileIdQuery;

import java.util.List;
import java.util.Optional;

public interface PetOwnerQueryService {
    /*
    List<PetOwner> handle(GetAllAppoinmentsByPetOwnerRecordIdQuery query);
    List<PetOwner> handle(GetAppoinmentsByVeterinaryIdAndPetIdQuery query);

     */
    Optional<PetOwner> handle(GetPetOwnerByPetIdQuery query);
    Optional<PetOwner> handle(GetPetOwnerByProfileIdQuery query);
    Optional<PetOwner> handle(GetPetOwnerByPetOwnerRecordIdQuery query);
    List<PetOwner> handle(GetAllPetOwnersQuery query);

}
