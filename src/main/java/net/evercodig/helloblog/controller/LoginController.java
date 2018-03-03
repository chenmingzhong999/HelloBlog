package net.evercodig.helloblog.controller;

import net.evercodig.helloblog.common.LoginState;
import net.evercodig.helloblog.pojo.UserVO;
import net.evercodig.helloblog.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录 先查询 后比对
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestBody UserVO userVO){
        LoginState loginState = loginService.compare(userVO);

        logger.info("结果{}", loginState.content);
        return loginState.content;

    }
}
