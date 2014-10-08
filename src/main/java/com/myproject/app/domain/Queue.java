package com.myproject.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:39
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name = "QUEUE" )
public class Queue {
    private Long queueId;
    private String orderDate;
    private String confirmationData;
    private String soledData;
    private String deliveryData;

    private Long paymentId;
    private Long deliverId;
    private Long basketId;

    //private Basket basket = new Basket();

    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "QUEUE_ID")
    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    @Column( name = "ORDER_DATE" )
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Column( name = "CONFIRMATION_DATA")
    public String getConfirmationData() {
        return confirmationData;
    }

    public void setConfirmationData(String confirmationData) {
        this.confirmationData = confirmationData;
    }

    @Column( name = "SOLED_DATA")
    public String getSoledData() {
        return soledData;
    }

    public void setSoledData(String soledData) {
        this.soledData = soledData;
    }

    @Column( name = "DELIVERY_DATA")
    public String getDeliveryData() {
        return deliveryData;
    }

    public void setDeliveryData(String deliveryData) {
        this.deliveryData = deliveryData;
    }

    @Column( name = "PAYMENT_ID")
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    @Column( name = "DELIVER_ID")
    public Long getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    @Column( name = "BASKET_ID")
    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    /*
    @OneToOne
    @JoinColumn( name = "BASKET_ID" )
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
    */
}
