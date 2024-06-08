package pe.upc.petcarebackend.iam.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import pe.upc.petcarebackend.iam.domain.model.valueobjects.Roles;

import java.util.List;

@Entity
public class Role {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 20)
    private Roles name;

    public Role() {}

    public Role(Roles name) {this.name = name;}

    public String getStringName() {return name.name();}

    public static Role getDefaultRole() {return new Role(Roles.ROLE_USER);}

    public static Role getVeterinaryRole() {return new Role(Roles.ROLE_VETERINARY);}

    public static Role getPetOwnerRole() {return new Role(Roles.ROLE_PET_OWNER);}

    public static Role toRoleFromName(String name) {return new Role(Roles.valueOf(name));}

    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) return List.of(getDefaultRole());
        return roles;
    }
}
