package com.myproject.app.dao;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 9:35
 * To change this template use File | Settings | File Templates.
 */

import com.myproject.app.domain.Role;
import com.myproject.app.domain.User;
import org.hibernate.sql.Delete;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Collection;

public interface UserDAO {
    public void addUser( User user );
    public void updateUser(User user );
    public User getUserById(Long userId);
    //public User getUserByName(Long userId);
    public Collection getAllUsers() throws SQLException;
    public void deleteUser( User user ) throws SQLException;
}
