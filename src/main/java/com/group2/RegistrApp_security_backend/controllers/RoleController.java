package com.group2.RegistrApp_security_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.RegistrApp_security_backend.dtos.response.RoleResponseDto;
import com.group2.RegistrApp_security_backend.services.RoleServiceInterface;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    private RoleServiceInterface service;

    @GetMapping("/")
    public ResponseEntity<List<RoleResponseDto>> getAllRoles(){

        return ResponseEntity.ok(service.getAllRoles());
    }
    
}
