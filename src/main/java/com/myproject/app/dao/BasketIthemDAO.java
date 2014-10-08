package com.myproject.app.dao;

import com.myproject.app.domain.BasketIthem;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 */

public interface BasketIthemDAO {
    public void addBasketIthem(BasketIthem basketIthem);
    public void updateBasketIthem(BasketIthem basketIthem);
    public BasketIthem getBasketIthemById(Long basketIthemId);
    public Collection getAllBasketIthem();
    public void deleteBasketIthem(BasketIthem basketIthem);
}
