package com.myproject.app.domain;

//import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table( name = "DELIVER")
public class Deliver {

    private Long deliverId;
    private String name;
    private String address;
    private String phone;
    private Long price;

    private Long deliverTypeId;
    private Set<Queue> Queues = new HashSet<Queue>();


    @Id
    @GeneratedValue( generator = "increment")
    @GenericGenerator( name = "increment", strategy = "increment")
    @Column( name = "DELIVER_ID")
    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    @Column( name ="NAME" )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column( name = "ADDRES" )
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column( name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column( name = "PRICE")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Column( name = "DELIVER_TYPE_ID" )
    public Long getDeliverTypeId() {
        return deliverTypeId;
    }

    public void setDeliverTypeId(Long deliverTypeId) {
        this.deliverTypeId = deliverTypeId;
    }


    @OneToMany
    @JoinColumn( name = "DELIVER_ID" )
    public Set<Queue> getQueues() {
        return Queues;
    }

    public void setQueues(Set<Queue> queues) {
        Queues = queues;
    }

}
