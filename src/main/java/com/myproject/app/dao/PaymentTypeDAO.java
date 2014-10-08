package com.myproject.app.dao;

import com.myproject.app.domain.PaymentType;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */

public interface PaymentTypeDAO {

    public void addPaymentType(PaymentType paymentType);
    public void updatePaymentType(PaymentType paymentType);
    public PaymentType getPaymentTypeById(Long PaymentTypeId);
    public Collection getAllPaymentType() throws SQLException;
    public void deletePaymentType(PaymentType paymentType) throws SQLException;

}
