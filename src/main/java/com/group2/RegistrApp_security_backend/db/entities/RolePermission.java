package com.group2.RegistrApp_security_backend.db.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Document(collection = "permission_by_role")
@Document()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolePermission {
   
    @Id
    private String _id;
    @DBRef
    private Role role;
    @DBRef
    private Permission permission;

}
