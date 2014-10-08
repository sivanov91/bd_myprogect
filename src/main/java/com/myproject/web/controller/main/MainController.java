package com.myproject.web.controller.main;

import com.myproject.web.domain.OrderStatus;
import com.myproject.web.domain.UOrder;
import com.myproject.web.domain.User;
import com.myproject.web.util.Factory;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/")
//@SessionAttributes({"userId"})
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndexPage(@RequestParam(value = "error", required = false) boolean error, ModelMap model) {

        //String name = SecurityContextHolder.getContext().getAuthentication().getName();
        //User user = null;
        /*
        if(!name.equals("anonymousUser")){
            user = Factory.getUserDAO().getById(new Long(name));
            System.out.println(user.getUserName());
            //System.out.println("----------------------" + user.getNikname() + "----------------------");
            //System.out.println(new Long(name));

        }
        */

        //model.put("USER", user);

        if (error == true) {
            model.put("error", "You have entered an invalid username or password!");
        } else {
            model.put("error", "");
        }

        return new ModelAndView("indexPage", "model", model);
        //return "indexPage";
    }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView getProfilePage(ModelMap model, HttpSession session) {

        //session.getAttribute("userId"));
        //Long Id = new Long(SecurityContextHolder.getContext().getAuthentication().getName());
        //Long userId = new Long((String)session.getAttribute("userId"));
        //User user = Factory.getUserDAO().getById(new Long(userId));

        //System.out.println("UserId: " + userId);


        //ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        //HttpSession session = attr.getRequest().getSession();

        //User user = Factory.getUserDAO().getById(Id);


        /*
        HttpSession session = req.getSession(false);
        if (session == null) {
            System.out.println("Session is not created.");
        } else {
            System.out.println("Session is already created.");
        }
        */


        boolean edit = false;
        //User user = new User();

        //model.addAttribute("USER", user);
        model.addAttribute("parse", edit);

        return new ModelAndView("profilePage", "model", model);
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public ModelAndView getUserPage(@PathVariable String userName, ModelMap model, HttpSession session) {

        User user = Factory.getUserDAO().getByUserName(userName);
        model.put("user", user);
        model.put("pathUserName", userName);

        return new ModelAndView("userPage", "model", model);
    }


    @RequestMapping(value = "/user/{userName}/edit", method = RequestMethod.GET)
    public ModelAndView getUserEditPage(@PathVariable String userName, ModelMap model, HttpSession session) {
        //@ModelAttribute("user") User user
        User user = Factory.getUserDAO().getByUserName(userName);
        model.put("user", user);
        //model.put("pathUserName", userName);

        return new ModelAndView("userEditPage", "model", model);

        /*
        String edit;
        if (user.getUserId() == null) {
            user = Factory.getUserDAO().getByUserName(userName);
            edit = "true";
        } else {
            User tmpUser = Factory.getUserDAO().getByUserName(userName);
            user.setPassword(tmpUser.getPassword());

            Factory.getUserDAO().update(user);
            edit = "false";
        }

        model.put("message", "");
        model.put("user", user);
        model.put("edit", edit);

        return new ModelAndView("profilePage", "model", model);
        */
    }

    @RequestMapping(value = "/user/{userName}/edit", method = RequestMethod.POST)
    public ModelAndView getUserEditPageSave(@PathVariable String userName, @ModelAttribute("user") User user, ModelMap model, HttpSession session) {
        //User user = Factory.getUserDAO().getByUserName(userName);

        User oldUser = Factory.getUserDAO().getByUserName(userName);
        user.setPassword(user.getPassword());
        //Factory.getUserDAO().update(user);

        /*FIXIT add check*/

        model.put("user", user);
        //model.put("pathUserName", userName);


        //return new ModelAndView("userPage", "model", model);
        return new ModelAndView("redirect:/user/" + userName + "/");
    }


    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String getPasswordPage() {
        return "passwordPage";
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public ModelAndView getPasswordParsePage(String pass1, String pass2, ModelMap model, HttpSession session) {
        System.out.println();


        return new ModelAndView("profilePage", "model", model);
    }


    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public String getForgotPage() {
        return "forgotPage";
    }

    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "main/login";
    }*/

    @RequestMapping(value = "/myOrders", method = RequestMethod.GET)
    public ModelAndView getMyOrdersPage(ModelMap model, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            User user = Factory.getUserDAO().getById(userId);

            Collection<UOrder> uOrders = Factory.getuOrderDAO().getByUserId(userId);

            model.put("uOrders", uOrders);
            //model.put("")
            Collection<OrderStatus> orderStatuses = Factory.getOrderStatusDAO().getAll();
            Map<Long, String> statusMap = new HashMap<Long, String>();

            for(OrderStatus orderStatus : orderStatuses)
                statusMap.put(orderStatus.getOrderStatusId(), orderStatus.getName());


            model.put("statusMap", statusMap);

        }

        return new ModelAndView("myOrdersPage", "model", model);
        //return "main/login";
    }

}
