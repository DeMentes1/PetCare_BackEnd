package pe.upc.petcarebackend.bookings.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.bookings.domain.model.aggregates.Booking;
import pe.upc.petcarebackend.bookings.domain.model.commands.CreateBookingCommand;
import pe.upc.petcarebackend.bookings.domain.services.BookingCommandService;
import pe.upc.petcarebackend.bookings.infrastructure.persistence.jpa.repositories.BookingRepository;

@Service
public class BookingCommandServiceImpl implements BookingCommandService {

    private final BookingRepository bookingRepository;

    public BookingCommandServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Long handle(CreateBookingCommand command) {

        var booking = new Booking(command);
        try {
            bookingRepository.save(booking);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while booking an appoinment: " + e.getMessage());
        }
        return booking.getId();
    }

}
