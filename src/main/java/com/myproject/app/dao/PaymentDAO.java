package com.myproject.app.dao;

import com.myproject.app.domain.Payment;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 13.04.13
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */

public interface PaymentDAO {

    public void addPayment(Payment payment);
    public void updatePayment(Payment payment);
    public Payment getPaymentById(Long paymentId);
    public Collection getAllPayment() throws SQLException;
    public void deletePayment(Payment payment) throws SQLException;

}

