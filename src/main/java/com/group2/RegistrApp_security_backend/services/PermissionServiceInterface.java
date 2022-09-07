package com.group2.RegistrApp_security_backend.services;

import java.util.List;

import com.group2.RegistrApp_security_backend.dtos.response.PermissionResponseDto;

public interface PermissionServiceInterface {
    
    List<PermissionResponseDto> getAllPermissions();
}
