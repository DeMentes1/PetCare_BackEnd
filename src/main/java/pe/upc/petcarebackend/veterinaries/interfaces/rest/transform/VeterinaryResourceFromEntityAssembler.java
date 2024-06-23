package pe.upc.petcarebackend.veterinaries.interfaces.rest.transform;

import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.PetOwnerResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.VeterinaryResource;

public class VeterinaryResourceFromEntityAssembler {
    public static VeterinaryResource toResourceFromEntity(Veterinary veterinary) {
        return new VeterinaryResource(
                veterinary.getVeterinaryId(),
                veterinary.getProfileId(),
                veterinary.getStatus(),
                veterinary.getDescription());
    }
}
