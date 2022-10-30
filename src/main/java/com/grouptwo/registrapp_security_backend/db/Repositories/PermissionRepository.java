package com.grouptwo.registrapp_security_backend.db.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.grouptwo.registrapp_security_backend.db.models.Permission;

@Repository
public interface PermissionRepository extends MongoRepository<Permission, String>{
    
    @Query("{_id: {$in: :#{#ids}}}")
    List<Permission> findAllByIds(List<String> ids);
}
