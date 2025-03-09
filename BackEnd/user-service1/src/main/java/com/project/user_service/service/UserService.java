package com.project.user_service.service;
import java.util.List;
import java.util.Set;

import com.project.user_service.dto.AuthRequest;
import com.project.user_service.exception.GuestNotFoundException;
import com.project.user_service.model.User;
import com.project.user_service.model.UserRole;
 
 
public interface UserService {
 
	 public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	    public User getUser(String username);
	    public List<User> deleteUser(Long id);

	    public List<User> getAllUsers();
	    public User updateUser(Long id,User existUser) throws Exception;
}