package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetAllPetOwnersQuery;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetOwnerByPetIdQuery;

import java.util.List;
import java.util.Optional;

public interface PetOwnerQueryService {
    /*
    List<PetOwner> handle(GetAllAppoinmentsByPetOwnerRecordIdQuery query);
    List<PetOwner> handle(GetAppoinmentsByVeterinaryIdAndPetIdQuery query);

     */
    Optional<PetOwner> handle(GetPetOwnerByPetIdQuery query);
    List<PetOwner> handle(GetAllPetOwnersQuery query);

}
