package com.group2.RegistrApp_security_backend.dtos.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private String id;
    private String seudonimo;
    private String email;
    private RoleResponseDto role;
}
