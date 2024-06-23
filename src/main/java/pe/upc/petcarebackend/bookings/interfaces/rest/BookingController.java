package pe.upc.petcarebackend.bookings.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.petcarebackend.bookings.domain.model.queries.GetAllBookings;
import pe.upc.petcarebackend.bookings.domain.model.queries.GetBookingByIdQuery;
import pe.upc.petcarebackend.bookings.domain.services.BookingCommandService;
import pe.upc.petcarebackend.bookings.domain.services.BookingQueryService;
import pe.upc.petcarebackend.bookings.interfaces.rest.resources.BookingResource;
import org.springframework.web.bind.annotation.*;
import pe.upc.petcarebackend.bookings.interfaces.rest.resources.CreateBookingResource;
import pe.upc.petcarebackend.bookings.interfaces.rest.transform.BookingResourceFromEntityAssembler;
import pe.upc.petcarebackend.bookings.interfaces.rest.transform.CreateBookingCommandFromResourceAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/bookings", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Bookings", description = "Booking Management Endpoints")
public class BookingController {
    private final BookingCommandService bookingCommandService;
    private final BookingQueryService bookingQueryService;


    public BookingController(BookingCommandService bookingCommandService, BookingQueryService bookingQueryService) {
        this.bookingCommandService = bookingCommandService;
        this.bookingQueryService = bookingQueryService;
    }

    @PostMapping
    public ResponseEntity<BookingResource> createBooking(@RequestBody CreateBookingResource createBookingResource) {
        var createBookingCommand = CreateBookingCommandFromResourceAssembler.toCommandFromResource(createBookingResource);
        var bookingId = bookingCommandService.handle(createBookingCommand);
        if (bookingId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getBookingByIdQuery = new GetBookingByIdQuery(bookingId);
        var booking = bookingQueryService.handle(getBookingByIdQuery);
        if (booking.isEmpty()) return ResponseEntity.badRequest().build();
        var bookingResource = BookingResourceFromEntityAssembler.toResourceFromEntity(booking.get());
        return new ResponseEntity<>(bookingResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookingResource>>getAllBookings(){
        var getAllBookingsQuery = new GetAllBookings();
        var bookings = bookingQueryService.handle(getAllBookingsQuery);
        var bookingsResource = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingsResource);

    }

}
