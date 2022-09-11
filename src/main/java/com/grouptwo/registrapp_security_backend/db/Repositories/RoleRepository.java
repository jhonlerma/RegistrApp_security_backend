package com.grouptwo.registrapp_security_backend.db.Repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grouptwo.registrapp_security_backend.db.models.Role;

@Repository
public interface RoleRepository extends MongoRepository <Role, String> {
    
    Optional<Role> findOneByName(String name);
}
