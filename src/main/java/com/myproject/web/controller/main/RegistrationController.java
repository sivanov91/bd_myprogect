package com.myproject.web.controller.main;

import com.myproject.web.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 26.08.13
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */


@Controller
public class RegistrationController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getIndex(ModelMap model) {

        boolean isRegistred = false;

        User user = new User();
        model.put("user", user);
        model.put("isRegistred", isRegistred);

        return new ModelAndView("registrationPage", "model", model);

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView getRegistrationParsePage(@ModelAttribute(value = "user") User user, ModelMap model) {
        //System.out.println(user.getName());
        //boolean parse = true;
        //model.addAttribute("parse", parse);
        boolean isRegistred = true;


        model.addAttribute("user", user);
        model.put("isRegistred", isRegistred);

        //return "registrationPage";
        return new ModelAndView("registrationPage", "model", model);
    }

}
