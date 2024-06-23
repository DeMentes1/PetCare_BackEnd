package pe.upc.petcarebackend.iam.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.petcarebackend.iam.domain.model.queries.GetAllRolesQuery;

import pe.upc.petcarebackend.iam.domain.services.RoleQueryService;
import pe.upc.petcarebackend.iam.domain.services.UserQueryService;
import pe.upc.petcarebackend.iam.interfaces.rest.resources.RoleResource;
import pe.upc.petcarebackend.iam.interfaces.rest.resources.UserResource;
import pe.upc.petcarebackend.iam.interfaces.rest.transform.RoleResourceFromEntityAssembler;
import pe.upc.petcarebackend.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/roles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Roles", description = "Role Management Endpoints")
public class RolesController {
    private final RoleQueryService roleQueryService;

    public RolesController(RoleQueryService roleQueryService) {
        this.roleQueryService = roleQueryService;
    }

    @GetMapping
    public ResponseEntity<List<RoleResource>> getAllRoles() {
        var getAllRolesQuery = new GetAllRolesQuery();
        var roles = roleQueryService.handle(getAllRolesQuery);
        var roleResources = roles.stream().map(RoleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(roleResources);
    }
}
