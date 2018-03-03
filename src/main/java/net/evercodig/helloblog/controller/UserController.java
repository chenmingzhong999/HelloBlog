package net.evercodig.helloblog.controller;

import net.evercodig.helloblog.common.UserState;
import net.evercodig.helloblog.pojo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.evercodig.helloblog.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService UserService;

    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@RequestBody UserVO userVO){
        UserState userState = UserService.userSave(userVO);
        logger.info("用户注册{}",userState.content);
        return userState.content;
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public String updateUser(@PathVariable Integer id, @RequestBody UserVO userVO){
        UserState userState = UserService.userUpdate(userVO);
        logger.info("用户注册{}", userState.content);
        return userState.content;
    }
}
