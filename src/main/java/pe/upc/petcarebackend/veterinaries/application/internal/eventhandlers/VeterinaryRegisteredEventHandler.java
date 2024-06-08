package pe.upc.petcarebackend.veterinaries.application.internal.eventhandlers;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.veterinaries.domain.services.VeterinaryCommandService;

@Service
public class VeterinaryRegisteredEventHandler {
    private final VeterinaryCommandService veterinaryCommandService;

    public VeterinaryRegisteredEventHandler(VeterinaryCommandService veterinaryCommandService) {
        this.veterinaryCommandService = veterinaryCommandService;
    }

}
