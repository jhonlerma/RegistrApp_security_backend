package com.grouptwo.registrapp_security_backend.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.registrapp_security_backend.db.Repositories.PermissionRepository;
import com.grouptwo.registrapp_security_backend.db.dtos.response.PermissionResponseDto;
import com.grouptwo.registrapp_security_backend.db.models.Permission;
import com.grouptwo.registrapp_security_backend.services.PermissionService;

@Service
public class PermissionServiceImplementation implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    public List<PermissionResponseDto> getAllPermissions() {
        List<Permission> permissions = this.permissionRepository.findAll();
        return permissions.stream().map(x -> PermissionResponseDto.builder()
                .url(x.getUrl())
                .method(x.getMethod().toString())
                .build()).collect(Collectors.toList());

    }


}
