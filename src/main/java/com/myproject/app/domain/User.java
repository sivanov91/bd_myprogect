package com.myproject.app.domain;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name = "Users" )
public class User{

    private Long userId;
    private String name;
    private String secondName;
    private String patronymic;
    private String nikname;
    private String email;
    private String passwordHash;
    private String phone;

    private Long roleId;
    private Set<UserComplaint> userComplaints = new HashSet <UserComplaint>();
    private Set<Payment> payments = new HashSet<Payment>();
    private Set<Basket> baskets = new HashSet<Basket>();

    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "user_id" )
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column( name = "name" )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column( name = "second_name" )
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column( name = "patronymic" )
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Column( name = "nikname" )
    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    @Column( name = "email" )
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column( name = "password_hash" )
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Column( name = "phone" )
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column( name = "role_id" )
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @OneToMany
    @JoinColumn( name = "user_id")
    public Set<UserComplaint> getUserComplaints() {
        return userComplaints;
    }

    public void setUserComplaints(Set<UserComplaint> userComplaints) {
        this.userComplaints = userComplaints;
    }


    @OneToMany
    @JoinColumn( name = "user_id")
    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }


    @OneToMany
    @JoinColumn( name = "user_id")
    public Set<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }

}
