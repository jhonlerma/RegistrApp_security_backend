package com.grouptwo.registrapp_security_backend.controllers;

import com.grouptwo.registrapp_security_backend.db.dtos.request.CreateUserRequestDto;
import com.grouptwo.registrapp_security_backend.db.dtos.request.UpdateUserRequestDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.CreateUserResponseDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.ErrorDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.UserResponseDto;
import com.grouptwo.registrapp_security_backend.services.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("")
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/roles/{role}")
    public ResponseEntity<List<UserResponseDto>> getAllByRole(@PathVariable String role) {
        return ResponseEntity.ok(service.getUsers(role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Operación exitosa",
                    response = CreateUserResponseDto.class
            ),
            @ApiResponse(
                    code = 400,
                    message = "Error de validación",
                    response = ErrorDto.class
                )
    })
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