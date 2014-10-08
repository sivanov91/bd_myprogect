package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.RoleDAO;
import com.myproject.app.domain.Role;
import com.myproject.app.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class RoleDAOImpl implements RoleDAO{
    public void addRole(Role role) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateRole(Role role) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Role getRoleById(Long roleId) {

        Session session = null;
        Role role = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            role = (Role) session.load(Role.class, roleId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return role;

    }

    public Collection getAllRoles() throws SQLException {

        Session session = null;
        List roles = new ArrayList<Role>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            roles = session.createCriteria(Role.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return roles;
    }

    public void deleteRole(Role role) throws SQLException {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(role);
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
