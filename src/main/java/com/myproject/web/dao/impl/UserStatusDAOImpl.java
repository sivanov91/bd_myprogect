package com.myproject.web.dao.impl;

import com.myproject.web.dao.UserStatusDAO;
import com.myproject.web.domain.UserStatus;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 13.07.13
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */

public class UserStatusDAOImpl implements UserStatusDAO {


    public void add(UserStatus userStatus) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(userStatus);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(UserStatus userStatus) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(userStatus);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public UserStatus getById(Long statusId) {
        Session session = null;
        UserStatus userStatus = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            userStatus = (UserStatus) session.getNamedQuery("userStatus.getById").setParameter("id", statusId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userStatus;
    }

    public UserStatus getByName(String statusName) {
        Session session = null;
        UserStatus userStatus = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            userStatus = (UserStatus) session.getNamedQuery("userStatus.getByName")
                    .setParameter("name", statusName).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userStatus;
    }

    public Collection getAll() {
        Session session = null;
        List userStatuses = new ArrayList<UserStatus>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            userStatuses = session.createCriteria(UserStatus.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userStatuses;
    }

    public void delete(UserStatus userStatus) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(userStatus);
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
