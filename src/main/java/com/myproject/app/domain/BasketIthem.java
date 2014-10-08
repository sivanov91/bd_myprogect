package com.myproject.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 8:39
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table( name = "BASKET_ITHEM")
public class BasketIthem {

    private Long basketId;
    private Long productId;
    private Long quantity;


    @Column( name = "BASKET_ID")
    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    @Id
    @Column( name = "PRODUCT_ID" )
    public Long getProductId() {
        return productId;
    }

    @Column( name = "PRODUCT_ID")
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column( name = "QUANTITY")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
