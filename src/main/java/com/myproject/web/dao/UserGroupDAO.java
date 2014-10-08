package com.myproject.web.dao;

import com.myproject.web.domain.UserGroup;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 13.07.13
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
public interface UserGroupDAO {
    public void add(UserGroup userGroup);
    public void update(UserGroup userGroup);
    public UserGroup getById(Long groupId);
    public UserGroup getByName(String groupName);

    public Collection getAll();
    public void delete(UserGroup userGroup);
}
