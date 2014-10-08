package com.myproject.web.dao;

import com.myproject.web.domain.TypeAttribute;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 20.09.13
 * Time: 2:03
 * To change this template use File | Settings | File Templates.
 */

public interface TypeAttributeDAO {

    public void add(TypeAttribute typeAttribute);

    public void update(TypeAttribute typeAttribute);

    public TypeAttribute getById(Long productId);

    public Collection getByTypeId(Long typeId);

    public Collection getAll();

    public void delete(TypeAttribute typeAttribute);
}
