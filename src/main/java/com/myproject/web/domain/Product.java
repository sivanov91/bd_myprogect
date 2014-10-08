package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 21.07.13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
/*
CREATE TABLE PRODUCT
(
	PRODUCT_ID  INTEGER NULL,
	PRODUCT_NAME  VARCHAR(50) NULL,
	PRICE  INTEGER NULL,
	DESCRIPTION  VARCHAR(500) NULL,
	QTY  INTEGER NULL,
	QTY_RESERVE  INTEGER NULL,
	QTY_HOLD  INTEGER NULL,
	RECEIPT_DATE  DATE NULL,
	CATEGORY_ID  INTEGER NULL,
	CREATED_BY  VARCHAR(32) NULL,
	CREATED_DATE  DATE NULL,
	EDIT_DATE  DATE NULL,
	EDIT_BY  VARCHAR(32) NULL
);

 */

@NamedQueries({
        @NamedQuery(name = "product.getById", query = "from Product where productId =:id"),
        @NamedQuery(name = "product.getByCategoryId", query = "from Product where categoryId =:id"),
        //@NamedQuery(name="product.getByProductName", query="from User where userName =:userName")
})

@Entity
@Table(name = "Product")
public class Product {

    private Long productId;
    private String productName;
    private Integer price;
    private String description;
    private Integer qty;
    private Integer qtyReserve;
    private Integer qtyHold;
    private Date receiptDate;
    private String createdBy;
    private Date createdDate;
    private String editBy;
    private Date editDate;

    private Long categoryId;
    private Long typeId;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "QTY")
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Column(name = "QTY_RESERVE")
    public Integer getQtyReserve() {
        return qtyReserve;
    }

    public void setQtyReserve(Integer qtyReserve) {
        this.qtyReserve = qtyReserve;
    }

    @Column(name = "QTY_HOLD")
    public Integer getQtyHold() {
        return qtyHold;
    }

    public void setQtyHold(Integer qtyHold) {
        this.qtyHold = qtyHold;
    }

    @Column(name = "RECEIPT_DATE")
    @Temporal(TemporalType.DATE)
    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "EDIT_BY")
    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }

    @Column(name = "EDIT_DATE")
    @Temporal(TemporalType.DATE)
    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    @Column(name = "CATEGORY_ID")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "TYPE_ID")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
