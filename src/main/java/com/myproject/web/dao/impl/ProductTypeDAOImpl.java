package com.myproject.web.dao.impl;

import com.myproject.web.dao.ProductTypeDAO;
import com.myproject.web.domain.Product;
import com.myproject.web.domain.ProductType;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 20.09.13
 * Time: 3:05
 * To change this template use File | Settings | File Templates.
 */
public class ProductTypeDAOImpl implements ProductTypeDAO {

    @Override
    public void add(ProductType productType) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(productType);

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
    public void update(ProductType productType) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(productType);

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
    public ProductType getById(Long typeId) {
        Session session = null;
        ProductType productType = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            productType = (ProductType) session.getNamedQuery("productType.getById").setParameter("id", typeId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return productType;
    }

    @Override
    public Collection getAll() {
        Session session = null;
        Collection<ProductType> productTypes = new ArrayList<ProductType>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            productTypes = session.createCriteria(ProductType.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return productTypes;
    }

    @Override
    public void delete(ProductType productType) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(productType);
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
