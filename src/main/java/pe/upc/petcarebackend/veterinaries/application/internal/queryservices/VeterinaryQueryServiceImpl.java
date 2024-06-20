package pe.upc.petcarebackend.veterinaries.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.queries.*;
import pe.upc.petcarebackend.veterinaries.domain.services.VeterinaryQueryService;
import pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories.VeterinaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinaryQueryServiceImpl implements VeterinaryQueryService {

    private final VeterinaryRepository veterinaryRepository;

    public VeterinaryQueryServiceImpl (VeterinaryRepository veterinaryRepository){this.veterinaryRepository=veterinaryRepository;}

    @Override
    public List<Veterinary> handle(GetAllVeterinariesQuery query) {
        return veterinaryRepository.findAll();
    }

    @Override
    public Optional<Veterinary> handle(GetVeterinaryByVeterinaryRecordIdQuery query) {
        return veterinaryRepository.findByVeterinaryRecordId(query.veterinaryRecordId());
    }

    @Override
    public Optional<Veterinary> handle(GetVeterinaryByProfileIdQuery query) {
        return veterinaryRepository.findByProfileId(query.profileId());
    }


}
