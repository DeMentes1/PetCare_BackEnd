package pe.upc.petcarebackend.veterinaries.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetOwnerByIdQuery;
import pe.upc.petcarebackend.veterinaries.domain.services.PetOwnerQueryService;
import pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories.PetOwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerQueryServiceImpl implements PetOwnerQueryService {

    private final PetOwnerRepository petOwnerRepository;

    public PetOwnerQueryServiceImpl(PetOwnerRepository petOwnerRepository) {this.petOwnerRepository = petOwnerRepository;}

    @Override
    public Optional<PetOwner> handle(GetPetOwnerByIdQuery query){return petOwnerRepository.findById(query.petOwnerId());}

}
