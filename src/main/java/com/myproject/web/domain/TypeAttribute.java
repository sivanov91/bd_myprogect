package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 20.09.13
 * Time: 1:53
 * To change this template use File | Settings | File Templates.
 */

@NamedQueries({
        @NamedQuery(name = "typeAttribute.getById", query = "from TypeAttribute where attributeId =:id"),
        @NamedQuery(name = "typeAttribute.getByTypeId", query = "from TypeAttribute where typeId =:id"),
        //@NamedQuery(name="product.getByProductName", query="from User where userName =:userName")
})

@Entity
@Table(name = "TYPE_ATTRIBUTE")
public class TypeAttribute {

    private String attributeId;
    private String name;
    private String value;

    private Long typeId;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "attribte_id")
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

    @Column(name = "DEFAULT_VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "TYPE_ID")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
