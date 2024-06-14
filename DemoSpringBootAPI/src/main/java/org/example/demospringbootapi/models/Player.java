package org.example.demospringbootapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.demospringbootapi.utils.validations.password.ValidPassword;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Player {

    private Long id;

    @NotNull(message = "userName can't by null")
    private String userName;

    @NotNull(message = "password can't by null")
    @ValidPassword
    private String password;

    @NotNull(message = "email can't by null")
    @Email(message = "The mail need to be a valid email")
    private String email;

    private String avatar;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime lastLogin;
}
