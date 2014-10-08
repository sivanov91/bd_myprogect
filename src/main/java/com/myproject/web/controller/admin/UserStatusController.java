package com.myproject.web.controller.admin;

import com.myproject.web.domain.User;
import com.myproject.web.domain.UserGroup;
import com.myproject.web.domain.UserStatus;
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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 26.08.13
 * Time: 3:56
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class UserStatusController {

    @RequestMapping(value = "/statuses", method = RequestMethod.GET)
    public ModelAndView getStatuses(ModelMap model) {

        Collection userStatuses = Factory.getUserStatusDAO().getAll();
        model.put("statuses", userStatuses);

        return new ModelAndView("userStatusesPage", "model", model);

    }

    @RequestMapping(value = "/statuses/{id}/edit", method = RequestMethod.GET)
    public ModelAndView statusEdit(@PathVariable Long id, ModelMap model, ModelAndView mnv, HttpSession session) {

        UserStatus userStatus = Factory.getUserStatusDAO().getById(id);
        model.put("status", userStatus);


        return new ModelAndView("userStatusEditPage", "model", model);
    }

    @RequestMapping(value = "/statuses/{id}/edit", method = RequestMethod.POST)
    public ModelAndView statusEditSave(@PathVariable Long id, @ModelAttribute("status") UserStatus status, ModelMap model, ModelAndView mnv, HttpSession session) {

        Factory.getUserStatusDAO().update(status);

        return new ModelAndView("redirect:/admin/statuses");
    }

    @RequestMapping(value = "/statuses/add", method = RequestMethod.GET)
    public ModelAndView statusAdd(ModelMap model) {

        UserStatus userStatus = new UserStatus();
        model.put("status", userStatus);

        return new ModelAndView("userStatusEditPage", "model", model);
    }

    @RequestMapping(value = "/statuses/add", method = RequestMethod.POST)
    public ModelAndView statusAddSave(@ModelAttribute("status") UserStatus status, ModelMap model) {
        Factory.getUserStatusDAO().add(status);

        return new ModelAndView("redirect:/admin/statuses");
    }

    @RequestMapping(value = "/statuses/{id}/del", method = RequestMethod.GET)
    public ModelAndView statusDel(@PathVariable Long id, ModelMap model, ModelAndView mnv, HttpSession session) {
        UserStatus userStatus = Factory.getUserStatusDAO().getById(id);

        if (userStatus != null) {
            Factory.getUserStatusDAO().delete(userStatus);
        }

        return new ModelAndView("redirect:/admin/statuses");
    }

}
