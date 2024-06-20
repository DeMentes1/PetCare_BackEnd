package pe.upc.petcarebackend.profile.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.profile.domain.model.aggregates.Profile;
import pe.upc.petcarebackend.profile.domain.model.commands.CreateProfileCommand;
import pe.upc.petcarebackend.profile.domain.model.valueobjects.EmailAddress;
import pe.upc.petcarebackend.profile.domain.services.ProfileCommandService;
import pe.upc.petcarebackend.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());
        if (profileRepository.existsByEmail(emailAddress))
            throw new IllegalArgumentException("Profile with email "+ command.email() +"already exists");
        var profile = new Profile(command);
        profileRepository.save(profile);
        return Optional.of(profile);
    }
}
