package io.github.pauloricardodev.apiimagelite.application.users;

import io.github.pauloricardodev.apiimagelite.domain.entity.User;
import io.github.pauloricardodev.apiimagelite.domain.exception.DuplicateTupleException;
import io.github.pauloricardodev.apiimagelite.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @PostMapping
    public ResponseEntity save (@RequestBody UserDTO dto){
       try {
           User user = userMapper.mapToUser(dto);
           userService.save(user);
           return ResponseEntity.status(HttpStatus.CREATED).build();
       }catch (DuplicateTupleException e){
           Map<String, String> jsonResponse = Map.of("error", e.getMessage());
           return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResponse);
       }
    }


    @PostMapping("/auth")
    public ResponseEntity authenticate(@RequestBody CredentialsDTO credentials){
        var token = userService.authenticate(credentials.getEmail(), credentials.getPassword());
        if (token == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(token);
    }
}
