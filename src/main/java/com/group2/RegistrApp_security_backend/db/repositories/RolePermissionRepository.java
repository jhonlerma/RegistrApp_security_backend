package com.group2.RegistrApp_security_backend.db.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.group2.RegistrApp_security_backend.db.entities.Role;
import com.group2.RegistrApp_security_backend.db.entities.RolePermission;

@Repository
public interface RolePermissionRepository extends MongoRepository<RolePermission, String> {
    Optional<RolePermission> findAllByRole(Role role);
}
 