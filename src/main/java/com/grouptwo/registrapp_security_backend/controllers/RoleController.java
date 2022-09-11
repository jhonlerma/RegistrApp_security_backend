package com.grouptwo.registrapp_security_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.registrapp_security_backend.db.dtos.response.PermissionResponseDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.RoleResponseDto;
import com.grouptwo.registrapp_security_backend.services.RoleService;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("")
    public ResponseEntity<List<RoleResponseDto>> getAllRoles(){

        return ResponseEntity.ok(service.getAllRoles());
    }

    @GetMapping("/{role}") // se bloquean peticiones con parametro role que no coincidan con el regex @GetMapping("/{role:administrator|jury|cityzen}")
    public ResponseEntity<List<PermissionResponseDto>> getAllPermissionsByRole(@PathVariable("role") String role){

        return ResponseEntity.ok(service.getAllPermissions(role));
    }

    
}
