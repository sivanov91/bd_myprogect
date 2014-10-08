package com.myproject.app.dao;

import com.myproject.app.domain.Deliver;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.04.13
 * Time: 8:12
 * To change this template use File | Settings | File Templates.
 */
public interface DeliverDAO {

    public void addDeliver(Deliver deliver);
    public void updateDeliver(Deliver deliver);
    public Deliver getDeliverById(Long deliverId);
    public Collection getAllDeliver();
    public void deleteDelevet(Deliver deliver);

}
