package pe.upc.petcarebackend.bookings.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.bookings.domain.model.aggregates.Booking;
import pe.upc.petcarebackend.bookings.domain.model.queries.*;
import pe.upc.petcarebackend.bookings.domain.services.BookingQueryService;
import pe.upc.petcarebackend.bookings.infrastructure.persistence.jpa.repositories.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingQueryServiceImpl implements BookingQueryService {

    private final BookingRepository bookingRepository;

    public BookingQueryServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Optional<Booking> handle(GetBookingByIdQuery query) {
        return bookingRepository.findById(query.bookingId());
    }

    @Override
    public List<Booking> handle(GetAllBookings query) {
        return bookingRepository.findAll();    }

    /*
    @Override
    public List<Booking> handle(GetAllBookingsByServicesQuery query) {
        return bookingRepository.findAllBooking();
    }

    @Override
    public List<Booking> handle(GetBookingsByDate query) {
        return List.of();
    }

    @Override
    public List<Booking> handle(GetBookingsByPetIdQuery query) {
        return List.of();
    }

     */
}
