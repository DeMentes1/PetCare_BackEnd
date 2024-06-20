package pe.upc.petcarebackend.veterinaries.domain.model.commands;

public record CreateVeterinaryCommand(String name, String email, String city, String description) {
}
