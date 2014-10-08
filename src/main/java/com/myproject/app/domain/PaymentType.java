package com.myproject.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:37
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name = "PAYMENT_TYPE" )
public class PaymentType {

    private Long paymentTypeId;
    private String name;

    private Set<Payment> payments = new HashSet<Payment>();

    @Id
    @GeneratedValue( generator = "increment")
    @GenericGenerator( name = "increment", strategy = "increment")
    @Column( name = "PYMENT_TYPE_ID")
    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @Column( name = "NAME" )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn( name = "PYMENT_TYPE_ID")
    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
