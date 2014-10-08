package com.myproject.web.dao.impl;

import com.myproject.web.dao.UserDAO;
import com.myproject.web.domain.User;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 */

public class UserDAOImpl implements UserDAO{


    public void add(User user) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(User user) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public User getById(Long userId) {

        Session session = null;
        User user = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            user = (User)session.getNamedQuery("users.getById").setParameter("id", userId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return user;
    }

    public User getByUserName(String userName) {

        Session session = null;
        User user = null;
        try {
            session = com.myproject.app.util.HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            user = (User)session.getNamedQuery("users.getByUserName").setParameter("userName", userName).uniqueResult();

            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public Collection getAll() {

        Session session = null;
        List users = new ArrayList<User>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public void delete(User user) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при удалении" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
