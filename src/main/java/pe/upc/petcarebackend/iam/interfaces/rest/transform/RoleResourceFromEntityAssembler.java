package pe.upc.petcarebackend.iam.interfaces.rest.transform;

import pe.upc.petcarebackend.iam.domain.model.entities.Role;
import pe.upc.petcarebackend.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role entity) {
        return new RoleResource(entity.getId(), entity.getStringName());

    }
}
