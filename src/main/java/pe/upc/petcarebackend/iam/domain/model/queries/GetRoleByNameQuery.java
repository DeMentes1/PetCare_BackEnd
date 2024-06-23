package pe.upc.petcarebackend.iam.domain.model.queries;

import pe.upc.petcarebackend.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
