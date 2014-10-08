package com.myproject.web.dao.impl;

import com.myproject.web.dao.OrderProductDAO;
import com.myproject.web.domain.OrderProduct;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */

public class OrderProductDAOImpl implements OrderProductDAO {

    @Override
    public void add(OrderProduct orderProduct) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(orderProduct);

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
    public void update(OrderProduct orderProduct) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(orderProduct);

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
    public OrderProduct getById(Long orderProductId) {

        Session session = null;
        OrderProduct orderProduct = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            orderProduct = (OrderProduct) session.getNamedQuery("orderProduct.getById").setParameter("id", orderProductId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return orderProduct;
    }

    @Override
    public Collection getByOrderId(Long orderId) {
        Session session = null;
        Collection orderProducts = null;
        //OrderProduct orderProduct = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            orderProducts = (Collection) session.getNamedQuery("orderProduct.getByOrderId").setParameter("id", orderId).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return orderProducts;
    }

    @Override
    public Collection getAll() {
        Session session = null;
        List orderProducts = new ArrayList<OrderProduct>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            orderProducts = session.createCriteria(OrderProduct.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return orderProducts;
    }

    @Override
    public void delete(OrderProduct orderProduct) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(orderProduct);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при удалении" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public void deleteByOrderId(Long orderId) {

        Session session = null;
        //Collection orderProducts = null;
        //OrderProduct orderProduct = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getNamedQuery("orderProduct.deleteByOrderId").setParameter("id", orderId).executeUpdate();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        //return orderProducts;
    }
}
