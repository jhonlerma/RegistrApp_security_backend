package com.group2.RegistrApp_security_backend.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.group2.RegistrApp_security_backend.db.entities.Permission;
import com.group2.RegistrApp_security_backend.db.repositories.PermissionRepository;
import com.group2.RegistrApp_security_backend.dtos.response.PermissionResponseDto;
import com.group2.RegistrApp_security_backend.services.PermissionServiceInterface;

public class PermissionServiceImplementation implements PermissionServiceInterface {

    @Autowired
    private PermissionRepository repository;

    @Override
    public List<PermissionResponseDto> getAllPermissions() {

        List<Permission> permissions =  this.repository.findAll();
        return permissions.stream().map(permissionMap -> {
            return PermissionResponseDto
            .builder()
            .url(permissionMap.getUrl())
            .method(permissionMap.getMethod())
            .build();
        }).collect(Collectors.toList());
    }
    
}
