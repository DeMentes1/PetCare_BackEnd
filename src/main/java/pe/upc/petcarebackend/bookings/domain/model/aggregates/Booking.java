package pe.upc.petcarebackend.bookings.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.upc.petcarebackend.bookings.domain.model.commands.CreateBookingCommand;
import pe.upc.petcarebackend.bookings.domain.model.valueobjects.BookingServices;
import pe.upc.petcarebackend.bookings.domain.model.valueobjects.BookingStatus;
import pe.upc.petcarebackend.bookings.domain.model.valueobjects.PetId;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Booking extends AuditableAbstractAggregateRoot<Booking> {

    //private LocalDate bookingDate;
    //private LocalTime time;
    private String date;
    private String ownerName;
    private String reason;
    private Integer ownerNumber;
    private String details;


    @Embedded
    @JoinColumn(name="pet_id")
    private PetId petId;

    /*@Enumerated(EnumType.STRING)*/
    private BookingStatus status;

    private BookingServices service;


    public Booking(){
        //this.bookingDate = LocalDate.now();

        this.date=Strings.EMPTY;
        this.reason = Strings.EMPTY;
        this.ownerName = Strings.EMPTY;
        this.ownerNumber = null;
        this.details = Strings.EMPTY;
        ///this.petId = new PetId();
        this.service = BookingServices.CONSULTATION;
        this.status=BookingStatus.CONFIRMED;
    }

    public Booking(String date, String reason, String ownerName, Integer ownerNumber, String details) {
        this.date = date;
        this.ownerName = ownerName;
        this.reason = reason;
        this.ownerNumber = ownerNumber;
        this.details = details;


        this.service = BookingServices.CONSULTATION;
        this.status=BookingStatus.CONFIRMED;
    }


    public Booking(CreateBookingCommand command) {
        this.service = command.service() != null ? command.service() : BookingServices.CONSULTATION;
        this.date = command.date();
        this.ownerName = command.ownerName();
        this.reason = command.reason();
        this.ownerNumber = command.ownerNumber();
        this.details = command.details();
        this.status = BookingStatus.CONFIRMED;
    }


    public Long getPetId(){return this.petId.petId(); }

    public void confirm(){
        this.status=BookingStatus.CONFIRMED;
    }
    public void reschedule(){
        this.status=BookingStatus.RESCHEDULED;
    }
    public void done(){
        this.status=BookingStatus.DONE;
    }

    public void emergency(){this.service=BookingServices.EMERGENCY;}
    public void consult(){this.service=BookingServices.CONSULTATION;}
    public void vaccine(){this.service=BookingServices.VACCINATION;}
    public void surgery(){this.service=BookingServices.SURGERY;}

    public String getStatus() {
        return this.status != null ? this.status.name(): "CONFIRMED";
    }

    public String getService() {
        return this.service != null ? this.service.toString() : "unknown";
    }




}
