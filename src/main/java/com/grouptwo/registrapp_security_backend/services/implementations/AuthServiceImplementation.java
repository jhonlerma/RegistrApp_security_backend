package com.grouptwo.registrapp_security_backend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grouptwo.registrapp_security_backend.db.Repositories.RoleRepository;
import com.grouptwo.registrapp_security_backend.db.Repositories.UserRepository;
import com.grouptwo.registrapp_security_backend.db.dtos.response.RoleResponseDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.UserResponseDto;
import com.grouptwo.registrapp_security_backend.db.models.Role;
import com.grouptwo.registrapp_security_backend.db.models.User;
import com.grouptwo.registrapp_security_backend.exceptions.RgAppException;
import com.grouptwo.registrapp_security_backend.services.AuthService;

import java.util.Date;

@Service
public class AuthServiceImplementation implements AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserResponseDto login(String email, String password) {

        User user = userRepo.findOneByEmail(email).map(x -> x).orElseThrow(() -> new RgAppException(404, "Usuario no encontrado", new Date()));
        
        if (!encoder.matches(password, user.getPassword()))
            throw new RgAppException(401, "Contraseña invalida", new Date());
            
        Role role = roleRepo.findById(user.getRole().getId()).get();

        return UserResponseDto
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(RoleResponseDto.builder()
                        .name(role.getName())
                        .description(role.getDescription())
                        .build())
                .build();
    }
}