package pe.upc.petcarebackend.veterinaries.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class VeterinaryRegisteredEvent extends ApplicationEvent {

    private final Long veterinaryId;

    public VeterinaryRegisteredEvent(Object source, Long veterinaryId) {
        super(source);
        this.veterinaryId = veterinaryId;
    }

}
