package io.github.pauloricardodev.apiimagelite.application.users;

import io.github.pauloricardodev.apiimagelite.application.jwt.JwtService;
import io.github.pauloricardodev.apiimagelite.domain.AccessToken;
import io.github.pauloricardodev.apiimagelite.domain.entity.User;
import io.github.pauloricardodev.apiimagelite.domain.exception.DuplicateTupleException;
import io.github.pauloricardodev.apiimagelite.domain.service.UserService;
import io.github.pauloricardodev.apiimagelite.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    @Transactional
    public User save(User user) {
        var possibleUser = getByEmail(user.getEmail());
        if(possibleUser != null){
            throw new DuplicateTupleException("User already exist");
        }
        encodePassword(user);
        return repository.save(user);
    }

    @Override
    public AccessToken authenticate(String email, String password) {
        var user = getByEmail(email);
        if (user == null){
            return null;
        }
        boolean matches = passwordEncoder.matches(password, user.getPassword());

        if (matches){
            return jwtService.generateToken(user);
        }
        return null;
    }


    private void encodePassword(User user){
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
    }
}
