package com.group2.RegistrApp_security_backend.services;

import java.util.List;

import com.group2.RegistrApp_security_backend.dtos.response.RolResponseDto;

public interface RolServiceInterface {

    List<RolResponseDto> getAllRoles();

}
