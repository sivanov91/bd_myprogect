package com.myproject.app.dao;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 9:35
 * To change this template use File | Settings | File Templates.
 */

import com.myproject.app.domain.Role;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

public interface RoleDAO {

    public void addRole( Role role );
    public void updateRole(Role role);
    public Role getRoleById(Long roleId);
    public Collection getAllRoles() throws SQLException;
    public void deleteRole( Role role) throws SQLException;

}
