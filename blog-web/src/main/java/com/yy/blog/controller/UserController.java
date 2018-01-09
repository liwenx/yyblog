package com.yy.blog.controller;

import com.yy.blog.domain.user.User;
import com.yy.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwenxing
 * @date 2018/1/9 21:37
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public String insertUser(User user){
        userService.insertUser(user);
        return "success";
    }
}
