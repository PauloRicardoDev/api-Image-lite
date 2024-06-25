package io.github.pauloricardodev.apiimagelite.infra.repository;

import io.github.pauloricardodev.apiimagelite.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
