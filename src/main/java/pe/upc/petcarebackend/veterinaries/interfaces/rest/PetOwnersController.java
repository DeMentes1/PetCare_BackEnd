package pe.upc.petcarebackend.veterinaries.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetAllPetOwnersQuery;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetOwnerByPetIdQuery;
import pe.upc.petcarebackend.veterinaries.domain.services.PetOwnerQueryService;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.PetOwnerResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.transform.PetOwnerResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value = "/api/petowners", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Pet Owners", description = "Pet Owner Management Endpoints")
public class PetOwnersController {
    private final PetOwnerQueryService petOwnerQueryService;

    public PetOwnersController(PetOwnerQueryService petOwnerQueryService) {
        this.petOwnerQueryService = petOwnerQueryService;
    }

    @GetMapping
    public ResponseEntity<List<PetOwnerResource>> getAllPetOwners() {
        var getAllPetOwnersQuery = new GetAllPetOwnersQuery();
        var petOwners = petOwnerQueryService.handle(getAllPetOwnersQuery);
        var petOwnerResources = petOwners.stream()
                .map(PetOwnerResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(petOwnerResources);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetOwnerResource> getPetOwnerByPetId(@PathVariable Long petId) {
        var getPetOwnerByPetIdQuery = new GetPetOwnerByPetIdQuery(petId);
        var petOwner = petOwnerQueryService.handle(getPetOwnerByPetIdQuery);
        if (petOwner.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var petOwnerResource = PetOwnerResourceFromEntityAssembler.toResourceFromEntity(petOwner.get());
        return ResponseEntity.ok(petOwnerResource);
    }

}
