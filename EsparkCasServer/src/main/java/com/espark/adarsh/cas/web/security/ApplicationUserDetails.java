package com.espark.adarsh.cas.web.security;


import com.espark.adarsh.cas.persistence.entities.Role;
import com.espark.adarsh.cas.persistence.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ApplicationUserDetails implements UserDetails {

	protected User user;
	protected Set<GrantedAuthority> authorities;

	public ApplicationUserDetails(User user) {
		this.user = user;
		authorities = new HashSet<GrantedAuthority>();
        for (Role role : this.user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            for (String permission :role.getPermissions())
            	authorities.add(new SimpleGrantedAuthority("ROLE_" + permission));
        }
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUserName();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return user.isEnabled();
	}

}
