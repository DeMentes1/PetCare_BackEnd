package pe.upc.petcarebackend.veterinaries.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.veterinaries.application.internal.outboundservices.acl.ExternalProfileService;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.commands.CreateVeterinaryCommand;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.VeterinaryRecordId;
import pe.upc.petcarebackend.veterinaries.domain.services.VeterinaryCommandService;
import pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories.VeterinaryRepository;

@Service
public class VeterinaryCommandServiceImpl implements VeterinaryCommandService {
    private final VeterinaryRepository veterinaryRepository;
    private final ExternalProfileService externalProfileService;

    public VeterinaryCommandServiceImpl(VeterinaryRepository veterinaryRepository, ExternalProfileService externalProfileService) {
        this.veterinaryRepository = veterinaryRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public VeterinaryRecordId handle(CreateVeterinaryCommand command) {
        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.name(), command.email(), command.city());
        } else {
            veterinaryRepository.findByProfileId(profileId.get()).ifPresent(Veterinary -> {
                throw new IllegalArgumentException("Veterinary already exists");
            });
        }

        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        var veterinary = new Veterinary(profileId.get());
        veterinaryRepository.save(veterinary);
        return veterinary.getVeterinaryRecordId();
    }
}


