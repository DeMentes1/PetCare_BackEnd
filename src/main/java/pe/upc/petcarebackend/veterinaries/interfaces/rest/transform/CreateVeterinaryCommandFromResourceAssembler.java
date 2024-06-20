package pe.upc.petcarebackend.veterinaries.interfaces.rest.transform;

import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreatePetOwnerCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreateVeterinaryCommand;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.CreatePetOwnerResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.CreateVeterinaryResource;

public class CreateVeterinaryCommandFromResourceAssembler {
    public static CreateVeterinaryCommand toCommandFromResource(CreateVeterinaryResource resource) {
        return new CreateVeterinaryCommand(
                resource.name(),
                resource.email(),
                resource.city(),
                resource.description()
        );
    }
}
