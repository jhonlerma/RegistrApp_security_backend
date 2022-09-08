package com.group2.RegistrApp_security_backend.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.RegistrApp_security_backend.db.entities.Permission;
import com.group2.RegistrApp_security_backend.db.entities.Role;
import com.group2.RegistrApp_security_backend.db.entities.RolePermission;
import com.group2.RegistrApp_security_backend.db.repositories.PermissionRepository;
import com.group2.RegistrApp_security_backend.db.repositories.RolePermissionRepository;
import com.group2.RegistrApp_security_backend.db.repositories.RoleRepository;
import com.group2.RegistrApp_security_backend.dtos.response.PermissionResponseDto;
import com.group2.RegistrApp_security_backend.dtos.response.RoleResponseDto;
import com.group2.RegistrApp_security_backend.exceptions.RoleNotFoundException;
import com.group2.RegistrApp_security_backend.services.RoleServiceInterface;

@Service
public class RoleServiceImplementation implements RoleServiceInterface {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    
    @Override
    public List<RoleResponseDto> getAllRoles() {

        List<Role> roles = this.repository.findAll();
        return roles.stream().map(roleMap -> {
            return RoleResponseDto
            .builder()
            .name(roleMap.getName())
            .descirption(roleMap.getDescription())
            .build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<PermissionResponseDto> getAllPermissionsByRole(String role) {
        Role r= repository.findOneByName(role).map(x->x).orElseThrow(()-> new RoleNotFoundException("rol Invalido",400, new Date()));
        String id= r.get_id();
        List<RolePermission> rolePermissions = rolePermissionRepository.findAllByRoleId(id);
        List<PermissionResponseDto> permissions = new ArrayList<>();
        if (!rolePermissions.isEmpty()) {
            List<String> ids = rolePermissions.stream().map(x-> x.get_id()).collect(Collectors.toList());
            List<Permission> p = permissionRepository.findAllByIds(ids);
            permissions = p.stream().map(x -> PermissionResponseDto.builder()
                    .method(x.getMethod().toString())
                    .url(x.getUrl())
                    .build()).collect(Collectors.toList());
        }
        return permissions;
    }

    
}

    // @Override
    // public List<PermissionResponseDto> getAllPermissionsByRole(String roleName) {
        
    //     Role role = repository.findOneByName(roleName)
    //     .map(roleMap -> roleMap)
    //     .orElseThrow(()-> new RoleNotFoundException("invalid role", 400, new Date()));
    //     String id = role.get_id();
    //     List<RolePermission> rolePermissions = rolePermissionRepository.findAllByRoleId(id);
    //     List<PermissionResponseDto> permissions = new ArrayList<>();
    //     if (!rolePermissions.isEmpty()) {
    //         List<String> ids = rolePermissions.stream().map(x -> x.getPermission().get_id()).collect(Collectors.toList());
    //         List<Permission> p = permissionRepository.findAllByIds(ids);
    //         permissions = p.stream().map(x -> PermissionResponseDto.builder()
    //                 .method(x.getMethod().toString())
    //                 .url(x.getUrl())
    //                 .build()).collect(Collectors.toList());
    //     }
    //     return permissions;
    // }
