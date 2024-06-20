package pe.upc.petcarebackend.veterinaries.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.*;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.VeterinaryRecordId;
import pe.upc.petcarebackend.veterinaries.domain.services.VeterinaryCommandService;
import pe.upc.petcarebackend.veterinaries.domain.services.VeterinaryQueryService;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.CreatePetOwnerResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.CreateVeterinaryResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.PetOwnerResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.resources.VeterinaryResource;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.transform.CreatePetOwnerCommandFromResourceAssembler;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.transform.CreateVeterinaryCommandFromResourceAssembler;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.transform.PetOwnerResourceFromEntityAssembler;
import pe.upc.petcarebackend.veterinaries.interfaces.rest.transform.VeterinaryResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value = "/api/veterinary", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Veterinary", description = "Veterinary Management Endpoints")
public class VeterinariesController {
    private final VeterinaryQueryService veterinaryQueryService;
    private final VeterinaryCommandService veterinaryCommandService;

    public VeterinariesController(VeterinaryQueryService veterinaryQueryService, VeterinaryCommandService veterinaryCommandService) {
        this.veterinaryQueryService = veterinaryQueryService;
        this.veterinaryCommandService = veterinaryCommandService;
    }

    @PostMapping
    public ResponseEntity<VeterinaryResource> createPetOwner(@RequestBody CreateVeterinaryResource resource) {
        var createVeterinaryCommand = CreateVeterinaryCommandFromResourceAssembler.toCommandFromResource(resource);
        var veterinaryId = veterinaryCommandService.handle(createVeterinaryCommand);
        if (veterinaryId.veterinaryId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getVeterinaryByVeterinaryRecordIdQuery = new GetVeterinaryByVeterinaryRecordIdQuery(veterinaryId);
        var veterinary = veterinaryQueryService.handle(getVeterinaryByVeterinaryRecordIdQuery);
        if (veterinary.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var veterinaryResource = VeterinaryResourceFromEntityAssembler.toResourceFromEntity(veterinary.get());
        return new ResponseEntity<>(veterinaryResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VeterinaryResource>> getAllVeterinaries() {
        var getAllVeterinariesQuery = new GetAllVeterinariesQuery();
        var veterinaries = veterinaryQueryService.handle(getAllVeterinariesQuery);
        var veterinaryResources = veterinaries.stream()
                .map(VeterinaryResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(veterinaryResources);
    }

    @GetMapping("/{veterinaryRecordId}")
    public ResponseEntity<VeterinaryResource> getVeterinaryByVeterinaryRecordId(@PathVariable String veterinaryRecordId) {
        var vetRecordId = new VeterinaryRecordId(veterinaryRecordId);
        var getVeterinaryByVeterinaryRecordIdQuery = new GetVeterinaryByVeterinaryRecordIdQuery(vetRecordId);
        var veterinary = veterinaryQueryService.handle(getVeterinaryByVeterinaryRecordIdQuery);
        if (veterinary.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var veterinaryResource = VeterinaryResourceFromEntityAssembler.toResourceFromEntity(veterinary.get());
        return ResponseEntity.ok(veterinaryResource);
    }
}
