package com.group2.RegistrApp_security_backend.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.RegistrApp_security_backend.db.entities.Role;
import com.group2.RegistrApp_security_backend.db.repositories.RoleRepository;
import com.group2.RegistrApp_security_backend.dtos.response.RoleResponseDto;
import com.group2.RegistrApp_security_backend.services.RoleServiceInterface;

@Service
public class RoleServiceImplementation implements RoleServiceInterface {

    @Autowired
    private RoleRepository repository;
    
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
    
}
