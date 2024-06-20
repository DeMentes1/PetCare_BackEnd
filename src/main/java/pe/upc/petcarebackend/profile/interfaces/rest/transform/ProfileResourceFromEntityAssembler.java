package pe.upc.petcarebackend.profile.interfaces.rest.transform;

import pe.upc.petcarebackend.profile.domain.model.aggregates.Profile;
import pe.upc.petcarebackend.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity){
        return new ProfileResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getCity());
    }
}
