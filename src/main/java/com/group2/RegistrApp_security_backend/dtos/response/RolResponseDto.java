package com.group2.RegistrApp_security_backend.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// tambien se puede usar @Data para resumir todos los decoradores siguientes
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolResponseDto {
    
    private String name;
    private String descirption;
}
