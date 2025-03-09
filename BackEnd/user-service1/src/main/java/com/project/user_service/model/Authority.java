package com.project.user_service.model;



import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
 
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Authority implements GrantedAuthority {
 
    private String authority;
 
}