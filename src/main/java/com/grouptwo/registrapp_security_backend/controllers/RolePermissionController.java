package com.grouptwo.registrapp_security_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.registrapp_security_backend.db.dtos.response.RolePermissionResponseDto;
import com.grouptwo.registrapp_security_backend.services.RolePermissionService;
@RestController
@RequestMapping("api/role_permissions")
public class RolePermissionController {
    
    @Autowired
    private RolePermissionService service;

    @GetMapping("")
    public ResponseEntity<List<RolePermissionResponseDto>> getAllRolePermissions(){

        return ResponseEntity.ok(service.getAllRolePermissions());
    }
}
