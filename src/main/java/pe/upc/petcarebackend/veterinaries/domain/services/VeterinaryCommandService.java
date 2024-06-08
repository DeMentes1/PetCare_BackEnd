package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.RegisterVeterinaryCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.RejectVeterinaryCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.UpdateVeterinaryCommand;

import java.util.Optional;

public interface VeterinaryCommandService {
    Long handle(RegisterVeterinaryCommand command);
    Optional<Veterinary> handle(UpdateVeterinaryCommand command);
    Long handle(RejectVeterinaryCommand command);
}
