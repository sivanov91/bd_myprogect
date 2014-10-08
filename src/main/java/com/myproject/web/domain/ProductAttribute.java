package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 20.09.13
 * Time: 1:46
 * To change this template use File | Settings | File Templates.
 */


@NamedQueries({
        @NamedQuery(name = "productAttribute.getById", query = "from ProductAttribute where attributeId = :id"),
        @NamedQuery(name = "productAttribute.getByProductId", query = "from ProductAttribute where productId =:id")
})

@Entity
@Table(name = "PRODUCT_ATTRIBUTE")
public class ProductAttribute {

    private String attributeId;
    private String name;
    private String value;

    private Long productId;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ATTRIBUTE_ID")
    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
