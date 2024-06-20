package pe.upc.petcarebackend.profile.domain.model.aggregates;

import jakarta.persistence.*;
import pe.upc.petcarebackend.profile.domain.model.commands.CreateProfileCommand;
import pe.upc.petcarebackend.profile.domain.model.valueobjects.EmailAddress;
import pe.upc.petcarebackend.profile.domain.model.valueobjects.City;
import pe.upc.petcarebackend.profile.domain.model.valueobjects.UserName;
import pe.upc.petcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private UserName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "address_city"))})
    private City city;

    public Profile(String name, String email, String city) {
        this.name = new UserName(name);
        this.email = new EmailAddress(email);
        this.city = new City(city);
    }

    public Profile() {
    }

    public Profile(CreateProfileCommand command) {
        this.name = new UserName(command.name());
        this.email = new EmailAddress(command.email());
        this.city = new City(command.city());
    }

    public void updateName(String name) {
        this.name = new UserName(name);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateAddress(String city) {
        this.city = new City(city);
    }

    public String getFullName() {
        return name.name();
    }

    public String getEmailAddress() {
        return email.address();
    }

    public String getCity() {
        return city.city();
    }

}
