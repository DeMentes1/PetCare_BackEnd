package pe.upc.petcarebackend.veterinaries.infraestructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.petcarebackend.veterinaries.domain.model.aggregates.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    boolean existsByName(String name);
}
