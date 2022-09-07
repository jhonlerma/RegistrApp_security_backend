package com.group2.RegistrApp_security_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.RegistrApp_security_backend.dtos.response.RolePermissionResponseDto;
import com.group2.RegistrApp_security_backend.services.RolePermissionServiceInterface;

@RestController
@RequestMapping("api/role_permissions")
public class RolePermissionController {
    
    @Autowired
    private RolePermissionServiceInterface service;

    @GetMapping("")
    public ResponseEntity<List<RolePermissionResponseDto>> getAllRolePermissions(){

        return ResponseEntity.ok(service.getAllRolePermissions());
    }
}
