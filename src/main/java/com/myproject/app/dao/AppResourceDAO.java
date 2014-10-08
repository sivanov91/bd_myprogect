package com.myproject.app.dao;

import com.myproject.app.domain.AppResource;
import com.myproject.app.domain.Role;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
public interface AppResourceDAO {
    public void addAppResource(AppResource appResource);
    public void updateAppResource(AppResource appResource);
    public AppResource getAppResourceById(Long appResourceId);
    public Collection getAllAppResource() throws SQLException;
    public void deleteAppResource(AppResource appResource) throws SQLException;

    public Collection getAppResourceByRole(Role role) throws SQLException;
}
