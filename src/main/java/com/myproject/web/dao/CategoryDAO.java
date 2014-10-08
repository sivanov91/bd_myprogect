package com.myproject.web.dao;

import com.myproject.web.domain.Category;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 21.07.13
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryDAO {

    public void add(Category category);

    public void update(Category category);

    public Category getById(Long categoryId);
    public Category getByIdentifier(String identifier);

    public Collection getAll();

    public void delete(Category category);

}
