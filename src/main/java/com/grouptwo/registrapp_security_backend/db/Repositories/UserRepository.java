package com.grouptwo.registrapp_security_backend.db.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grouptwo.registrapp_security_backend.db.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    List<User> findAllByRoleId(@Param("role.$id") String id); // QUEDAS MARCADO GONORREA
    Optional<User> findOneByEmail(@Param("email") String email);
}
