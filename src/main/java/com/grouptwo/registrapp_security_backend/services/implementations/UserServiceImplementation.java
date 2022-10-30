package com.grouptwo.registrapp_security_backend.services.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.grouptwo.registrapp_security_backend.db.Repositories.RoleRepository;
import com.grouptwo.registrapp_security_backend.db.Repositories.UserRepository;
import com.grouptwo.registrapp_security_backend.db.dtos.request.CreateUserRequestDto;
import com.grouptwo.registrapp_security_backend.db.dtos.request.UpdateUserRequestDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.CreateUserResponseDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.RoleResponseDto;
import com.grouptwo.registrapp_security_backend.db.dtos.response.UserResponseDto;
import com.grouptwo.registrapp_security_backend.db.models.Role;
import com.grouptwo.registrapp_security_backend.db.models.User;
import com.grouptwo.registrapp_security_backend.exceptions.RgAppException;
import com.grouptwo.registrapp_security_backend.services.UserService;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public CreateUserResponseDto create(CreateUserRequestDto user) {
        User userToCreate = User.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .role(roleRepository.findById(user.getRole()).get()) //QUEDAS MARCADO GONORREA 
                .build();
        userToCreate = userRepository.save(userToCreate);
        return CreateUserResponseDto.builder()
                .id(userToCreate.getId())
                .username(userToCreate.getUsername())
                .email(userToCreate.getEmail())
                .build();
    }

    @Override
    public void delete(String id) {
        userRepository.findById(id).map(x -> {
            userRepository.delete(x);
            return x;
        }).orElseThrow(() -> new RgAppException( 404, "Usuario no existe", new Date()));
    }

    @Override
    public void update(UpdateUserRequestDto user, String id) {

        User userFound = userRepository.findById(id).map(x -> x)
        .orElseThrow(() -> new RgAppException( 404, "Usuario inexistente", new Date()));

        Role roleFound = roleRepository.findById(user.getRole() != null ? user.getRole() : userFound.getRole().getId()).map(x -> x)
        .orElseThrow(() -> new RgAppException( 404, "Rol inexistente", new Date()));
        
        userFound.setUsername(user.getUsername() != null ? user.getUsername() : userFound.getUsername());
        userFound.setRole(roleFound);
        userRepository.save(userFound);
    }

    @Override
    public UserResponseDto getById(String id) {
        User user = userRepository.findById(id).map(x -> {
            return x;
        }).orElseThrow(() -> new RgAppException( 404, "Usuario no existe", new Date()));

        Role role = roleRepository.findById(user.getRole().getId()).get();

        return UserResponseDto.builder()
                .role(RoleResponseDto.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .description(role.getDescription())
                        .build())
                .email(user.getEmail())
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    @Override
    public List<UserResponseDto> getUsers(String role) {

        Role r = roleRepository.findById(role).map(x -> x)
        .orElseThrow(() -> new RgAppException( 404, "Rol inexistente", new Date()));

        List<User> users = userRepository.findAllByRoleId(r.getId());
        List<UserResponseDto> usersToReturn = new ArrayList<>();
        for (User user : users) {
            usersToReturn.add(
                    UserResponseDto.builder()
                            .role(RoleResponseDto.builder()
                                    .id(r.getId())
                                    .name(r.getName())
                                    .description(r.getDescription())
                                    .build())
                            .email(user.getEmail())
                            .id(user.getId())
                            .username(user.getUsername())
                            .build());
        }
        return usersToReturn;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        Set<String> roleIds = users.stream().map(x -> x.getRole().getId()).collect(Collectors.toSet());
        List<Role> roles = (List<Role>) roleRepository.findAllById(roleIds);

        List<UserResponseDto> usersToReturn = new ArrayList<>();
        for (User user : users) {
            Role role = roles.stream().filter(x -> x.getId().equals(user.getRole().getId())).collect(Collectors.toList())
                    .get(0);
            usersToReturn.add(
                    UserResponseDto.builder()
                            .username(user.getUsername())
                            .id(user.getId())
                            .email(user.getEmail())
                            .role(RoleResponseDto.builder()
                                    .id(role.getId())
                                    .name(role.getName())
                                    .description(role.getDescription())
                                    .build())
                            .build());
        }
        return usersToReturn;
    }
}
