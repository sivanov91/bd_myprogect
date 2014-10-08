package com.myproject.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:39
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name = "APP_RESOURCE")
public class AppResource {
    private Long appResourceId;
    private String accessType;

    private Set<Role> roles = new HashSet<Role>();


    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "resource_id")
    public Long getAppResourceId() {
        return appResourceId;
    }

    public void setAppResourceId(Long appResourceId) {
        this.appResourceId = appResourceId;
    }

    @Column( name = "Access_Type")
    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    @ManyToMany( fetch = FetchType.EAGER )
	@JoinTable(name = "RESOURCE_ROLE",
	      joinColumns = @JoinColumn(name = "resource_id"),
	      inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
