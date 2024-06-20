package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface VeterinaryQueryService {
    List<Veterinary> handle(GetAllVeterinariesQuery query);
    Optional<Veterinary> handle(GetVeterinaryByVeterinaryRecordIdQuery query);
    Optional<Veterinary> handle(GetVeterinaryByProfileIdQuery query);
}
