package com.myproject.web.controller.admin;

import com.myproject.web.domain.UserGroup;
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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 26.08.13
 * Time: 22:08
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/admin")
public class UserGroupController {

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public ModelAndView getGroups(ModelMap model, ModelAndView mnv) {
        Collection groups = (List) Factory.getUserGroupDAO().getAll();
        model.put("groups", groups);
        return new ModelAndView("groupsPage", "model", model);

    }

    @RequestMapping(value = "/groups/{id}/edit", method = RequestMethod.GET)
    public ModelAndView groupEdit(@PathVariable Integer id, ModelMap model, ModelAndView mnv, HttpSession session) {

        UserGroup userGroup = Factory.getUserGroupDAO().getById(new Long(id));
        model.put("group", userGroup);

        return new ModelAndView("groupEditPage", "model", model);
    }

    @RequestMapping(value = "/groups/{id}/edit", method = RequestMethod.POST)
    public ModelAndView groupEditSave(@PathVariable Integer id, @ModelAttribute("group") UserGroup group, ModelMap model, ModelAndView mnv, HttpSession session) {

        Factory.getUserGroupDAO().update(group);
        return new ModelAndView("redirect:/admin/groups");
    }

    @RequestMapping(value = "/groups/add", method = RequestMethod.GET)
    public ModelAndView groupAdd(ModelMap model) {

        UserGroup userGroup = new UserGroup();
        model.put("group", userGroup);

        return new ModelAndView("groupEditPage", "model", model);
    }

    @RequestMapping(value = "/groups/add", method = RequestMethod.POST)
    public ModelAndView goupAddSave(@ModelAttribute("group") UserGroup group, ModelMap model, ModelAndView mnv, HttpSession session) {


        if (!group.getName().equals("")) {
            Factory.getUserGroupDAO().add(group);
            return new ModelAndView("redirect:/admin/groups");
        }


        model.put("group", group);
        return new ModelAndView("groupEditPage", "model", model);
    }

    @RequestMapping(value = "/groups/{id}/del", method = RequestMethod.GET)
    public ModelAndView groupDel(@PathVariable Integer id, ModelMap model, ModelAndView mnv, HttpSession session) {

        UserGroup userGroup = Factory.getUserGroupDAO().getById(new Long(id));

        Factory.getUserGroupDAO().delete(userGroup);
        return new ModelAndView("redirect:/admin/groups");

    }
}
