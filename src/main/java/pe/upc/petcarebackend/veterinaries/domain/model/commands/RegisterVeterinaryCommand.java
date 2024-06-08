package pe.upc.petcarebackend.veterinaries.domain.model.commands;

public record RegisterVeterinaryCommand(String name, String address, Long phone, String email) {
}
