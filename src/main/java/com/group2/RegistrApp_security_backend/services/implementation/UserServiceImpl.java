package com.group2.RegistrApp_security_backend.services.implementation;

import com.group2.RegistrApp_security_backend.db.entities.Role;
import com.group2.RegistrApp_security_backend.db.entities.User;
import com.group2.RegistrApp_security_backend.db.repositories.RoleRepository;
import com.group2.RegistrApp_security_backend.db.repositories.UserRepository;
import com.group2.RegistrApp_security_backend.dtos.request.CreateUserRequestDto;
import com.group2.RegistrApp_security_backend.dtos.request.UpdateUserRequestDto;
import com.group2.RegistrApp_security_backend.dtos.response.CreateUserResponseDto;
import com.group2.RegistrApp_security_backend.dtos.response.RoleResponseDto;
import com.group2.RegistrApp_security_backend.dtos.response.UserResponseDto;
import com.group2.RegistrApp_security_backend.exception.Exception;
import com.group2.RegistrApp_security_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public CreateUserResponseDto create(CreateUserRequestDto user) {

        User userToCreate = User.builder()
                .email(user.getEmail())
                .seudonimo(user.getSeudonimo())
                .password(encoder.encode(user.getPassword()))
                .roleId(roleRepo.findOneByName("administrator").get().get_id())
                .build();
        userToCreate = repo.save(userToCreate);
        return CreateUserResponseDto.builder()
                .id(userToCreate.get_id())
                .build();
    }

    @Override
    public void delete(String id) {
        repo.findById(id).map(x -> {
            repo.delete(x);
            return x;
        }).orElseThrow(() -> new Exception("Usuario no existe", 404, new Date()));
    }

    @Override
    public void update(UpdateUserRequestDto user, String id) {
        User userFound = repo.findById(id).map(x ->{
            return x;
        }).orElseThrow(() -> new Exception("Usuario inexistente",404, new Date()));
        userFound.setSeudonimo(user.getSeudonimo() != null ? user.getSeudonimo() : userFound.getSeudonimo());
        userFound.setRoleId(user.getRoleId() != null ? roleRepo.findOneByName(user.getRoleId()).get().get_id() : userFound.getRoleId());
        repo.save(userFound);
    }

    @Override
    public UserResponseDto getById(String id) {
        User user = repo.findById(id).map(x -> {
            return x;
        }).orElseThrow(() -> new Exception("Usuario no existe", 404, new Date()));

        Role role = roleRepo.findById(user.getRoleId()).get();

        return UserResponseDto.builder()
                .role(RoleResponseDto.builder()
                        .name(role.getName())
                        .description(role.getDescription())
                        .build())
                .email(user.getEmail())
                .id(user.get_id())
                .seudonimo(user.getSeudonimo())
                .build();
    }

    @Override
    public List<UserResponseDto> getUsers(String role) {
        Role r = roleRepo.findOneByName(role).get();
        List<User> users = repo.findAllByRoleId(r.get_id());

        List<UserResponseDto> usersToReturn = new ArrayList<>();
        for (User user: users) {
            usersToReturn.add(
                    UserResponseDto.builder()
                            .role(RoleResponseDto.builder()
                                    .name(r.getName())
                                    .description(r.getDescription())
                                    .build())
                            .email(user.getEmail())
                            .id(user.get_id())
                            .seudonimo(user.getSeudonimo())
                            .build()
            );
        }
        return usersToReturn;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = repo.findAll();
        Set<String> roleIds = users.stream().map(x -> x.getRoleId()).collect(Collectors.toSet());
        List<Role> roles = (List<Role>) roleRepo.findAllById(roleIds);

        List<UserResponseDto> usersToReturn = new ArrayList<>();
        for (User user: users) {
            Role role = roles.stream().filter(x -> x.get_id().equals(user.getRoleId())).collect(Collectors.toList()).get(0);
            usersToReturn.add(
                    UserResponseDto.builder()
                            .seudonimo(user.getSeudonimo())
                            .id(user.get_id())
                            .email(user.getEmail())
                            .role(RoleResponseDto.builder()
                                    .name(role.getName())
                                    .description(role.getDescription())
                                    .build())
                            .build()
            );
        }
        return usersToReturn;
    }
}