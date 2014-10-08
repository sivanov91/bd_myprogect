package com.myproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: lnex
 * Date: 06.06.13
 * Time: 17:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(){
        return "index-page";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestPage(){
        return "test-tiles";
    }
}
