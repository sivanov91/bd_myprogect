package com.myproject.web.dao;

import com.myproject.web.domain.OrderProduct;
import com.myproject.web.domain.User;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */

public interface OrderProductDAO {

    public void add(OrderProduct orderProduct);
    public void update(OrderProduct orderProduct);
    public OrderProduct getById(Long orderProductId);
    public Collection getByOrderId(Long orderId);

    public Collection getAll();
    public void delete(OrderProduct orderProduct);
    public void deleteByOrderId(Long orderId);

}
