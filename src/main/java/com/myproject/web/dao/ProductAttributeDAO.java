package com.myproject.web.dao;

import com.myproject.web.domain.ProductAttribute;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 20.09.13
 * Time: 2:04
 * To change this template use File | Settings | File Templates.
 */

public interface ProductAttributeDAO {

    public void add(ProductAttribute productAttribute);
    public void update(ProductAttribute productAttribute);
    public ProductAttribute getById(Long attributeId);
    public Collection getByProductId(Long productId);

    public Collection getAll();
    public void delete(ProductAttribute productAttribute);


}
