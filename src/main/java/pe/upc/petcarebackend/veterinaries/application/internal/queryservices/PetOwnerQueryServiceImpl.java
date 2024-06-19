package pe.upc.petcarebackend.veterinaries.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetAllPetOwnersQuery;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetOwnerByPetIdQuery;
import pe.upc.petcarebackend.veterinaries.domain.services.PetOwnerQueryService;
import pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories.PetOwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerQueryServiceImpl implements PetOwnerQueryService {

    private final PetOwnerRepository petOwnerRepository;

    public PetOwnerQueryServiceImpl(PetOwnerRepository petOwnerRepository) {this.petOwnerRepository = petOwnerRepository;}

    @Override
    public Optional<PetOwner> handle(GetPetOwnerByPetIdQuery query){return petOwnerRepository.findByPetId(query.petId());}

    @Override
    public List<PetOwner> handle(GetAllPetOwnersQuery query) { return petOwnerRepository.findAll();}

}
