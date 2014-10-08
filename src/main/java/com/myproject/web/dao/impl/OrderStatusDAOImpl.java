package com.myproject.web.dao.impl;

import com.myproject.web.dao.OrderStatusDAO;
import com.myproject.web.domain.OrderStatus;
import com.myproject.web.domain.User;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */

public class OrderStatusDAOImpl implements OrderStatusDAO {

    @Override
    public void add(OrderStatus orderStatus) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(orderStatus);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(OrderStatus orderStatus) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(orderStatus);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public OrderStatus getById(Long orderStatusId) {
        Session session = null;
        OrderStatus orderStatus = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            orderStatus = (OrderStatus) session.getNamedQuery("orderStatus.getById").setParameter("id", orderStatusId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return orderStatus;
    }

    @Override
    public Collection getAll() {

        Session session = null;
        List orderStatuses = new ArrayList<OrderStatus>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            orderStatuses = session.createCriteria(OrderStatus.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return orderStatuses;

    }

    @Override
    public void delete(OrderStatus orderStatus) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(orderStatus);
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
