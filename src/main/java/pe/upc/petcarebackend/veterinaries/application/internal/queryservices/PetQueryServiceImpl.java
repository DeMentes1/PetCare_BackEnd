package pe.upc.petcarebackend.veterinaries.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Pet;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.GetPetByIdQuery;
import pe.upc.petcarebackend.veterinaries.domain.services.PetQueryService;
import pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories.PetRepository;

import java.util.Optional;

@Service
public class PetQueryServiceImpl implements PetQueryService {

    private final PetRepository petRepository;

    public PetQueryServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public Optional<Pet> handle(GetPetByIdQuery query) {
        return petRepository.findById(query.petId());
    }
}
