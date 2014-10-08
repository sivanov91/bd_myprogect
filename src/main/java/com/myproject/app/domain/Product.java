package com.myproject.app.domain;

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
@Table( name = "PRODUCT" )
public class Product {

    private Long productId;
    private String productName;
    private Long price;
    private String description;
    private Long quantity;

    private Set<BasketIthem> basketIthems = new HashSet<BasketIthem>();

    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column( name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column( name = "PRICE" )
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Column( name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column( name = "QUANTITY")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @OneToMany
    @JoinColumn( name = "PRODUCT_ID")
    public Set<BasketIthem> getBasketIthems() {
        return basketIthems;
    }

    public void setBasketIthems(Set<BasketIthem> basketIthems) {
        this.basketIthems = basketIthems;
    }
}
