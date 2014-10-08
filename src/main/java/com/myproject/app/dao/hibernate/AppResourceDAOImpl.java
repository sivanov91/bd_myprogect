package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.AppResourceDAO;
import com.myproject.app.domain.AppResource;
import com.myproject.app.domain.Role;
import com.myproject.app.domain.User;
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
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */

public class AppResourceDAOImpl implements AppResourceDAO{

    public void addAppResource(AppResource appResource) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(appResource);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateAppResource(AppResource appResource) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(appResource);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public AppResource getAppResourceById(Long appResourceId) {

        Session session = null;
        AppResource appResource = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            appResource = (AppResource) session.load(AppResource.class, appResourceId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return appResource;
    }

    public Collection getAllAppResource() throws SQLException {

        Session session = null;
        List appResource = new ArrayList<AppResource>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            appResource = session.createCriteria(AppResource.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return appResource;
    }

    public void deleteAppResource(AppResource appResource) throws SQLException {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(appResource);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при удалении" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAppResourceByRole(Role role) throws SQLException {

        Session session = null;
        List appResources = new ArrayList<AppResource>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Long roleId = role.getRoleId();

            Query query = session.createQuery("select a from AppResource a inner join a.roles r where r.roleId = :id").setLong("id", roleId);
            appResources = (List<User>) query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return appResources;
    }
}
