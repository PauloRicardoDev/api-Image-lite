package io.github.pauloricardodev.apiimagelite.application.users;

import lombok.Data;

@Data
public class CredentialsDTO {
    private String email;
    private String password;
}
