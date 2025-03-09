package com.project.user_service.controller;
import com.project.user_service.*;
import com.project.user_service.config.*;

import com.project.user_service.model.Role;
import com.project.user_service.model.User;
import com.project.user_service.model.UserRole;
import com.project.user_service.service.UserService;


//import com.Exam.Backend.Model.User;
//import com.Exam.Backend.Model.userRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
//import com.Exam.Backend.Service.*;
 
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {


 
    @Autowired
    private UserService userService;
 
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
 
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles=new HashSet<>();
        Role role=new Role();
        role.setRoleName("NORMAL");
        role.setRoleId(10L);
 
        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
 
        roles.add(userRole);
        return this.userService.createUser(user,roles);
    }
 
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }
 
    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }
 
 
    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable("id") Long id){
       return this.userService.deleteUser(id);
    }
 
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody User existUser) throws Exception {
        return this.userService.updateUser(id,existUser);
    }
    
    
}