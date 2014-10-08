package com.myproject.web.dao.impl;

import com.myproject.web.dao.UOrderDAO;
import com.myproject.web.domain.OrderProduct;
import com.myproject.web.domain.Product;
import com.myproject.web.domain.UOrder;
import com.myproject.web.util.Factory;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */

public class UOrderDAOImpl implements UOrderDAO {

    @Override
    public void add(UOrder uOrder) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(uOrder);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public int addOrders(UOrder uOrder, Collection<Product> orders) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();


            //if (userId != null)
            //    uOrder.setUserId(userId);

            //Collection<Product> orders = (Collection) session.getAttribute("orders");

            //if (orders.size() == 0) ;

            int total = 0;
            for (Product product : orders) {
                total += product.getPrice() * product.getQty();
            }

            uOrder.setOrderStatusId(new Long(2));
            uOrder.setTotal(total);
            uOrder.setCreateDate(new Date());
            uOrder.setEditDate(new Date());
            //Factory.getuOrderDAO().add(uOrder);

            session.save(uOrder);


            for (Product product : orders) {
                Long pid = product.getProductId();
                Product originalProduct = Factory.getProductDAO().getById(new Long(pid));

                int qty = originalProduct.getQty() - product.getQty();

                if (qty < 0) {
                    session.getTransaction().rollback();
                    return 1;
                }

                originalProduct.setQty(qty);
                session.update(originalProduct);

                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setOrderId(uOrder.getOrderId());
                orderProduct.setProductId(product.getProductId());
                orderProduct.setQty(product.getQty());
                orderProduct.setTotal(product.getQty() * product.getPrice());
                session.save(orderProduct);
                //Factory.getOrderProductDAO().add(orderProduct);
            }

            //session.save(uOrder);
            try {
                Thread.sleep(10000);

            } catch (Exception e) {

            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return 0;
    }

    @Override
    public void update(UOrder uOrder) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(uOrder);

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
    public UOrder getById(Long orderId) {
        Session session = null;
        UOrder uOrder = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            uOrder = (UOrder) session.getNamedQuery("uOrder.getById").setParameter("id", orderId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return uOrder;
    }

    @Override
    public Collection getByUserId(Long userId) {

        Session session = null;
        Collection<UOrder> uOrders = new ArrayList<UOrder>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            uOrders = (Collection) session.getNamedQuery("uOrder.getByUserId").setParameter("id", userId).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return uOrders;

    }

    @Override
    public Collection getAll() {
        Session session = null;
        List uOrders = new ArrayList<UOrder>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            uOrders = session.createCriteria(UOrder.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return uOrders;
    }

    @Override
    public void delete(UOrder uOrder) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(uOrder);
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
