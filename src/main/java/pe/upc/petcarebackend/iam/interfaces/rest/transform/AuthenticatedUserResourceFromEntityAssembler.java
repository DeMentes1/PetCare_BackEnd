package pe.upc.petcarebackend.iam.interfaces.rest.transform;

import pe.upc.petcarebackend.iam.domain.model.aggregates.User;
import pe.upc.petcarebackend.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User entity, String token){
        return new AuthenticatedUserResource(entity.getId(), entity.getUsername(), token);
    }
}
