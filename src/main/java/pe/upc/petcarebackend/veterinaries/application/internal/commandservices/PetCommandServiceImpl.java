package pe.upc.petcarebackend.veterinaries.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Pet;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreatePetCommand;
import pe.upc.petcarebackend.veterinaries.domain.services.PetCommandService;
import pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories.PetRepository;

@Service
public class PetCommandServiceImpl implements PetCommandService {

    private final PetRepository petRepository;

    public PetCommandServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Long handle(CreatePetCommand command) {
        if (petRepository.existsByName(command.name())) {
            throw new IllegalArgumentException("Pet with same name already exists");
        }
        var pet = new Pet(command);
        try {
            petRepository.save(pet);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving pet: " + e.getMessage());
        }
        return pet.getId();
    }
}
