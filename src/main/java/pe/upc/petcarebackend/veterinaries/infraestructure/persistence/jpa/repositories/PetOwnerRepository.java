package pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.PetOwner;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Veterinary;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.AppoinmentStatus;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.PetOwnerRecordId;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.ProfileId;
import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.VeterinaryRecordId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {
    Optional<PetOwner> findByPetId(Long petId);
    Optional<PetOwner> findByPetOwnerRecordId(PetOwnerRecordId petOwnerId);
    Optional<PetOwner> findByProfileId(ProfileId profileId);
}
