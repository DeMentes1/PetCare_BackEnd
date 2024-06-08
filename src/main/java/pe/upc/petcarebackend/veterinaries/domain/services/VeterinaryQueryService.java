package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetAllVeterinariesQuery;

import java.util.List;

public interface VeterinaryQueryService {
    List<Veterinary> handle(GetAllVeterinariesQuery query);
}
