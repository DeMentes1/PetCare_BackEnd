package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.commands.CancelAppoinmentCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.ConfirmAppoinmentCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreatePetOwnerCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.PetOwnerRecordId;

import java.util.Optional;

public interface PetOwnerCommandService {
    /*
    Long handle(ConfirmAppoinmentCommand command);
    Long handle(CancelAppoinmentCommand command);

     */
    PetOwnerRecordId handle(CreatePetOwnerCommand command);
}
