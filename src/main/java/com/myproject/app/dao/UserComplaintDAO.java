package com.myproject.app.dao;

import com.myproject.app.domain.User;
import com.myproject.app.domain.UserComplaint;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */
public interface UserComplaintDAO {
    public void addUserComplaint(UserComplaint userComplaint);
    public void updateUserComplaint(UserComplaint userComplaint);
    public UserComplaint getUserComplaintById(Long userComplaintId);
    public Collection getAllUserComplaint() throws SQLException;
    public void deleteUserComplaint(UserComplaint userComplaint) throws SQLException;

    public Collection getUserComplaintByUser(User user);
}
