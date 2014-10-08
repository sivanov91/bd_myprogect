package com.myproject.app.domain;

import org.hibernate.annotations.GenericGenerator;
//import sun.rmi.runtime.NewThreadAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:41
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name = "DELIVER_TYPE" )
public class DeliverType {

    private Long deliverTypeId;
    private String Name;
    private String Description;

    private Set<Deliver> delivers = new HashSet<Deliver>();

    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "DELIVER_TYPE_ID")
    public Long getDeliverTypeId() {
        return deliverTypeId;
    }

    public void setDeliverTypeId(Long deliverTypeId) {
        this.deliverTypeId = deliverTypeId;
    }

    @Column( name = "NAME")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column( name = "DESCRIPTION")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @OneToMany
    @JoinColumn( name = "DELIVER_TYPE_ID")
    public Set<Deliver> getDelivers() {
        return delivers;
    }

    public void setDelivers(Set<Deliver> delivers) {
        this.delivers = delivers;
    }
}
