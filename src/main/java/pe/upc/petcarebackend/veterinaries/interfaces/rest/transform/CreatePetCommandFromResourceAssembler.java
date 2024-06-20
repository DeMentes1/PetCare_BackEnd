package pe.upc.petcarebackend.veterinaries.interfaces.rest.transform;

import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreatePetCommand;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.CreatePetResource;

public class CreatePetCommandFromResourceAssembler {
    public static CreatePetCommand toCommandFromResource(CreatePetResource resource){
        return new CreatePetCommand(
                resource.name(),
                resource.lastname(),
                resource.age()
        );
    }
}
