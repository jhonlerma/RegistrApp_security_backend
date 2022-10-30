package com.grouptwo.registrapp_security_backend.services;

import java.util.List;

import com.grouptwo.registrapp_security_backend.db.dtos.response.PermissionResponseDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.RoleResponseDto;

public interface RoleService {
    
    List<RoleResponseDto> getAllRoles();
    List<PermissionResponseDto> getAllPermissions(String role); // QUEDAS MARCADO GONORREA
}
