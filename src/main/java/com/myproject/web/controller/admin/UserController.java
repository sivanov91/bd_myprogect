package com.myproject.web.controller.admin;

import com.myproject.web.domain.User;
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
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 25.08.13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(ModelMap model) {

        Collection users = Factory.getUserDAO().getAll();
        model.put("users", users);
        return new ModelAndView("usersPage", "model", model);

    }

    @RequestMapping(value = "/users/{id}/edit", method = RequestMethod.GET)
    public ModelAndView userEdit(@PathVariable Long id, ModelMap model, ModelAndView mnv, HttpSession session) {

        User user = Factory.getUserDAO().getById(id);
        Collection userGroups = Factory.getUserGroupDAO().getAll();
        Collection userStatuses = Factory.getUserStatusDAO().getAll();

        model.put("user", user);
        model.put("userGroups", userGroups);
        model.put("userStatuses", userStatuses);

        return new ModelAndView("userEditPage", "model", model);
    }

    @RequestMapping(value = "/users/{id}/edit", method = RequestMethod.POST)
    public ModelAndView userEditSave(@PathVariable Long id, @ModelAttribute("user") User user, ModelMap model, ModelAndView mnv, HttpSession session) {

        Factory.getUserDAO().update(user);

        return new ModelAndView("redirect:/admin/users");
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public ModelAndView userAdd(ModelMap model) {

        User user = new User();
        Collection userGroups = Factory.getUserGroupDAO().getAll();
        Collection userStatuses = Factory.getUserStatusDAO().getAll();

        model.put("user", user);
        model.put("userGroups", userGroups);
        model.put("userStatuses", userStatuses);

        return new ModelAndView("userEditPage", "model", model);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ModelAndView userAddSave(@ModelAttribute("user") User user, ModelMap model) {
        Factory.getUserDAO().add(user);

        return new ModelAndView("redirect:/admin/users");
    }

    @RequestMapping(value = "/users/{id}/del", method = RequestMethod.GET)
    public ModelAndView userDel(@PathVariable Long id, ModelMap model, ModelAndView mnv, HttpSession session) {
        User user = Factory.getUserDAO().getById(id);

        if (user != null) {
            Factory.getUserDAO().delete(user);
        }

        return new ModelAndView("redirect:/admin/users");
    }
}
