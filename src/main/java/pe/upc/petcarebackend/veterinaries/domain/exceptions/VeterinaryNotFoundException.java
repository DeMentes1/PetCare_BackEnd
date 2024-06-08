package pe.upc.petcarebackend.veterinaries.domain.exceptions;

public class VeterinaryNotFoundException extends RuntimeException {

    public VeterinaryNotFoundException (Long aLong) {
        super("Veterinary with id " + aLong + " not found");
    }
}
