package pe.upc.petcarebackend.iam.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import pe.upc.petcarebackend.iam.domain.model.entities.Role;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @Getter
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String email;

    @Getter
    @NotBlank
    @Size(max = 80)
    private String password;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {this.roles = new HashSet<>();}

    public User(String email, String password) {
        this();
        this.email = email;
        this.password = password;
    }



}
