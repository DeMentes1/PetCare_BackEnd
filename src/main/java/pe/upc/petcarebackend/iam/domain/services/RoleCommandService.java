package pe.upc.petcarebackend.iam.domain.services;

import pe.upc.petcarebackend.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
