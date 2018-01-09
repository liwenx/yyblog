package com.yy.blog.service.user.impl;

import com.yy.blog.dao.hello.UserDao;
import com.yy.blog.domain.user.User;
import com.yy.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liwenxing
 * @date 2018/1/9 21:41
 */
@Component("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
