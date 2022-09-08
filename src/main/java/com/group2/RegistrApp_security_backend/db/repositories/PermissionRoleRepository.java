package com.group2.RegistrApp_security_backend.db.repositories;

import com.group2.RegistrApp_security_backend.db.entities.PermissionRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionRoleRepository extends MongoRepository<PermissionRole, String> {
    List<PermissionRole> findAllByRoleId(String roleId);
}
