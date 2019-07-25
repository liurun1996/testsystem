
package com.lr.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;

@Component
public class ViewConfig  implements WebMvcConfigurer{

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



}

