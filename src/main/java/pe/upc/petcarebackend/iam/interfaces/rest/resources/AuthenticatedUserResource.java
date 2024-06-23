package pe.upc.petcarebackend.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}
