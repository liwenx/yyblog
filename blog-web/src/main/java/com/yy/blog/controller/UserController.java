package com.yy.blog.controller;

import com.yy.blog.domain.user.User;
import com.yy.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwenxing
 * @date 2018/1/9 21:37
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insertUser", method = {RequestMethod.GET,RequestMethod.POST})
    public String insertUser(User user){
        userService.insertUser(user);
        return "success";
    }
}
