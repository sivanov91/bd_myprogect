package com.myproject.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:39
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name = "BASKET")
public class Basket {

    private Long basketId;
    private Long userid;
    private String sessionId;

    private Set<BasketIthem> basketIthems = new HashSet<BasketIthem>();
    private Queue queue = new Queue();

    @Id
    @GeneratedValue( generator = "increment")
    @GenericGenerator( name = "increment", strategy = "increment")
    @Column( name = "BASKET_ID")
    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    @Column( name = "USER_ID")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Column( name ="SESSION_ID" )
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @OneToMany
    @JoinColumn( name = "BASKET_ID" )
    public Set<BasketIthem> getBasketIthems() {
        return basketIthems;
    }

    public void setBasketIthems(Set<BasketIthem> basketIthems) {
        this.basketIthems = basketIthems;
    }


    @OneToOne
    @JoinColumn( name = "BASKET_ID" )
    public Queue getQueues() {
        return queue;
    }

    public void setQueues(Queue queues) {
        this.queue = queues;
    }

}
