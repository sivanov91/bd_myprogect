package com.myproject.web.controller.main;

import com.myproject.web.domain.*;
import com.myproject.web.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 22.09.13
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/")
public class BasketController {

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String getBasketPage() {
        return "basketPage";
    }

    @RequestMapping(value = "/basket/add/{id}", method = RequestMethod.GET)
    public ModelAndView basketAdd(@PathVariable Long id, ModelMap model, HttpSession session) {

        //Collection<Product> orders = (Collection<Product>) session.getAttribute("orders");

        //if (orders == null)
        //    orders = new ArrayList<Product>();

        Product originalProduct = Factory.getProductDAO().getById(id);

        if (originalProduct != null) {

            Product product = new Product();

            product.setProductId(originalProduct.getProductId());

            product.setPrice(originalProduct.getPrice());
            product.setProductName(originalProduct.getProductName());
            product.setDescription(originalProduct.getDescription());
            product.setQty(1);

            model.put("product", product);

        } else {
            return new ModelAndView("redirect:/basket");
        }

        return new ModelAndView("basketProductEditPage", "model", model);
    }

    @RequestMapping(value = "/basket/add/{id}", method = RequestMethod.POST)
    public ModelAndView basketAddSave(@PathVariable Long id, @ModelAttribute("product") Product product, ModelMap model, HttpSession session) {


        Collection<Product> orders = (Collection<Product>) session.getAttribute("orders");

        if (orders == null)
            orders = new ArrayList<Product>();

        Product originalProduct = Factory.getProductDAO().getById(id);

        if (originalProduct != null) {

            product.setProductId(originalProduct.getProductId());

            product.setPrice(originalProduct.getPrice());
            product.setProductName(originalProduct.getProductName());
            product.setDescription(originalProduct.getDescription());
            //product.setQty(1);


            boolean contain = false;
            for (Product productItem : orders) {
                if (productItem.getProductId() == id) {
                    Integer qty = product.getQty() + productItem.getQty();
                    productItem.setQty(qty);
                    contain = true;
                    break;
                }
            }

            if (!contain)
                orders.add(product);

            session.setAttribute("orders", orders);

        }


        return new ModelAndView("redirect:/basket");
    }

    @RequestMapping(value = "/basket/clean", method = RequestMethod.GET)
    public ModelAndView basketClean(ModelMap model, HttpSession session) {

        Collection<Product> orders = (Collection<Product>) session.getAttribute("orders");

        if (orders == null)
            orders = new ArrayList<Product>();

        orders.clear();
        session.removeAttribute("orders");
        session.setAttribute("orders", orders);

        return new ModelAndView("redirect:/basket");
    }

    @RequestMapping(value = "/basket/save", method = RequestMethod.GET)
    public ModelAndView basketEditSave(ModelMap model, HttpSession session) {

        UOrder uOrder = new UOrder();

        Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {
            User user = Factory.getUserDAO().getById(userId);

            uOrder.setFirstName(user.getFirstName());
            uOrder.setLastName(user.getLastName());
            uOrder.setEmail(user.getEmail());

        }

        Collection<Product> orders = (Collection) session.getAttribute("orders");
        int total = 0;
        for (Product product : orders)
            total = product.getPrice() * product.getQty();
        uOrder.setTotal(total);

        model.put("uOrder", uOrder);


        return new ModelAndView("basketSavePage", "model", model);
    }

    @RequestMapping(value = "/basket/save", method = RequestMethod.POST)
    public ModelAndView basketSave(ModelMap model, @ModelAttribute("uOrder") UOrder uOrder, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId != null)
            uOrder.setUserId(userId);

        Collection<Product> orders = (Collection) session.getAttribute("orders");

        if (orders.size() == 0) ;

        int total = 0;
        for (Product product : orders) {
            total += product.getPrice() * product.getQty();
        }

        uOrder.setOrderStatusId(new Long(2));
        uOrder.setTotal(total);
        uOrder.setCreateDate(new Date());
        uOrder.setEditDate(new Date());

        int err = Factory.getuOrderDAO().addOrders(uOrder, orders);

        //Factory.getuOrderDAO().add(uOrder);
        /*
        for (Product product : orders) {

            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrderId(uOrder.getOrderId());
            orderProduct.setProductId(product.getProductId());
            orderProduct.setQty(product.getQty());
            orderProduct.setTotal(product.getQty() * product.getPrice());

            Factory.getOrderProductDAO().add(orderProduct);
        }
        */
        if (err == 0) {
            orders.clear();
            session.setAttribute("orders", orders);
        }

        //System.out.println("------------------------------------------------------");
        //System.out.println("OrderId : " + uOrder.getOrderId());
        //System.out.println("------------------------------------------------------");


        //FIXIT
        //Collection<UOrder> uOrders= Factory.getuOrderDAO().getAll();

        //for(UOrder zz: uOrders){
        //     if(zz.getTotal() == uOrder.getTotal() && uOrder.getUserId() == zz.getUserId()){

        //   }
        //}

        return new ModelAndView("redirect:/basket");
        //return new ModelAndView("basketSavePage", "model", model);
    }


}
