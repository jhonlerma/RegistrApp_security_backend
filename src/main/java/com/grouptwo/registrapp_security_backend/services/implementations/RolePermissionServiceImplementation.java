package com.grouptwo.registrapp_security_backend.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.registrapp_security_backend.db.Repositories.RolePermissionRepository;
import com.grouptwo.registrapp_security_backend.db.dtos.response.RolePermissionResponseDto;
import com.grouptwo.registrapp_security_backend.db.models.RolePermission;
import com.grouptwo.registrapp_security_backend.services.RolePermissionService;

@Service
public class RolePermissionServiceImplementation implements RolePermissionService {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;


    @Override
    public List<RolePermissionResponseDto> getAllRolePermissions() {
        List<RolePermission> rolePermissions = this.rolePermissionRepository.findAll();
        return rolePermissions.stream().map(x -> RolePermissionResponseDto.builder()
                .role(x.getRole().getName())
                .permission(x.getPermission().getUrl())
                .build()).collect(Collectors.toList());

    }


}
