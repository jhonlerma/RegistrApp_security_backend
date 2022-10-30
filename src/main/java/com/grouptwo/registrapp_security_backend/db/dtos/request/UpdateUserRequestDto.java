package com.grouptwo.registrapp_security_backend.db.dtos.request;

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
public class UpdateUserRequestDto {

    @Size(min = 2, message = "Nombre incorrecto")
    private String username;
    @Size(min = 2, message = "Incorrecto")
    private String role;
}