package com.yy.blog.service.hello.impl;

import com.yy.blog.service.hello.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author liwenxing
 * @date 2018/1/9 20:58
 */
@Component("helloService")
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello() {
        return "hello service";
    }
}
