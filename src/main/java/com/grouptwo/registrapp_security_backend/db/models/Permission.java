package com.grouptwo.registrapp_security_backend.db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.grouptwo.registrapp_security_backend.enums.Method;

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
public class Permission {
    
    @Id
    private String id;

    @Field(name = "url")
    private String url;

    @Field(name = "method")
    private Method method;
}
