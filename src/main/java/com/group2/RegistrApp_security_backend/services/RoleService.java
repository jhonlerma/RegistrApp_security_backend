package com.group2.RegistrApp_security_backend.services;

import com.group2.RegistrApp_security_backend.dtos.response.PermissionResponseDto;
import com.group2.RegistrApp_security_backend.dtos.response.RoleResponseDto;

import java.util.List;

public interface RoleService {
    List<RoleResponseDto> getAllRoles();
    List<PermissionResponseDto> getAllPermission(String role);
}
