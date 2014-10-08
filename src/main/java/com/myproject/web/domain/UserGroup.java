package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 13.07.13
 * Time: 17:18
 * To change this template use File | Settings | File Templates.
 */



/*
CREATE TABLE USER_GROUP
(
	GROUP_ID  INTEGER NULL,
	NAME  VARCHAR(32) NULL,
	DESCRIPTION  VARCHAR(300) NULL,
	CREATED_BY  VARCHAR(32) NULL,
	CREATED_DATE  DATE NULL,
	EDIT_BY  VARCHAR(32) NULL,
	EDIT_DATE  DATE NULL
)
;
 */

@NamedQueries({
        @NamedQuery(name = "userGroup.getById", query = "from UserGroup where groupId =:id"),
        @NamedQuery(name = "userGroup.getByName", query = "from UserGroup where name =:name")
})
@Entity
@Table(name = "USER_GROUP")
public class UserGroup {

    private Long groupId;
    private String name;
    private String descroption;

    private Date createdDate;
    private String createdBy;
    private Date editDate;
    private String editBy;

    private Set<User> users;


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescroption() {
        return descroption;
    }

    public void setDescroption(String descroption) {
        this.descroption = descroption;
    }

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "EDIT_DATE")
    @Temporal(TemporalType.DATE)
    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    @Column(name = "EDIT_BY")
    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }


    @OneToMany
    @JoinColumn(name = "GROUP_ID")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
