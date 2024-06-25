package io.github.pauloricardodev.apiimagelite.domain.service;

import io.github.pauloricardodev.apiimagelite.domain.AccessToken;
import io.github.pauloricardodev.apiimagelite.domain.entity.User;

public interface UserService {
    User getByEmail(String email);
    User save(User user);
    AccessToken authenticate(String email, String password);
}
