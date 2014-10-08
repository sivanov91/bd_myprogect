package com.myproject.web.dao;

import com.myproject.web.domain.ProductType;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 20.09.13
 * Time: 2:04
 * To change this template use File | Settings | File Templates.
 */


public interface ProductTypeDAO {

    public void add(ProductType productType);

    public void update(ProductType productType);

    public ProductType getById(Long typeId);

    public Collection getAll();

    public void delete(ProductType productType);

}
