package pe.upc.petcarebackend.veterinaries.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.profile.interfaces.acl.ProfilesContextFacade;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.ProfileId;

import java.util.Optional;

@Service
public class ExternalProfileService {

    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public Optional<ProfileId> fetchProfileIdByEmail(String email) {
        var profileId = profilesContextFacade.fetchProfileIdByEmail(email);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> createProfile(String name, String email, String city) {
        var profileId = profilesContextFacade.createProfile(name, email, city);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }
}
