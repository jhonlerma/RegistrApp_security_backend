package com.grouptwo.registrapp_security_backend.services;

import java.util.List;

import com.grouptwo.registrapp_security_backend.db.dtos.request.CreateUserRequestDto;
import com.grouptwo.registrapp_security_backend.db.dtos.request.UpdateUserRequestDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.CreateUserResponseDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.UserResponseDto;

public interface UserService {
    
    CreateUserResponseDto create(CreateUserRequestDto user);
    void delete(String id);
    void update(UpdateUserRequestDto user, String id);
    UserResponseDto getById(String id);
    List<UserResponseDto> getUsers(String role); //QUEDAS MARCADO GONORREA
    List<UserResponseDto> getUsers();
}
