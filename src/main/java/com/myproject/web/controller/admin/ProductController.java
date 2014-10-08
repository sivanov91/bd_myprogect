package com.myproject.web.controller.admin;

import com.myproject.web.domain.Category;
import com.myproject.web.domain.Product;
import com.myproject.web.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class ProductController {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getproducts(ModelMap model) {

        Collection products = (List) Factory.getProductDAO().getAll();
        model.put("products", products);

        return new ModelAndView("productsPage", "model", model);
    }

    @RequestMapping(value = "/products/{id}/edit", method = RequestMethod.GET)
    public ModelAndView productEdit(@PathVariable Integer id, ModelMap model) {

        Product product = Factory.getProductDAO().getById(new Long(id));
        Collection categories = Factory.getCategoryDAO().getAll();

        model.put("product", product);
        model.put("categories", categories);

        return new ModelAndView("productEditPage", "model", model);
    }

    @RequestMapping(value = "/products/{id}/edit", method = RequestMethod.POST)
    public ModelAndView productEditSave(@ModelAttribute("product") Product product, ModelMap model) {
        Factory.getProductDAO().update(product);

        return new ModelAndView("redirect:/admin/products");
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public ModelAndView productAdd(ModelMap model) {

        Product product = new Product();
        Collection categories = Factory.getCategoryDAO().getAll();

        model.put("product", product);
        model.put("categories", categories);

        return new ModelAndView("productEditPage", "model", model);
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public ModelAndView productAddSave(@ModelAttribute("product") Product product, ModelMap model) {
        Factory.getProductDAO().add(product);

        return new ModelAndView("redirect:/admin/products");
    }

    @RequestMapping(value = "/products/{id}/del", method = RequestMethod.GET)
    public ModelAndView productDel(@PathVariable Integer id, ModelMap model) {

        Product product = Factory.getProductDAO().getById(new Long(id));
        Factory.getProductDAO().delete(product);

        return new ModelAndView("redirect:/admin/products");
    }
}
