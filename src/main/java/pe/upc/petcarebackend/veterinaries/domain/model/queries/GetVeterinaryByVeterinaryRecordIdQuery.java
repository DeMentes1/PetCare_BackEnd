package pe.upc.petcarebackend.veterinaries.domain.model.queries;

import pe.upc.petcarebackend.veterinaries.domain.model.valueobjects.VeterinaryRecordId;

public record GetVeterinaryByVeterinaryRecordIdQuery(VeterinaryRecordId veterinaryRecordId) {
}
