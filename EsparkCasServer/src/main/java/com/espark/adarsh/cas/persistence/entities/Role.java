package com.espark.adarsh.cas.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model object that represents a security role.
 */
@Entity
@Table(name = "roles")
@Cacheable(true)
public class Role implements Serializable {

    private String name;

    private String description;

    private Set<String> permissions = new HashSet<String>();

    private Set<User> users = new HashSet<User>();
    
    protected Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Id
    @Column(name="roleName", length=100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic(optional=false)
    @Column(name="description", length=255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="roles_permissions")
    @MapKeyJoinColumn(name="roleName")
    @Column(name="permission") 
    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy="roles")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
