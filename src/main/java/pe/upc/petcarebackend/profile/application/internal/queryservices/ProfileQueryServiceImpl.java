package pe.upc.petcarebackend.profile.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.profile.domain.model.aggregates.Profile;
import pe.upc.petcarebackend.profile.domain.model.queries.GetAllProfilesQuery;
import pe.upc.petcarebackend.profile.domain.model.queries.GetProfileByCityQuery;
import pe.upc.petcarebackend.profile.domain.model.queries.GetProfileByEmailQuery;
import pe.upc.petcarebackend.profile.domain.model.queries.GetProfileByIdQuery;
import pe.upc.petcarebackend.profile.domain.services.ProfileQueryService;
import pe.upc.petcarebackend.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.id());
    }

    @Override
    public Optional<Profile> handle(GetProfileByCityQuery query) {
        return profileRepository.findByCity(query.city());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.email());
    }

}
