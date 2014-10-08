package com.myproject.web.dao.impl;

import com.myproject.web.dao.CategoryDAO;
import com.myproject.web.domain.Category;
import com.myproject.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 21.07.13
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */

public class CategoryDAOImpl implements CategoryDAO {

    public void add(Category category) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(category);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(Category category) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(category);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Category getById(Long categoryId) {
        Session session = null;
        Category category = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            category = (Category) session.getNamedQuery("category.getById").setParameter("id", categoryId).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return category;
    }

    public Category getByIdentifier(String identifier) {

        Session session = null;
        Category category = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            category = (Category) session.getNamedQuery("category.getByIdentifier").setParameter("identifier", identifier).uniqueResult();

        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return category;

    }

    public Collection getAll() {
        Session session = null;
        List categories = new ArrayList<Category>();

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            categories = session.createCriteria(Category.class).list();

        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return categories;
    }

    public void delete(Category category) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(category);
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

