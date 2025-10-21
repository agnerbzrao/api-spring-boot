package api.spring.java.user;


import jakarta.validation.constraints.NotNull;

public record UserDataUpdate(
        @NotNull
        Long id,
        String firstName,
        String lastName,
        int age,
        String email
) {
}
