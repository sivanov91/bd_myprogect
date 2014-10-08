package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */

/*

 CREATE TABLE USERS
 (
 	USER_ID  INTEGER NULL,
 	USERNAME  CHAR(32) NULL,
 	PASSWORD  CHAR(32) NULL,
 	FIRSTNAME  CHAR(32) NULL,
 	LASTNAME  CHAR(32) NULL,
 	PATRONYMIC  CHAR(32) NULL,
 	EMAIL  CHAR(32) NULL,
 	CODE  CHAR(32) NULL,
 	ADD_DATE  DATE NULL,
 	EDIT_DATE  DATE NULL,
 	USER_STATUS_ID  INTEGER NOT NULL,
 	IP  VARCHAR(20) NULL,
 	GROUP_ID  INTEGER NOT NULL,
 	APPROVED  INTEGER NULL
 )
 ;

*/

@NamedQueries({
        @NamedQuery(name = "users.getById", query = "from User where userId =:id"),
        @NamedQuery(name = "users.getByUserName", query = "from User where userName =:userName")
})
@Entity
@Table(name = "USERS")
public class User {

    private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String code;
    private String ip;
    private Long approved;

    private Date createdDate;
    private String createdBy;
    private Date editDate;
    private String editBy;


    private Long userStatusId;
    private Long groupId;


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "USERNAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "PATRONYMIC")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "APPROVED")
    public Long getApproved() {
        return approved;
    }

    public void setApproved(Long approved) {
        this.approved = approved;
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




    /* External */

    @Column(name = "USER_STATUS_ID")
    public Long getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(Long userStatusId) {
        this.userStatusId = userStatusId;
    }


    @Column(name = "GROUP_ID")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}
