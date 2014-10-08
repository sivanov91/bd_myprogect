package com.myproject.app.dao;

import com.myproject.app.domain.Product;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 16:32
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDAO {

    public void addProduct(Product product);
    public void updateProduct(Product product);
    public Product getProductById(Long productId);
    public Collection getAllProducts() throws SQLException;
    public void deleteProduct(Product product) throws SQLException;

}
