package pe.upc.petcarebackend.iam.infraestructure.hashing.bcrypt;

import org.springframework.security.crypto.password.PasswordEncoder;
import pe.upc.petcarebackend.iam.application.internal.outboundservices.hashing.HashingService;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
