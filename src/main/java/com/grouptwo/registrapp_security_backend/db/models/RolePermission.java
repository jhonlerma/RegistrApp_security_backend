package com.grouptwo.registrapp_security_backend.db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document()
public class RolePermission {

    @Id
    private String id;
    
    @Field(name = "role")
    @DBRef
    private Role role;

    @Field(name = "permission")
    @DBRef
    private Permission permission;
    
}
