package com.myproject.app.dao.hibernate;

import com.myproject.app.dao.QueueDAO;
import com.myproject.app.domain.Queue;
import com.myproject.app.domain.User;
import com.myproject.app.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.04.13
 * Time: 9:35
 * To change this template use File | Settings | File Templates.
 */

public class QueueDAOImpl implements QueueDAO{

    public void addQueue(Queue queue) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(queue);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateQueue(Queue queue) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(queue);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Queue getQueueById(Long queueId) {

        Session session = null;
        Queue queue = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            queue = (Queue) session.load(Queue.class, queueId);
        } catch (Exception e) {
            System.err.println("Ошибка 'findById'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return queue;
    }

    public Collection getAllQueue() {

        Session session = null;
        List queues = new ArrayList<Queue>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            queues = session.createCriteria(Queue.class).list();
        } catch (Exception e) {
            System.err.println("Ошибка 'getAll'" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return queues;
    }

    public void deleteQueue(Queue queue) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(queue);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Ошибка при удалении" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getQueueByUser(User user) {

        Session session = null;
        List queues = new ArrayList<Queue>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Long userId = user.getUserId();

            Query query = session.createQuery("select q  from User u inner join u.baskets b inner join b.queue q  where User.userId = :Id").setLong("Id", userId);
            queues = (List<Queue>) query.list();

            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return queues;
    }

}
