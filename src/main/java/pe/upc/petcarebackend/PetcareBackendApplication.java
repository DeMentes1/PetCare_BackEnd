package pe.upc.petcarebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PetcareBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(PetcareBackendApplication.class, args);
    }
}
