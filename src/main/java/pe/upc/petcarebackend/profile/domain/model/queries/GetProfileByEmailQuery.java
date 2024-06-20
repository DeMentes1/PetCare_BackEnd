package pe.upc.petcarebackend.profile.domain.model.queries;

import pe.upc.petcarebackend.profile.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress email) { }
