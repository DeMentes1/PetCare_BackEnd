/*package pe.upc.petcarebackend.veterinaries.interfaces.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.petcarebackend.veterinaries.domain.services.PetOwnerQueryService;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.PetOwnerResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.transform.PetOwnerResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping("/api/petowners")
public class PetOwnersController {

    @Autowired
    private PetOwnerQueryService petOwnerQueryService;

    @GetMapping
    public ResponseEntity<List<PetOwnerResource>> getAllPetOwners() {
        var getAllPetOwnersQuery = new GetAllPetOwnersQuery();
        var petOwners = petOwnerQueryService.handle(getAllPetOwnersQuery);
        var petOwnerResources = petOwners.stream()
                .map(PetOwnerResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(petOwnerResources);
    }
}
*/