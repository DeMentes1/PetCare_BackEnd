package pe.upc.petcarebackend.profile.interfaces.rest.resources;

public record CreateProfileResource (
        String name,
        String email,
        String city) { }
