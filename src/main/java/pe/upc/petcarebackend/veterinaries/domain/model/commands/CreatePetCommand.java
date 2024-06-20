package pe.upc.petcarebackend.veterinaries.domain.model.commands;

public record CreatePetCommand(String name, String lastname, Integer age) {
}
