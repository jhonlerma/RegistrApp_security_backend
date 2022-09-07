package com.group2.RegistrApp_security_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.RegistrApp_security_backend.dtos.response.PermissionResponseDto;
import com.group2.RegistrApp_security_backend.services.PermissionServiceInterface;

@RestController
@RequestMapping("api/permissions")
public class PermissionController {

    @Autowired
    private PermissionServiceInterface service;

    @GetMapping("")
    public ResponseEntity<List<PermissionResponseDto>> getAllPermissions(){

        return ResponseEntity.ok(service.getAllPermissions());
    }
    
}
