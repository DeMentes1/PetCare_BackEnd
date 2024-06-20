package pe.upc.petcarebackend.profile.domain.services;

import pe.upc.petcarebackend.profile.domain.model.aggregates.Profile;
import pe.upc.petcarebackend.profile.domain.model.queries.GetAllProfilesQuery;
import pe.upc.petcarebackend.profile.domain.model.queries.GetProfileByCityQuery;
import pe.upc.petcarebackend.profile.domain.model.queries.GetProfileByEmailQuery;
import pe.upc.petcarebackend.profile.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    List<Profile> handle(GetAllProfilesQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByCityQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
}
