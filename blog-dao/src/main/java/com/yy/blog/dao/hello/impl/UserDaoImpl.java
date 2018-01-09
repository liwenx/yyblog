package com.yy.blog.dao.hello.impl;

import com.yy.blog.dao.hello.UserDao;
import com.yy.blog.domain.user.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liwenxing
 * @date 2018/1/9 21:24
 */
@Component("userDao")
public class UserDaoImpl implements UserDao {

    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void insertUser(User user) {
        sqlSessionTemplate.insert("user.insertUser", user);
    }
}
