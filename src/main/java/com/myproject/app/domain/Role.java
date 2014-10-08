package com.myproject.app.domain;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.profile.Fetch;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table( name = "Role" )
public class Role {

    private Long roleId;
    private String roleName;

    private Set<User> users = new HashSet<User>();
    private Set<AppResource> appResources = new HashSet<AppResource>();

    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "role_id" )
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Column( name = "role_name" )
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @OneToMany( fetch = FetchType.EAGER)
    @JoinColumn( name = "role_id" )
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set users) {
        this.users = users;
    }

    @ManyToMany( fetch = FetchType.EAGER)
	@JoinTable( name = "RESOURCE_ROLE",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id"))
    public Set<AppResource> getAppResources() {
        return appResources;
    }

    public void setAppResources(Set appResources) {
        this.appResources = appResources;
    }
}
