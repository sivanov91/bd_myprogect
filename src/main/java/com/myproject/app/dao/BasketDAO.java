package com.myproject.app.dao;

import com.myproject.app.domain.Basket;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */

public interface BasketDAO {

    public void addBasket(Basket basket);
    public void updateBasket(Basket basket);
    public Basket getBasketById(Long basketId);
    public Collection getAllBasket();
    public void deleteBasket(Basket basket);

}
