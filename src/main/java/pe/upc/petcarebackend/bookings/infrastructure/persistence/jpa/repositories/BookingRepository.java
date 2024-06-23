package pe.upc.petcarebackend.bookings.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.petcarebackend.bookings.domain.model.aggregates.Booking;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    /*
    Optional<Booking>findById(Long bookingId);

    List<Booking>existByServices(String services);
    List<Booking>findByDate(String Date);
  */

}
