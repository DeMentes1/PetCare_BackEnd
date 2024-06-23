package pe.upc.petcarebackend.iam.interfaces.rest.transform;

import pe.upc.petcarebackend.iam.domain.model.commands.SignUpCommand;
import pe.upc.petcarebackend.iam.domain.model.entities.Role;
import pe.upc.petcarebackend.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() !=null
                ? resource.roles().stream().map(Role::toRoleFromName).toList()
                : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
