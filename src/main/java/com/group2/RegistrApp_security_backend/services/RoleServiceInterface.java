package com.group2.RegistrApp_security_backend.services;

import java.util.List;

import com.group2.RegistrApp_security_backend.dtos.response.PermissionResponseDto;
import com.group2.RegistrApp_security_backend.dtos.response.RoleResponseDto;

public interface RoleServiceInterface {

    List<RoleResponseDto> getAllRoles();
    List<PermissionResponseDto> getAllPermissionsByRole(String role);

}
