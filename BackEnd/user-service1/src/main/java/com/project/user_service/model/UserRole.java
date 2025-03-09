package com.project.user_service.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserRole {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;
 
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
 
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
 
}

