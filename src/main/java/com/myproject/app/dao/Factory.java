package com.myproject.app.dao;

import com.myproject.app.dao.hibernate.*;
import com.myproject.app.domain.*;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 */

public class Factory {
    private static Factory instance = null;
    private static UserDAO userDAO = null;
    private static RoleDAO roleDAO = null;
    private static AppResourceDAO appResourceDAO = null;
    private static UserComplaintDAO userComplaintDAO = null;
    private static PaymentDAO paymentDAO = null;
    private static PaymentTypeDAO paymentTypeDAO = null;
    private static ProductDAO productDAO = null;
    private static BasketDAO basketDAO = null;
    private static BasketIthemDAO basketIthemDAO = null;
    private static DeliverDAO deliverDAO = null;
    private static DeliverTypeDAO deliverTypeDAO = null;
    private static QueueDAO queueDAO = null;


    public static synchronized Factory getInstance() {
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public static UserDAO getUserDAO() {
        if( userDAO == null ) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    public static RoleDAO getRoleDAO() {
        if ( roleDAO == null ){
            roleDAO = new RoleDAOImpl();
        }
        return roleDAO;
    }

    public static AppResourceDAO getAppResourceDAO() {
        if ( appResourceDAO == null ) {
            appResourceDAO = new AppResourceDAOImpl();
        }
        return appResourceDAO;
    }

    public static UserComplaintDAO getUserComplaintDAO() {
        if ( userComplaintDAO == null ){
            userComplaintDAO = new UserComplaintDAOImpl();
        }
        return userComplaintDAO;
    }

    public static PaymentDAO getPaymentDAO() {
        if ( paymentDAO == null ){
            paymentDAO = new PaymentDAOImpl();
        }
        return paymentDAO;
    }

    public static PaymentTypeDAO getPaymentTypeDAO() {
        if (paymentTypeDAO == null){
            paymentTypeDAO = new PaymentTypeDAOImpl();
        }
        return paymentTypeDAO;
    }

    public static ProductDAO getProductDAO() {
        if ( productDAO == null ){
            paymentDAO = new PaymentDAOImpl();
        }
        return productDAO;
    }

    public static BasketDAO getBasketDAO() {
        if ( basketDAO == null){
            basketDAO = new BasketDAOImpl();
        }
        return basketDAO;
    }

    public static BasketIthemDAO getBasketIthemDAO() {
        if ( basketIthemDAO == null){
             basketIthemDAO = new BasketIthemDAOImpl();
        }
        return basketIthemDAO;
    }

    public static DeliverDAO getDeliverDAO() {
        if ( deliverDAO == null){
            deliverDAO = new DeliverDAOImpl();
        }
        return deliverDAO;
    }

    public static DeliverTypeDAO getDeliverTypeDAO() {
        if ( deliverTypeDAO == null ){
            deliverTypeDAO = new DeliverTypeDAOImpl();
        }
        return deliverTypeDAO;
    }

    public static QueueDAO getQueueDAO() {
        if ( queueDAO == null ){
            queueDAO = new QueueDAOImpl();
        }
        return queueDAO;
    }
}
