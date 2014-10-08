package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.UserComplaintDAO;
import com.myproject.app.domain.User;
import com.myproject.app.domain.UserComplaint;
import com.myproject.app.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
public class UserComplaintDAOImpl implements UserComplaintDAO{
    public void addUserComplaint(UserComplaint userComplaint) {
                Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(userComplaint);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateUserComplaint(UserComplaint userComplaint) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(userComplaint);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public UserComplaint getUserComplaintById(Long userComplaintId) {

        Session session = null;
        UserComplaint userComplaint = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            userComplaint = (UserComplaint) session.load(UserComplaint.class, userComplaintId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userComplaint;
    }

    public Collection getAllUserComplaint() throws SQLException {

        Session session = null;
        List userComplaints = new ArrayList<UserComplaint>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            userComplaints = session.createCriteria(UserComplaint.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userComplaints;
    }

    public void deleteUserComplaint(UserComplaint userComplaint) throws SQLException {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(userComplaint);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при удалении" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getUserComplaintByUser(User user) {
         Session session = null;
        List userComplaints = new ArrayList<UserComplaint>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Long userId = user.getUserId();

            Query query = session.createQuery("from UserComplaint where userId =:Id").setLong("Id", userId);
            userComplaints = (List<UserComplaint>) query.list();

            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userComplaints;
    }
}
