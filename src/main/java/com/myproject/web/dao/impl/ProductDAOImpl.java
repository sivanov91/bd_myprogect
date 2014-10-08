package com.myproject.web.dao.impl;

import com.myproject.web.dao.ProductDAO;
import com.myproject.web.domain.Product;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 21.07.13
 * Time: 22:02
 * To change this template use File | Settings | File Templates.
 */

public class ProductDAOImpl implements ProductDAO {

    public void add(Product product) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(product);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(Product product) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(product);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Product getById(Long productId) {
        Session session = null;
        Product product = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            product = (Product) session.getNamedQuery("product.getById").setParameter("id", productId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return product;
    }

    @Override
    public Collection getByCategoryId(Long categoryId) {
        Session session = null;
        //Product product = null;
        List products = new ArrayList<Product>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            products = session.getNamedQuery("product.getByCategoryId").setParameter("id", categoryId).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return products;
    }

    public Collection getAll() {
        Session session = null;
        List products = new ArrayList<Product>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            products = session.createCriteria(Product.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return products;
    }

    public void delete(Product product) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(product);
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
