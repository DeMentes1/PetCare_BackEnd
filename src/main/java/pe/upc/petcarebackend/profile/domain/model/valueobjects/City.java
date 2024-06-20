package pe.upc.petcarebackend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record City(String city) {
    public City(){this(null);}

    public City{
        if (city == null || city.isBlank()){
            throw new IllegalArgumentException("City can not be null or empty");
        }
    }
}
