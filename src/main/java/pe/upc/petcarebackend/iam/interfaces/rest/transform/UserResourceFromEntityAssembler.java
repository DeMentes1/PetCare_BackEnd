package pe.upc.petcarebackend.iam.interfaces.rest.transform;

import pe.upc.petcarebackend.iam.domain.model.aggregates.User;
import pe.upc.petcarebackend.iam.domain.model.entities.Role;
import pe.upc.petcarebackend.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        var roles = entity.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(entity.getId(), entity.getUsername(), roles);
    }
}
