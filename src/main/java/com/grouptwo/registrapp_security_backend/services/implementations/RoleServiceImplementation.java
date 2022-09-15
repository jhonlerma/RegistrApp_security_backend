package com.grouptwo.registrapp_security_backend.services.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.registrapp_security_backend.exceptions.RgAppException;

import com.grouptwo.registrapp_security_backend.db.Repositories.RolePermissionRepository;
import com.grouptwo.registrapp_security_backend.db.Repositories.RoleRepository;
import com.grouptwo.registrapp_security_backend.db.dtos.response.PermissionResponseDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.RoleResponseDto;
import com.grouptwo.registrapp_security_backend.db.models.Role;
import com.grouptwo.registrapp_security_backend.db.models.RolePermission;
import com.grouptwo.registrapp_security_backend.services.RoleService;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public List<RoleResponseDto> getAllRoles() {

        List<Role> roles = this.roleRepository.findAll();
        return roles.stream().map(x -> RoleResponseDto.builder()
                .name(x.getName())
                .description(x.getDescription())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<PermissionResponseDto> getAllPermissions(String role) {

        Role r = roleRepository.findOneByName(role).map(x -> x).orElseThrow(() -> new RgAppException(400, "rol Invalido", new Date()));
        String id = r.getId();
        List<RolePermission> rolePermissions = rolePermissionRepository.findAllByRole(id);
        List<PermissionResponseDto> permissions = new ArrayList<>();
        if (!rolePermissions.isEmpty()) {
            List<String> ids = rolePermissions.stream().map(x -> x.getId()).collect(Collectors.toList());
            List<RolePermission> p = rolePermissionRepository.findAllByIds(ids); // revisar si se usan metodos del
                                                                                 // repositorio nativos
            permissions = p.stream().map(x -> PermissionResponseDto
                    .builder()
                    .method(x.getPermission().getMethod().toString())
                    .url(x.getPermission().getUrl())
                    .build()).collect(Collectors.toList());
        }
        return permissions;
    }

}
