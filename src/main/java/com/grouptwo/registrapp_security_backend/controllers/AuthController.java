package com.grouptwo.registrapp_security_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.registrapp_security_backend.db.dtos.request.LoginRequestDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.UserResponseDto;
import com.grouptwo.registrapp_security_backend.services.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("")
    public ResponseEntity<UserResponseDto> login(@RequestBody @Valid LoginRequestDto request) {
        var result = this.service.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(result);
    }
}