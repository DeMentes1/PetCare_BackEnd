package pe.upc.petcarebackend.iam.interfaces.rest.resources;

import pe.upc.petcarebackend.iam.domain.model.valueobjects.Roles;

import java.util.List;

public record UserResource(Long id, String username, List<String> roles) {
}
