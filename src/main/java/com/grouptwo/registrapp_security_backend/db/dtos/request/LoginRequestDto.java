package com.grouptwo.registrapp_security_backend.db.dtos.request;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDto {

    @NotNull()
    @NotEmpty()
    @Email()
    private String email;
    @NotNull()
    @NotEmpty()
    @Size(min = 8)
    private String password;
}