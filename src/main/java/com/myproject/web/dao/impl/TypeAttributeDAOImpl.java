package com.myproject.web.dao.impl;

import com.myproject.web.dao.TypeAttributeDAO;
import com.myproject.web.domain.TypeAttribute;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 20.09.13
 * Time: 3:17
 * To change this template use File | Settings | File Templates.
 */
public class TypeAttributeDAOImpl implements TypeAttributeDAO {

    @Override
    public void add(TypeAttribute typeAttribute) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(typeAttribute);

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
    public void update(TypeAttribute typeAttribute) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(typeAttribute);

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
    public TypeAttribute getById(Long id) {
        Session session = null;
        TypeAttribute typeAttribute = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            typeAttribute = (TypeAttribute) session.getNamedQuery("typeAttribute.getById").
                    setParameter("id", id).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return typeAttribute;
    }

    @Override
    public Collection getByTypeId(Long typeId) {
        Session session = null;
        //Product product = null;
        List typeAttributes = new ArrayList();

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            typeAttributes = session.getNamedQuery("typeAttribute.getByTypeId").setParameter("id", typeId).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return typeAttributes;
    }

    @Override
    public Collection getAll() {
        Session session = null;
        List typeAttributes = new ArrayList<TypeAttribute>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            typeAttributes = session.createCriteria(TypeAttribute.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return typeAttributes;
    }

    @Override
    public void delete(TypeAttribute typeAttribute) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(typeAttribute);
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
