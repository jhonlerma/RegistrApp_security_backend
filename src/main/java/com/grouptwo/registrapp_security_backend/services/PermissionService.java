package com.grouptwo.registrapp_security_backend.services;

import java.util.List;

import com.grouptwo.registrapp_security_backend.db.dtos.response.PermissionResponseDto;

public interface PermissionService {
    
    List<PermissionResponseDto> getAllPermissions();

}
