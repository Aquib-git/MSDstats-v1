package com.kng.medicalreports.security;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1019794341296827669L;
	
	private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		List<GrantedAuthority> auth= new ArrayList<>();
		for (Role r : user.getRoles()) {
			auth.add(new SimpleGrantedAuthority(r.getRoleName()));
			
		
		}
				return auth;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
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
	
	public String getFullName() {
		return user.getFullName();
	}
	
	public List<Role> getRoles(){
		return user.getRoles();
	}
	
	
	
	public Long getCivilId() {
		return user.getCivilId();
	}

}
