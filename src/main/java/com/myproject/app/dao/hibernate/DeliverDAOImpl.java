package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.DeliverDAO;
import com.myproject.app.domain.Deliver;
import com.myproject.app.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.04.13
 * Time: 9:22
 * To change this template use File | Settings | File Templates.
 */
public class DeliverDAOImpl implements DeliverDAO{

    public void addDeliver(Deliver deliver) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(deliver);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateDeliver(Deliver deliver) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(deliver);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Deliver getDeliverById(Long deliverId) {

        Session session = null;
        Deliver deliver = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            deliver = (Deliver) session.load(Deliver.class, deliverId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return deliver;
    }

    public Collection getAllDeliver() {

        Session session = null;
        List delivers = new ArrayList<Deliver>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            delivers = session.createCriteria(Deliver.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return delivers;
    }

    public void deleteDelevet(Deliver deliver) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(deliver);
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
