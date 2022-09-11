package com.grouptwo.registrapp_security_backend.services;

import com.grouptwo.registrapp_security_backend.db.dtos.response.UserResponseDto;

public interface AuthService {
    
    UserResponseDto login(String email, String password);
}