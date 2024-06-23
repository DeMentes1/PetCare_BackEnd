package pe.upc.petcarebackend.iam.domain.services;

import pe.upc.petcarebackend.iam.domain.model.aggregates.User;
import pe.upc.petcarebackend.iam.domain.model.queries.GetAllUsersQuery;
import pe.upc.petcarebackend.iam.domain.model.queries.GetUserByIdQuery;
import pe.upc.petcarebackend.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);
}
