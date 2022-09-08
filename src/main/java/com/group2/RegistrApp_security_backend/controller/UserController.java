package com.group2.RegistrApp_security_backend.controller;

import com.group2.RegistrApp_security_backend.dtos.request.CreateUserRequestDto;
import com.group2.RegistrApp_security_backend.dtos.request.UpdateUserRequestDto;
import com.group2.RegistrApp_security_backend.dtos.response.CreateUserResponseDto;
import com.group2.RegistrApp_security_backend.dtos.response.UserResponseDto;
import com.group2.RegistrApp_security_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController //para que sea considerado un controlador
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/roles/{role:Admin|Ciudadano|Jurado}")
    public ResponseEntity<List<UserResponseDto>> getAllByRole(@PathVariable String role) {
        return ResponseEntity.ok(service.getUsers(role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<CreateUserResponseDto> create(@RequestBody @Valid CreateUserRequestDto request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateUserRequestDto request, @PathVariable String id) {
        service.update(request,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}