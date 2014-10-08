package com.myproject.web.controller.admin;

import com.myproject.web.domain.Category;
import com.myproject.web.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 01.09.13
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView getCategories(ModelMap model) {

        Collection categories = (List) Factory.getCategoryDAO().getAll();
        model.put("categories", categories);

        return new ModelAndView("categoriesPage", "model", model);
    }

    @RequestMapping(value = "/categories/{id}/edit", method = RequestMethod.GET)
    public ModelAndView getCategoryEdit(@PathVariable Integer id, ModelMap model) {
        //Collection products = (List) Factory.getProductDAO().getAll();
        Category category = Factory.getCategoryDAO().getById(new Long(id));
        Collection categories = Factory.getCategoryDAO().getAll();

        model.put("category", category);
        model.put("categories", categories);

        return new ModelAndView("categoryEditPage", "model", model);
    }

    @RequestMapping(value = "/categories/{id}/edit", method = RequestMethod.POST)
    public ModelAndView getCategoryEditSave(@ModelAttribute("category") Category category, ModelMap model) {

        Factory.getCategoryDAO().update(category);


        return new ModelAndView("redirect:/admin/categories");
    }

    @RequestMapping(value = "/categories/add", method = RequestMethod.GET)
    public ModelAndView getCategoryAdd(ModelMap model) {

        Category category = new Category();
        model.put("category", category);

        return new ModelAndView("categoryEditPage", "model", model);
    }

    @RequestMapping(value = "/categories/add", method = RequestMethod.POST)
    public ModelAndView getCategoryAddSave(@ModelAttribute("category") Category category, ModelMap model) {
        Factory.getCategoryDAO().add(category);

        return new ModelAndView("redirect:/admin/categories");
    }

    @RequestMapping(value = "/categories/{id}/del", method = RequestMethod.GET)
    public ModelAndView getCategoryDel(@PathVariable Integer id, ModelMap model) {

        Category category = Factory.getCategoryDAO().getById(new Long(id));

        Factory.getCategoryDAO().delete(category);

        return new ModelAndView("redirect:/admin/categories");
    }

}
