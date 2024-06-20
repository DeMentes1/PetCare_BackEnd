package pe.upc.petcarebackend.veterinaries.domain.model.commands;

public record CreatePetOwnerCommand(String name, String email, String city) {
}
