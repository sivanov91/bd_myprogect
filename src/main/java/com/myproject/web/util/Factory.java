package com.myproject.web.util;

import com.myproject.web.dao.*;
import com.myproject.web.dao.impl.*;
import com.myproject.web.domain.Category;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 15.06.13
 * Time: 9:18
 * To change this template use File | Settings | File Templates.
 */
public class Factory {

    private static Factory instance = null;
    private static UserDAO userDAO = null;
    private static UserGroupDAO userGroupDAO = null;
    private static ProductDAO productDAO = null;
    private static CategoryDAO categoryDAO = null;
    private static UserStatusDAO userStatusDAO = null;
    private static UOrderDAO uOrderDAO = null;
    private static OrderStatusDAO orderStatusDAO = null;
    private static OrderProductDAO orderProductDAO = null;
    private static ProductAttributeDAO productAttributeDAO = null;
    private static ProductTypeDAO productTypeDAO = null;
    private static TypeAttributeDAO typeAttributeDAO = null;

    public static synchronized Factory getInstance() {
        if (instance == null)
            instance = new Factory();
        return instance;
    }

    public static UserDAO getUserDAO() {

        if (userDAO == null)
            userDAO = new UserDAOImpl();
        return userDAO;
    }

    public static UserGroupDAO getUserGroupDAO() {
        if (userGroupDAO == null)
            userGroupDAO = new UserGroupDAOImpl();
        return userGroupDAO;
    }


    public static ProductDAO getProductDAO() {
        if (productDAO == null)
            productDAO = new ProductDAOImpl();
        return productDAO;
    }

    public static CategoryDAO getCategoryDAO() {
        if (categoryDAO == null)
            categoryDAO = new CategoryDAOImpl();
        return categoryDAO;
    }

    public static UserStatusDAO getUserStatusDAO() {
        if (userStatusDAO == null)
            userStatusDAO = new UserStatusDAOImpl();
        return userStatusDAO;
    }

    public static UOrderDAO getuOrderDAO() {
        if (uOrderDAO == null)
            uOrderDAO = new UOrderDAOImpl();
        return uOrderDAO;
    }

    public static OrderStatusDAO getOrderStatusDAO() {
        if (orderStatusDAO == null)
            orderStatusDAO = new OrderStatusDAOImpl();
        return orderStatusDAO;
    }

    public static OrderProductDAO getOrderProductDAO() {
        if (orderProductDAO == null)
            orderProductDAO = new OrderProductDAOImpl();
        return orderProductDAO;
    }

    public static ProductAttributeDAO getProductAttributeDAO() {
        if(productAttributeDAO == null)
            productAttributeDAO = new ProductAttributeDAOImpl();
        return productAttributeDAO;
    }

    public static ProductTypeDAO getProductTypeDAO() {
        if(productTypeDAO == null)
            productTypeDAO = new ProductTypeDAOImpl();
        return productTypeDAO;
    }

    public static TypeAttributeDAO getTypeAttributeDAO() {
        if(typeAttributeDAO == null)
            typeAttributeDAO = new TypeAttributeDAOImpl();
        return typeAttributeDAO;
    }
}
