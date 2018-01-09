package com.yy.blog.controller;

import com.yy.blog.service.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwenxing
 * @date 2018/1/9 20:50
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        return helloService.hello();
    }
}
