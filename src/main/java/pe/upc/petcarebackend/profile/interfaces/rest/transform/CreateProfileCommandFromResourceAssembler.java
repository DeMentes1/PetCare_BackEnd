package pe.upc.petcarebackend.profile.interfaces.rest.transform;

import pe.upc.petcarebackend.profile.domain.model.commands.CreateProfileCommand;
import pe.upc.petcarebackend.profile.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource){
        return new CreateProfileCommand(
                resource.name(),
                resource.email(),
                resource.city()
                );
    }
}
