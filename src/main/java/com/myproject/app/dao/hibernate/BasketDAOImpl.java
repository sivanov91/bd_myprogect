package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.BasketDAO;
import com.myproject.app.domain.Basket;
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
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public class BasketDAOImpl implements BasketDAO{

    public void addBasket(Basket basket) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(basket);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateBasket(Basket basket) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(basket);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Basket getBasketById(Long basketId) {

        Session session = null;
        Basket basket = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            basket = (Basket) session.load(Basket.class, basketId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return basket;
    }

    public Collection getAllBasket() {

        Session session = null;
        List baskets = new ArrayList<Basket>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            baskets = session.createCriteria(Basket.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return baskets;
    }

    public void deleteBasket(Basket basket) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(basket);
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
