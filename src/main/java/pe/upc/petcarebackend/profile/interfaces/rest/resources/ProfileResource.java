package pe.upc.petcarebackend.profile.interfaces.rest.resources;

public record ProfileResource (
        Long id,
        String fullName,
        String email,
        String city) { }

