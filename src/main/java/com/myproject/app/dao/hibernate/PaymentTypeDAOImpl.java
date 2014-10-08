package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.PaymentTypeDAO;
import com.myproject.app.domain.PaymentType;
import com.myproject.app.domain.User;
import com.myproject.app.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class PaymentTypeDAOImpl implements PaymentTypeDAO{

    public void addPaymentType(PaymentType paymentType) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(paymentType);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updatePaymentType(PaymentType paymentType) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(paymentType);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public PaymentType getPaymentTypeById(Long PaymentTypeId) {

        Session session = null;
        PaymentType paymentType = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            paymentType = (PaymentType) session.load(PaymentType.class, PaymentTypeId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return paymentType;
    }

    public Collection getAllPaymentType() throws SQLException {

        Session session = null;
        List paymentTypes = new ArrayList<PaymentType>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            paymentTypes = session.createCriteria(PaymentType.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return paymentTypes;
    }

    public void deletePaymentType(PaymentType paymentType) throws SQLException {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(paymentType);
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
