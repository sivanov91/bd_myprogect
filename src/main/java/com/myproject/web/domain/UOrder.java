package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */

/*

CREATE TABLE UORDER
(
	ORDER_ID  INTEGER NULL,
	FIRSTNAME  VARCHAR(32) NULL,
	LASTNAME  VARCHAR(32) NULL,
	EMAIL  VARCHAR(32) NULL,
	TELEPHONE  CHAR(18) NULL,
	COMMENT  VARCHAR(64) NULL,
	TOTAL  INTEGER NULL,
	ORDER_STATUS_ID  INTEGER NULL,
	USER_ID  INTEGER NOT NULL,
	CREATED_BY  VARCHAR(32) NULL,
	CREATED_DATE  DATE NULL,
	EDIT_BY  VARCHAR(32) NULL,
	EDIT_DATE  DATE NULL
)
;


 */

@NamedQueries({
        @NamedQuery(name = "uOrder.getById", query = "from UOrder where orderId =:id"),
        @NamedQuery(name = "uOrder.getByUserId", query = "from UOrder where userId =:id")
})
@Entity
@Table(name = "UORDER")
public class UOrder {

    private Long orderId;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String comment;
    private Integer total;
    private String createBy;
    private Date createDate;
    private String editBy;
    private Date editDate;

    private Long orderStatusId;
    private Long userId;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "TELEPHONE")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "TOTAL")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Column(name = "CREATED_BY")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Column(name = "CREATED_DATE")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "EDIT_BY")
    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }

    @Column(name = "EDIT_DATE")
    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    @Column(name = "ORDER_STATUS_ID")
    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
