package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.PaymentDAO;
import com.myproject.app.domain.Payment;
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
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class PaymentDAOImpl implements PaymentDAO{

    public void addPayment(Payment payment) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(payment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updatePayment(Payment payment) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(payment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Payment getPaymentById(Long paymentId) {

        Session session = null;
        Payment payment = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            payment = (Payment) session.load(Payment.class, paymentId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return payment;
    }

    public Collection getAllPayment() throws SQLException {

        Session session = null;
        List payments = new ArrayList<Payment>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            payments = session.createCriteria(Payment.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return payments;
    }

    public void deletePayment(Payment payment) throws SQLException {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(payment);
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
