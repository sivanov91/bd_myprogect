package com.myproject.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:38
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name = "PAYMENT" )
public class Payment {
    private Long paymentId;
    private String cardNumber;
    private String cardSecurityCode;

    private Long paymentType;
    private Long userId;
    private Set<Queue> queues = new HashSet<Queue>();


    @Id
    @GeneratedValue( generator = "increment")
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "PAYMENT_ID")
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    @Column( name = "CARD_NUMBER" )
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Column( name = "CARD_SECURITY_CODE" )
    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    @Column( name = "PAYMENT_TYPE" )
    public Long getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Long paymentType) {
        this.paymentType = paymentType;
    }

    @Column( name = "USER_ID" )
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    @OneToMany
    @JoinColumn( name = "PAYMENT_ID")
    public Set<Queue> getQueues() {
        return queues;
    }

    public void setQueues(Set<Queue> queues) {
        this.queues = queues;
    }
}
