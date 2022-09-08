package com.group2.RegistrApp_security_backend.db.repositories;

import com.group2.RegistrApp_security_backend.db.entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
     Optional<Role> findOneByName(String name);

}
