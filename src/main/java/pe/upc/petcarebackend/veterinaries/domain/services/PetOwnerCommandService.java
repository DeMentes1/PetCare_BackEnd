package pe.upc.petcarebackend.veterinaries.domain.services;

import pe.upc.petcarebackend.veterinaries.domain.model.commands.CancelAppoinmentCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.ConfirmAppoinmentCommand;

public interface PetOwnerCommandService {
    Long handle(ConfirmAppoinmentCommand command);
    Long handle(CancelAppoinmentCommand command);
}
