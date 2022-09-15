package com.grouptwo.registrapp_security_backend.db.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grouptwo.registrapp_security_backend.db.models.RolePermission;

@Repository
public interface RolePermissionRepository extends MongoRepository<RolePermission, String>{
    
    // List<RolePermission> findAllByRoleId(@Param("role.$id") String id); // QUEDAS MARCADO GONORREA
    List<RolePermission> findAllByRole(@Param("role.$id") String id);
    @Query("{_id: {$in: :#{#ids}}}")
    List<RolePermission> findAllByIds(List<String> ids);

}
