package com.myproject.web.controller.admin;

import com.myproject.web.domain.OrderStatus;
import com.myproject.web.domain.User;
import com.myproject.web.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 02.09.13
 * Time: 0:08
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class OrderStatusController {

    @RequestMapping(value = "/orderStatuses", method = RequestMethod.GET)
    public ModelAndView getUsers(ModelMap model) {

        //Collection users = Factory.getUserDAO().getAll();
        //model.put("users", users);

        Collection orderStatuses = Factory.getOrderStatusDAO().getAll();
        model.put("orderStatuses", orderStatuses);

        return new ModelAndView("orderStatusesPage", "model", model);

    }

    @RequestMapping(value = "/orderStatuses/{id}/edit", method = RequestMethod.GET)
    public ModelAndView userEdit(@PathVariable Long id, ModelMap model, ModelAndView mnv, HttpSession session) {


        OrderStatus orderStatus = Factory.getOrderStatusDAO().getById(id);

        model.put("orderStatus", orderStatus);

        return new ModelAndView("orderStatusEditPage", "model", model);
    }

    @RequestMapping(value = "/orderStatuses/{id}/edit", method = RequestMethod.POST)
    public ModelAndView userEditSave(@PathVariable Long id, @ModelAttribute("orderStatus") OrderStatus orderStatus, ModelMap model, ModelAndView mnv, HttpSession session) {

        Factory.getOrderStatusDAO().update(orderStatus);

        return new ModelAndView("redirect:/admin/orderStatuses");
    }

    @RequestMapping(value = "/orderStatuses/add", method = RequestMethod.GET)
    public ModelAndView userAdd(ModelMap model) {

        OrderStatus orderStatus = new OrderStatus();
        model.put("orderStatus", orderStatus);

        return new ModelAndView("orderStatusEditPage", "model", model);
    }

    @RequestMapping(value = "/orderStatuses/add", method = RequestMethod.POST)
    public ModelAndView userAddSave(@ModelAttribute("orderStatus") OrderStatus orderStatus, ModelMap model) {
        Factory.getOrderStatusDAO().add(orderStatus);

        return new ModelAndView("redirect:/admin/orderStatuses");
    }

    @RequestMapping(value = "/orderStatuses/{id}/del", method = RequestMethod.GET)
    public ModelAndView userDel(@PathVariable Long id, ModelMap model, ModelAndView mnv, HttpSession session) {
        OrderStatus orderStatus = Factory.getOrderStatusDAO().getById(id);

        if (orderStatus != null) {
            Factory.getOrderStatusDAO().delete(orderStatus);
        }

        return new ModelAndView("redirect:/admin/orderStatuses");
    }
}
