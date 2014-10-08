package com.myproject.web.controller.admin;

import com.myproject.web.domain.ProductType;
import com.myproject.web.domain.TypeAttribute;
import com.myproject.web.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 22.09.13
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class AttributeTypeController {

    @RequestMapping(value = "/attributeTypes/{typeId}", method = RequestMethod.GET)
    public ModelAndView getproductTypes(@PathVariable Long typeId, ModelMap model) {

        Collection attributeTypes = Factory.getTypeAttributeDAO().getByTypeId(typeId);
        model.put("attributeTypes", attributeTypes);
        model.put("typeId", typeId);

        //Collection productTypes = Factory.getProductTypeDAO().getAll();
        //model.put("productTypes", productTypes);

        //Collection products = (List) Factory.getProductDAO().getAll();
        //model.put("products", products);

        return new ModelAndView("attributeTypesPage", "model", model);
    }

    @RequestMapping(value = "/attributeTypes/{id}/edit", method = RequestMethod.GET)
    public ModelAndView productTypeEdit(@PathVariable Long id, ModelMap model) {

        TypeAttribute typeAttribute = Factory.getTypeAttributeDAO().getById(id);
        //ProductType productType = Factory.getProductTypeDAO().getById(id);

        //Product product = Factory.getProductDAO().getById(new Long(id));
        //Collection categories = Factory.getCategoryDAO().getAll();

        model.put("typeAttribute", typeAttribute);
        //model.put("categories", categories);

        return new ModelAndView("attributeTypeEditPage", "model", model);
    }

    @RequestMapping(value = "/attributeTypes/{id}/edit", method = RequestMethod.POST)
    public ModelAndView productTypeEditSave(@ModelAttribute("typeAttribute") TypeAttribute typeAttribute, ModelMap model) {
        Factory.getTypeAttributeDAO().update(typeAttribute);

        Long typeId = typeAttribute.getTypeId();


        return new ModelAndView("redirect:/admin/attributeTypes/" + typeId);
    }

    @RequestMapping(value = "/attributeTypes/{typeId}/add", method = RequestMethod.GET)
    public ModelAndView productTypeAdd(@PathVariable Long typeId,ModelMap model) {

        TypeAttribute typeAttribute = new TypeAttribute();
        typeAttribute.setTypeId(typeId);

        //ProductType productType = new ProductType();

        model.put("typeAttribute", typeAttribute);

        return new ModelAndView("attributeTypeEditPage", "model", model);
    }

    @RequestMapping(value = "/attributeTypes/{typeId}/add", method = RequestMethod.POST)
    public ModelAndView productTypeAddSave(@ModelAttribute("typeAttribute") TypeAttribute typeAttribute, ModelMap model) {
        //Factory.getProductDAO().add(product);

        //Factory.getProductTypeDAO().add(productType);
        Factory.getTypeAttributeDAO().add(typeAttribute);

        return new ModelAndView("redirect:/admin/attributeTypes/" + typeAttribute.getTypeId());
    }

    @RequestMapping(value = "/attributeTypes/{id}/del", method = RequestMethod.GET)
    public ModelAndView productTypeDel(@PathVariable Long id, ModelMap model) {

        //ProductType productType = Factory.getProductTypeDAO().getById(id);
        //Factory.getProductTypeDAO().delete(productType);
        //Product product = Factory.getProductDAO().getById(new Long(id));
        //Factory.getProductDAO().delete(product);

        return new ModelAndView("redirect:/admin/attributeTypes");
    }

}
