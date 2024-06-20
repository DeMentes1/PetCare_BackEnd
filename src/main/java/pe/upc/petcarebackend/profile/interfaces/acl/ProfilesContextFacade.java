package pe.upc.petcarebackend.profile.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.profile.domain.model.commands.CreateProfileCommand;
import pe.upc.petcarebackend.profile.domain.model.queries.GetProfileByEmailQuery;
import pe.upc.petcarebackend.profile.domain.model.valueobjects.EmailAddress;
import pe.upc.petcarebackend.profile.domain.services.ProfileCommandService;
import pe.upc.petcarebackend.profile.domain.services.ProfileQueryService;

@Service
public class ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    public Long createProfile(String name, String email, String city) {
        var createProfileCommand = new CreateProfileCommand(name, email, city);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();

    }
}
