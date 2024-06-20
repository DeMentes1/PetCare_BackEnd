package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreatePetCommand;

public interface PetCommandService {
    Long handle(CreatePetCommand command);
}
