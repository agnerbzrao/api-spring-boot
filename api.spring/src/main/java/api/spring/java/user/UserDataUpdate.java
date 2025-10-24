package api.spring.java.user;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDataUpdate(
        @NotNull
        Long id,

        @NotBlank
        @NotNull
        String firstName,

        @NotBlank
        @NotNull
        String lastName,

        int age,
        String email
) {
}
