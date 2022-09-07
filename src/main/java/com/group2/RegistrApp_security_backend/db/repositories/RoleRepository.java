package com.group2.RegistrApp_security_backend.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.group2.RegistrApp_security_backend.db.entities.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    
}
