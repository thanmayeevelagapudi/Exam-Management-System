package com.project.user_service.config;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.user_service.model.User;
import com.project.user_service.model.UserRole;

import java.util.Arrays;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {
	
	    private String username;
	    private String password;
	    private String role;
	     
	    public CustomUserDetails(User userCredential) {
	        this.username = userCredential.getUsername();
	        this.password = userCredential.getPassword();
	       // this.role=userCredential.getRole();
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	    	return Arrays.asList(new SimpleGrantedAuthority(role));
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return username;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
}
