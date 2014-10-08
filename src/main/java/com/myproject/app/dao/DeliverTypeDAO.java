package com.myproject.app.dao;

import com.myproject.app.domain.DeliverType;
import java.util.Collection;
import org.hibernate.sql.Delete;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.04.13
 * Time: 8:12
 * To change this template use File | Settings | File Templates.
 */
public interface DeliverTypeDAO {
    public void addDeliverType(DeliverType deliverType);
    public void updateDeliverType(DeliverType deliverType);
    public DeliverType getDeliverTypeById(Long deliverTypeId);
    public Collection getAllDeliverType();
    public void deleteDeliverType(DeliverType deliverType);
}
