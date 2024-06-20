package pe.upc.petcarebackend.veterinaries.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetByIdQuery;
import pe.upc.petcarebackend.veterinaries.domain.services.PetCommandService;
import pe.upc.petcarebackend.veterinaries.domain.services.PetQueryService;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.CreatePetResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.PetResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.transform.CreatePetCommandFromResourceAssembler;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.transform.PetResourceFromEntityAssembler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/pets", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Pets", description = "Pet Management Endpoints")
public class PetsController {
    private final PetCommandService petCommandService;
    private final PetQueryService petQueryService;

    public PetsController(PetCommandService petCommandService, PetQueryService petQueryService) {
        this.petCommandService = petCommandService;
        this.petQueryService = petQueryService;
    }

    @PostMapping
    public ResponseEntity<PetResource> createPet(@RequestBody CreatePetResource createPetResource) {
        var createPetCommand = CreatePetCommandFromResourceAssembler.toCommandFromResource(createPetResource);
        var petId = petCommandService.handle(createPetCommand);
        if (petId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getPetByIdQuery = new GetPetByIdQuery(petId);
        var pet = petQueryService.handle(getPetByIdQuery);
        if (pet.isEmpty()) return ResponseEntity.badRequest().build();
        var petResource = PetResourceFromEntityAssembler.toResourceFromEntity(pet.get());
        return new ResponseEntity<>(petResource, HttpStatus.CREATED);
    }
}
