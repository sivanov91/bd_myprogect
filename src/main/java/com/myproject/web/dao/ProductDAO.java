package com.myproject.web.dao;

import com.myproject.web.domain.Product;
import com.myproject.web.domain.User;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 21.07.13
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDAO {
    public void add(Product product);
    public void update(Product product);
    public Product getById(Long productId);
    public Collection getByCategoryId(Long categoryId);
    //public User getByUserName(String productName);

    public Collection getAll();
    public void delete(Product product);
}
