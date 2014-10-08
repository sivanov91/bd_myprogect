package com.myproject.web.controller.main;

import com.myproject.web.domain.Category;
import com.myproject.web.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 04.09.13
 * Time: 19:31
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/")
public class CatologController {

    @RequestMapping(value = "/catalog/{identifier}", method = RequestMethod.GET)
    public ModelAndView getCatalog(@PathVariable String identifier, ModelMap model) {

        Category category = Factory.getCategoryDAO().getByIdentifier(identifier);
        Collection products = Factory.getProductDAO().getByCategoryId(category.getCategoryId());


        model.put("products", products);
        model.put("category", category);


        return new ModelAndView("catalogPage", "model", model);
    }
}
