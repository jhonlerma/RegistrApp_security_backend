package com.group2.RegistrApp_security_backend.db.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.group2.RegistrApp_security_backend.db.entities.RolePermission;

@Repository
public interface RolePermissionRepository extends MongoRepository<RolePermission, String> {

    List<RolePermission> findAllByRoleId(String roleId);
}
 