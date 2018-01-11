package com.yy.blog.redis.test;

import com.yy.blog.BlogApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author liwenxing
 * @date 2018/1/11 10:06
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes= BlogApplication.class)// 指定spring-boot的启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class RedisTest {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Test
    public void redisTest1(){
        redisTemplate.opsForValue().set("user","张三");
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
