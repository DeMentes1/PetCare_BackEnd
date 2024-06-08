package pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.AppoinmentStatus;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.ProfileId;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.VeterinaryRecordId;

import java.util.List;
import java.util.Optional;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {
    List<PetOwner> findByAllByVeterinaryRecordId(VeterinaryRecordId veterinaryRecordId);
    Optional<PetOwner> findAllByPetId(AppoinmentStatus status);


}
