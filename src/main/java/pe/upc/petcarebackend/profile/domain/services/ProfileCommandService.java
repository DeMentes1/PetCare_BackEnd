package pe.upc.petcarebackend.profile.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.profile.domain.model.aggregates.Profile;
import pe.upc.petcarebackend.profile.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

@Service
public interface ProfileCommandService{
    Optional<Profile> handle(CreateProfileCommand command);
}
