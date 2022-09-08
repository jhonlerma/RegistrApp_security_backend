package com.group2.RegistrApp_security_backend.services;

import com.group2.RegistrApp_security_backend.dtos.request.CreateUserRequestDto;
import com.group2.RegistrApp_security_backend.dtos.request.UpdateUserRequestDto;
import com.group2.RegistrApp_security_backend.dtos.response.CreateUserResponseDto;
import com.group2.RegistrApp_security_backend.dtos.response.UserResponseDto;

import java.util.List;

public interface UserService {
    CreateUserResponseDto create(CreateUserRequestDto user);
    void delete(String id);
    void update(UpdateUserRequestDto user, String id);
    UserResponseDto getById(String id);
    List<UserResponseDto> getUsers(String role);
    List<UserResponseDto> getUsers();
}