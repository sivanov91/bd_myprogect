package com.myproject.web.controller.admin;

import com.myproject.web.domain.Category;
import com.myproject.web.domain.OrderProduct;
import com.myproject.web.domain.OrderStatus;
import com.myproject.web.domain.UOrder;
import com.myproject.web.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 02.10.13
 * Time: 0:44
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class OrdersController {

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getOrderPage(ModelMap model) {

        Collection<UOrder> orders = Factory.getuOrderDAO().getAll();
        Collection<OrderStatus> statuses = Factory.getOrderStatusDAO().getAll();


        model.put("orders", orders);
        model.put("statuses", statuses);

        return new ModelAndView("ordersPage", "model", model);
    }

    @RequestMapping(value = "/orders/{id}/edit", method = RequestMethod.GET)
    public ModelAndView getOrderEdit(@PathVariable Long id, ModelMap model) {

        UOrder uOrder = Factory.getuOrderDAO().getById(id);
        Collection<OrderProduct> orderProducts = Factory.getOrderProductDAO().getByOrderId(id);
        Collection orderStatuses = Factory.getOrderStatusDAO().getAll();

        model.put("orderStatuses", orderStatuses);
        model.put("order", uOrder);
        model.put("orderProducts", orderProducts);

        //Collection products = (List) Factory.getProductDAO().getAll();
        //Category category = Factory.getCategoryDAO().getById(new Long(id));
        //Collection categories = Factory.getCategoryDAO().getAll();

        //model.put("category", category);
        //model.put("categories", categories);

        return new ModelAndView("orderEditPage", "model", model);
    }

    @RequestMapping(value = "/orders/{id}/edit", method = RequestMethod.POST)
    public ModelAndView getOrderEditSave(@ModelAttribute("order") UOrder uOrder, ModelMap model) {

        Long id = uOrder.getOrderId();
        if (id != null) {
            UOrder oldUOrder = Factory.getuOrderDAO().getById(id);
            uOrder.setCreateDate(oldUOrder.getCreateDate());
            uOrder.setEditDate(new Date());

            Factory.getuOrderDAO().update(uOrder);
        }
        return new ModelAndView("redirect:/admin/orders");
    }

    @RequestMapping(value = "/orders/{id}/del", method = RequestMethod.GET)
    public ModelAndView orderDel(@PathVariable Long id, ModelMap model) {

        UOrder uOrder = Factory.getuOrderDAO().getById(id);

        if (uOrder != null) {
            Factory.getOrderProductDAO().deleteByOrderId(id);
            Factory.getuOrderDAO().delete(uOrder);
        }

        //Category category = Factory.getCategoryDAO().getById(new Long(id));
        //Factory.getCategoryDAO().delete(category);

        return new ModelAndView("redirect:/admin/orders");
    }


}
