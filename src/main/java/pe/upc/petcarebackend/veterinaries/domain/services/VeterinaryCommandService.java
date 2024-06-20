package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.*;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.PetOwnerRecordId;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.VeterinaryRecordId;

import java.util.Optional;

public interface VeterinaryCommandService {
    VeterinaryRecordId handle(CreateVeterinaryCommand command);
}
