package com.myproject.web.controller.main;

import com.myproject.web.domain.Category;
import com.myproject.web.domain.Product;
import com.myproject.web.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 22.09.13
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class ProductViewController {

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView getCatalog(@PathVariable Long id, ModelMap model) {

        Product product = Factory.getProductDAO().getById(id);
        model.put("product", product);
        //Category category = Factory.getCategoryDAO().getByIdentifier(identifier);
        //Collection products = Factory.getProductDAO().getByCategoryId(category.getCategoryId());


        //model.put("products", products);
        //model.put("category", category);
        //Collection products = (List) Factory.getProductDAO().getAll();
        //Category category = Factory.getCategoryDAO().getById(new Long(id));
        //Collection categories = Factory.getCategoryDAO().getAll();

        //model.put("category", category);
        //model.put("categories", categories);

        return new ModelAndView("productViewPage", "model", model);
    }
}
