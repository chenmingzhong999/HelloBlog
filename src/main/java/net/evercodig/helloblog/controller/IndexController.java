package net.evercodig.helloblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "indexjsp";
    }
    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public String index1(){
        return "index";
    }
}
