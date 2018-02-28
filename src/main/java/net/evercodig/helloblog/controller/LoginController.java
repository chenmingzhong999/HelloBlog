package net.evercodig.helloblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.POST)
    public String login(){

        return null;
    }
}
