package com.myproject.web.dao;

import com.myproject.web.domain.UserStatus;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 13.07.13
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
public interface UserStatusDAO {
    public void add(UserStatus userStatus);
    public void update(UserStatus userStatus );
    public UserStatus getById(Long statusId);
    public UserStatus getByName(String statusName);

    public Collection getAll();
    public void delete(UserStatus userStatus);
}
