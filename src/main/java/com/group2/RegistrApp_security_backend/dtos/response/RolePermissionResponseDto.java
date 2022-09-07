package com.group2.RegistrApp_security_backend.dtos.response;

import com.group2.RegistrApp_security_backend.db.entities.Permission;
import com.group2.RegistrApp_security_backend.db.entities.Role;

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
public class RolePermissionResponseDto {
    Role role;
    Permission permission;// ver si permission o role
}
