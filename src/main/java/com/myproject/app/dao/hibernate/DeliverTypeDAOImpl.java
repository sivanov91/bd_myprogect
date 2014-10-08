package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.DeliverTypeDAO;
import com.myproject.app.domain.DeliverType;
import com.myproject.app.domain.User;
import com.myproject.app.util.HibernateUtil;
import org.hibernate.Session;


import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.04.13
 * Time: 9:27
 * To change this template use File | Settings | File Templates.
 */

public class DeliverTypeDAOImpl implements DeliverTypeDAO{

    public void addDeliverType(DeliverType deliverType) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(deliverType);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateDeliverType(DeliverType deliverType) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(deliverType);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public DeliverType getDeliverTypeById(Long deliverTypeId) {

        Session session = null;
        DeliverType deliverType = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            deliverType = (DeliverType) session.load(DeliverType.class, deliverTypeId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return deliverType;
    }

    public Collection getAllDeliverType() {

        Session session = null;
        List deliverTypes = new ArrayList<DeliverType>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            deliverTypes = session.createCriteria(DeliverType.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return deliverTypes;
    }

    public void deleteDeliverType(DeliverType deliverType) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(deliverType);
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
