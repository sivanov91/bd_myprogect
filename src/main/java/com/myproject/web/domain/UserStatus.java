package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 13.07.13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */

/*
CREATE TABLE USER_STATUS
(
	USER_STATUS_ID  INTEGER NULL,
	NAME  CHAR(32) NULL
)
;
 */
@NamedQueries({
        @NamedQuery(name = "userStatus.getById", query = "from UserStatus where statusId =:id"),
        @NamedQuery(name = "userStatus.getByName", query = "from UserStatus where name =:name")
})

@Entity
@Table(name = "USER_STATUS")
public class UserStatus {

    private Long statusId;
    private String name;


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "USER_STATUS_ID")
    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
