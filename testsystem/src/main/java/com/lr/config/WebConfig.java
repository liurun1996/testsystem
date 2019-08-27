
package com.lr.config;


import com.lr.handler.AdminInterceptor;
import com.lr.handler.userHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

@Component
public class WebConfig implements WebMvcConfigurer{
    @Autowired
    private AdminInterceptor adminInterceptor;
    @Autowired
    private userHandler userHandler;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //相当于把static目录设为跟路径，在html中访问可以直接从static下开始
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");


    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:index.action");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login.action");
        registry.addInterceptor(userHandler).addPathPatterns("/user/**").excludePathPatterns("/user/login.action");
    }
}

