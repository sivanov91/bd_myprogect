package com.myproject.web.controller.admin;

import com.myproject.web.GlobalSettings;
import com.myproject.web.domain.Category;
import com.myproject.web.domain.Product;
import com.myproject.web.domain.User;
import com.myproject.web.domain.UserGroup;
import com.myproject.web.util.Factory;
import org.apache.log4j.Logger;
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
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 14.06.13
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    protected static Logger logger = Logger.getLogger("controller");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage() {
        logger.debug("Received request to show admin page");
        return "adminPage";
    }





}
