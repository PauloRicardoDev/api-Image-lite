package io.github.pauloricardodev.apiimagelite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiImageLiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiImageLiteApplication.class, args);
    }

}
