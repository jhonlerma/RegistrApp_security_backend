package com.grouptwo.registrapp_security_backend.db.dtos.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequestDto {
    @NotEmpty()
    @NotNull()
    @Size(min = 2, message = "Nombre corto")
    private String username;
    @NotNull()
    @Email(message = "Correo no valido")
    private String email;
    @Size(min = 8)
    @NotNull()
    private String password;

}