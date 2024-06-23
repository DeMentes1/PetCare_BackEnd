package pe.upc.petcarebackend.iam.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.petcarebackend.iam.domain.model.commands.SeedRolesCommand;
import pe.upc.petcarebackend.iam.domain.model.entities.Role;
import pe.upc.petcarebackend.iam.domain.model.valueobjects.Roles;
import pe.upc.petcarebackend.iam.domain.services.RoleCommandService;
import pe.upc.petcarebackend.iam.infraestructure.persistence.jpa.repositories.RoleRepository;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if (!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}
