package com.myproject.web.controller.admin;

import com.myproject.web.domain.Product;
import com.myproject.web.domain.ProductType;
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
 * Date: 21.09.13
 * Time: 0:40
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class ProductTypeController {

    @RequestMapping(value = "/productTypes", method = RequestMethod.GET)
    public ModelAndView getproductTypes(ModelMap model) {

        Collection productTypes = Factory.getProductTypeDAO().getAll();
        model.put("productTypes", productTypes);

        //Collection products = (List) Factory.getProductDAO().getAll();
        //model.put("products", products);

        return new ModelAndView("productTypesPage", "model", model);
    }

    @RequestMapping(value = "/productTypes/{id}/edit", method = RequestMethod.GET)
    public ModelAndView productTypeEdit(@PathVariable Long id, ModelMap model) {

        ProductType productType = Factory.getProductTypeDAO().getById(id);

        //Product product = Factory.getProductDAO().getById(new Long(id));
        //Collection categories = Factory.getCategoryDAO().getAll();

        model.put("productType", productType);
        //model.put("categories", categories);

        return new ModelAndView("productTypeEditPage", "model", model);
    }

    @RequestMapping(value = "/productTypes/{id}/edit", method = RequestMethod.POST)
    public ModelAndView productTypeEditSave(@ModelAttribute("productType") ProductType productType, ModelMap model) {
        Factory.getProductTypeDAO().update(productType);
        //Factory.getProductDAO().update(product);

        return new ModelAndView("redirect:/admin/productTypes");
    }

    @RequestMapping(value = "/productTypes/add", method = RequestMethod.GET)
    public ModelAndView productTypeAdd(ModelMap model) {

        ProductType productType = new ProductType();
        //Product product = new Product();
        //Collection categories = Factory.getCategoryDAO().getAll();

        //model.put("product", product);
        //model.put("categories", categories);
        model.put("productType", productType);

        return new ModelAndView("productTypeEditPage", "model", model);
    }

    @RequestMapping(value = "/productTypes/add", method = RequestMethod.POST)
    public ModelAndView productTypeAddSave(@ModelAttribute("productType") ProductType productType, ModelMap model) {
        //Factory.getProductDAO().add(product);
        Factory.getProductTypeDAO().add(productType);

        return new ModelAndView("redirect:/admin/productTypes");
    }

    @RequestMapping(value = "/productTypes/{id}/del", method = RequestMethod.GET)
    public ModelAndView productTypeDel(@PathVariable Long id, ModelMap model) {

        ProductType productType = Factory.getProductTypeDAO().getById(id);
        Factory.getProductTypeDAO().delete(productType);
        //Product product = Factory.getProductDAO().getById(new Long(id));
        //Factory.getProductDAO().delete(product);

        return new ModelAndView("redirect:/admin/products");
    }
}
