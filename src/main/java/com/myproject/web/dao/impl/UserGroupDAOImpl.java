package com.myproject.web.dao.impl;

import com.myproject.web.dao.UserGroupDAO;
import com.myproject.web.domain.User;
import com.myproject.web.domain.UserGroup;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 13.07.13
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */

public class UserGroupDAOImpl implements UserGroupDAO {


    public void add(UserGroup userGroup) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(userGroup);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public void update(UserGroup userGroup) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(userGroup);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public UserGroup getById(Long groupId) {
        Session session = null;
        UserGroup userGroup = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            userGroup = (UserGroup) session.getNamedQuery("userGroup.getById").setParameter("id", groupId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userGroup;
    }

    public UserGroup getByName(String groupName) {
        Session session = null;
        UserGroup userGroup = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            userGroup = (UserGroup) session.getNamedQuery("userGroup.getByName")
                    .setParameter("name", groupName).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userGroup;
    }

    public Collection getAll() {
        Session session = null;
        List userGroups = new ArrayList<UserGroup>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            userGroups = session.createCriteria(UserGroup.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return userGroups;
    }

    public void delete(UserGroup userGroup) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(userGroup);
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
