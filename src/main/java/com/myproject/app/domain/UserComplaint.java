package com.myproject.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:37
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name ="USER_COMPLAINT" )
public class UserComplaint {
    private Long userComplaintId;
    private String complaint;
    private String data;

    @ManyToOne
    private Long userId;

    @Id
    @GeneratedValue( generator = "increment")
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "USER_COMPLAINT_ID" )
    public Long getUserComplaintId() {
        return userComplaintId;
    }

    public void setUserComplaintId(Long userComplaintId) {
        this.userComplaintId = userComplaintId;
    }

    @Column( name = "COMPLAINT")
    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    @Column( name = "DATA")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column( name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
