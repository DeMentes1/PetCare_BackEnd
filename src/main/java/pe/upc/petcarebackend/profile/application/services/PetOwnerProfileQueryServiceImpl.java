package pe.upc.petcarebackend.profile.application.services;

/*
import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.profiles.domain.model.aggregates.PetOwnerProfile;
import pe.upc.petcarebackend.profiles.domain.model.queries.GetPetOwnerProfileByEmailQuery;
import pe.upc.petcarebackend.profiles.domain.model.queries.GetPetOwnerProfileByIdQuery;
import pe.upc.petcarebackend.profiles.domain.model.queries.GetPetOwnerProfileByNameQuery;
import pe.upc.petcarebackend.profiles.domain.services.PetOwnerProfileQueryService;
import pe.upc.petcarebackend.profiles.infrastructure.persistence.jpa.repositories.PetOwnerRepository;

import java.util.Optional;

@Service
public class PetOwnerProfileQueryServiceImpl implements PetOwnerProfileQueryService {
    private final PetOwnerRepository petOwnerProfileRepository;

    public PetOwnerProfileQueryServiceImpl(PetOwnerRepository petOwnerProfileRepository) {
        this.petOwnerProfileRepository = petOwnerProfileRepository;
    }

    @Override
    public Optional<PetOwnerProfile> handle(GetPetOwnerProfileByIdQuery query) {
        return petOwnerProfileRepository.findById(query.id());
    }

    @Override
    public Optional<PetOwnerProfile> handle(GetPetOwnerProfileByNameQuery query) {
        return petOwnerProfileRepository.findByName(query.name());
    }

    @Override
    public Optional<PetOwnerProfile> handle(GetPetOwnerProfileByEmailQuery query) {
        return petOwnerProfileRepository.findByEmail(query.emailAddress());
    }
}
*/
