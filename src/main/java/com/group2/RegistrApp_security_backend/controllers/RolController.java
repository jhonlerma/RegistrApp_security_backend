package com.group2.RegistrApp_security_backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.RegistrApp_security_backend.dtos.response.RolResponseDto;

@RestController
@RequestMapping("api/roles")
public class RolController {

    @GetMapping("/")
    public ResponseEntity<List<RolResponseDto>> getAllRoles(){

        return ResponseEntity.ok(null);
    }
    
}
