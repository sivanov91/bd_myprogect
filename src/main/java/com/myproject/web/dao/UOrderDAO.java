package com.myproject.web.dao;

import com.myproject.web.domain.Product;
import com.myproject.web.domain.UOrder;
import com.myproject.web.domain.User;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */

public interface UOrderDAO {

    public void add(UOrder uOrder);
    public int addOrders(UOrder uOrder, Collection<Product> orders);
    public void update(UOrder uOrder);
    public UOrder getById(Long orderId);
    public Collection getByUserId(Long userId);

    public Collection getAll();
    public void delete(UOrder uOrder);

}
