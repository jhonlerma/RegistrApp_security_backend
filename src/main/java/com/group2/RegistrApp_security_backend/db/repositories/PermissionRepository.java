package com.group2.RegistrApp_security_backend.db.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group2.RegistrApp_security_backend.db.entities.Permission;

@Repository
public interface PermissionRepository extends MongoRepository<Permission, String>{

    @Query("{_id: {$in: #{#ids}}}")
    List<Permission> findAllByIds(@Param("ids") List< String> ids);
}
