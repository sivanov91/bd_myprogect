package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.BasketIthemDAO;
import com.myproject.app.domain.BasketIthem;
import com.myproject.app.domain.User;
import com.myproject.app.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class BasketIthemDAOImpl implements BasketIthemDAO{

    public void addBasketIthem(BasketIthem basketIthem) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(basketIthem);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateBasketIthem(BasketIthem basketIthem) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(basketIthem);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public BasketIthem getBasketIthemById(Long basketIthemId) {

        Session session = null;
        BasketIthem basketIthem = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            basketIthem = (BasketIthem) session.load(BasketIthem.class, basketIthemId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return basketIthem;
    }

    public Collection getAllBasketIthem(){

        Session session = null;
        List basketIthems = new ArrayList<BasketIthem>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            basketIthems = session.createCriteria(BasketIthem.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return basketIthems;
    }

    public void deleteBasketIthem(BasketIthem basketIthem) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(basketIthem);
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
