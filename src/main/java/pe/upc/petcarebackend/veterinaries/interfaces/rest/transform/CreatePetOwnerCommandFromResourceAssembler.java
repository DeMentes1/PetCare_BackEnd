package pe.upc.petcarebackend.veterinaries.interfaces.rest.transform;

import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreatePetOwnerCommand;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.CreatePetOwnerResource;

public class CreatePetOwnerCommandFromResourceAssembler {
    public static CreatePetOwnerCommand toCommandFromResource(CreatePetOwnerResource resource) {
        return new CreatePetOwnerCommand(
                resource.name(),
                resource.email(),
                resource.city()
        );
    }
}

