package com.lr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication (scanBasePackages = "com.lr")
@MapperScan ("com.lr.mapper")
@EnableCaching
public class app{
/*
    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
        bean.addUrlMappings("*.action");
        return bean;
    }
*/

//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setDefaultExpiration(60);
//        Map<String, Long> expiresMap = new HashMap<>();
//        expiresMap.put("product", 5L);
//        cacheManager.setExpires(expiresMap);
//        return cacheManager;
//    }

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }

}
