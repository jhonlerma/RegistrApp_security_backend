package com.group2.RegistrApp_security_backend.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.RegistrApp_security_backend.db.entities.RolePermission;
import com.group2.RegistrApp_security_backend.db.repositories.RolePermissionRepository;
import com.group2.RegistrApp_security_backend.dtos.response.RolePermissionResponseDto;
import com.group2.RegistrApp_security_backend.services.RolePermissionServiceInterface;

@Service
public class RolePermissionServiceImplementation implements RolePermissionServiceInterface{
    

    @Autowired
    private RolePermissionRepository repository;

    @Override
    public List<RolePermissionResponseDto> getAllRolePermissions() {

        List<RolePermission> rolePermissions = this.repository.findAll();
        return rolePermissions.stream().map(rolePermissionMap -> {
            return RolePermissionResponseDto
            .builder()
            .role(rolePermissionMap.getRole())
            .permission(rolePermissionMap.getPermission())
            .build();
        }).collect(Collectors.toList());
    }

    

    
}
