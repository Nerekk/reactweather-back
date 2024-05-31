package org.example.reactweatherback;

import org.example.reactweatherback.Auth.AuthenticationService;
import org.example.reactweatherback.Auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.example.reactweatherback.User.Role.ADMIN;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ReactweatherBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactweatherBackApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());
        };
    }
}
