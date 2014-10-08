package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */

/*

CREATE TABLE ORDER_STATUS
(
	ORDER_STATUS_ID  INTEGER NULL,
	NAME  VARCHAR(32) NULL,
	DESCRIPTION  CHAR(100) NULL
)
;

 */

@NamedQueries({
        @NamedQuery(name = "orderStatus.getById", query = "from OrderStatus where orderStatusId =:id")
})

@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatus {

    private Long orderStatusId;
    private String name;
    private String description;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ORDER_STATUS_ID")
    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
