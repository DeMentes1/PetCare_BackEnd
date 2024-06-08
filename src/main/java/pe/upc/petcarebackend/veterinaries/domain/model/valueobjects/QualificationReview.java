package pe.upc.petcarebackend.veterinaries.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record QualificationReview(Integer score) {
    public QualificationReview {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("Score must be between 1 and 5");
        }
    }
}
