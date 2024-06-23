package pe.upc.petcarebackend.veterinaries.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.veterinaries.application.internal.outboundservices.acl.ExternalProfileService;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreatePetOwnerCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.PetOwnerRecordId;
import pe.upc.petcarebackend.veterinaries.domain.services.PetOwnerCommandService;
import pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories.PetOwnerRepository;

@Service
public class PetOwnerCommandServiceImpl implements PetOwnerCommandService {
    private final PetOwnerRepository petOwnerRepository;
    private final ExternalProfileService externalProfileService;

    public PetOwnerCommandServiceImpl(PetOwnerRepository petOwnerRepository, ExternalProfileService externalProfileService) {
        this.petOwnerRepository = petOwnerRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public PetOwnerRecordId handle(CreatePetOwnerCommand command) {

        // Fetch profileId by email
        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

        // If profileId is empty, create profile
        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.name(), command.email(), command.city());
        } else {
            // If profileId is not empty, check if student exists
            petOwnerRepository.findByProfileId(profileId.get()).ifPresent(petOwner -> {
                throw new IllegalArgumentException("Pet Owner already exists");
            });
        }

        // If profileId is still empty, throw exception
        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        // Create student using fetched or created profileId
        var petOwner = new PetOwner(profileId.get());
        petOwnerRepository.save(petOwner);
        return petOwner.getPetOwnerRecordId();
    }
}
