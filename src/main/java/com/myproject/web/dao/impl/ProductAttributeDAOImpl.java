package com.myproject.web.dao.impl;

import com.myproject.web.dao.ProductAttributeDAO;
import com.myproject.web.domain.ProductAttribute;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 20.09.13
 * Time: 2:50
 * To change this template use File | Settings | File Templates.
 */
public class ProductAttributeDAOImpl implements ProductAttributeDAO {

    @Override
    public void add(ProductAttribute productAttribute) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(productAttribute);

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
    public void update(ProductAttribute productAttribute) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(productAttribute);

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
    public ProductAttribute getById(Long attributeId) {
        Session session = null;
        ProductAttribute productAttribute = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            productAttribute = (ProductAttribute) session.getNamedQuery("productAttribute.getById")
                    .setParameter("id", attributeId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return productAttribute;
    }

    @Override
    public Collection getByProductId(Long productId) {
        Session session = null;
        Collection<ProductAttribute> productAttributes = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            productAttributes = session.getNamedQuery("productAttribute.getByProductId")
                    .setParameter("id", productId).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return productAttributes;
    }

    @Override
    public Collection getAll() {
        Session session = null;
        Collection<ProductAttribute> productAttributes = new ArrayList<ProductAttribute>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            productAttributes = session.createCriteria(ProductAttribute.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return productAttributes;
    }

    @Override
    public void delete(ProductAttribute productAttribute) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(productAttribute);
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
