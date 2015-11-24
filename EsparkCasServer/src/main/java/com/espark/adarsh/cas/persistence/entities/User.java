package com.espark.adarsh.cas.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Simple class that represents any User entities entity in any application.
 *
 * <p>Because this class performs its own Realm and Permission checks, and these can happen frequently enough in a
 * production application, it is highly recommended that the internal User {@link #getRoles} collection be cached
 * in a 2nd-level cache when using JPA and/or Hibernate.</p>
 */
@Entity
@Table(name="user")
@Cacheable(true)
public class User implements Serializable  {

    @Id
    @Column(name="userName")
    private String userName;
    
    @Basic(optional=false)
    @Column(name="email")
    private String email;
    
    @Basic(optional=false)
    @Column(name="password")
    private String password;
    
    @Column(name="isEnabled", columnDefinition = "BIT", length = 1)
    private Boolean isEnabled;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = { 
			@JoinColumn(name = "userName", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "roleName", 
					nullable = false, updatable = false) })
    private Set<Role> roles = new HashSet<Role>();

    public User(){}
    
    public User(String userName, String password, String email, Boolean isEnabled) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isEnabled = isEnabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.userName + "   " + this.password + "   " + roles;
    }
}
