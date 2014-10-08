package com.myproject.web.dao;

import com.myproject.web.domain.User;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 15.06.13
 * Time: 9:10
 * To change this template use File | Settings | File Templates.
 */

public interface UserDAO {

    public void add( User user );
    public void update(User user );
    public User getById(Long userId);
    public User getByUserName(String userName);

    public Collection getAll();
    public void delete( User user );

}
