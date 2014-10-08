package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */


/*
CREATE TABLE ORDER_PRODUCT
(
	ORDER_PRODUCT_ID  INTEGER NULL,
	PRODUCT_ID  INTEGER NOT NULL,
	ORDER_ID  INTEGER NOT NULL,
	QTY  INTEGER NULL,
	TOTAL  INTEGER NULL
)
;

 */
@NamedQueries({
        @NamedQuery(name = "orderProduct.getById", query = "from OrderProduct where orderProductId =:id"),
        @NamedQuery(name = "orderProduct.getByOrderId", query = "from OrderProduct where orderId =:id"),
        @NamedQuery(name = "orderProduct.deleteByOrderId", query = "delete from OrderProduct where orderId =:id"),
})

@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct {
    private Long orderProductId;
    private Integer qty;
    private Integer total;

    private Long productId;
    private Long orderId;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ORDER_PRODUCT_ID")
    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    @Column(name = "QTY")
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Column(name = "TOTAL")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
