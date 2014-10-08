package com.myproject.web.dao;

import com.myproject.web.domain.OrderStatus;
import com.myproject.web.domain.User;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */

public interface OrderStatusDAO {

    public void add(OrderStatus orderStatus);
    public void update(OrderStatus orderStatus);
    public OrderStatus getById(Long orderStatusId);

    public Collection getAll();
    public void delete(OrderStatus orderStatus);

}
