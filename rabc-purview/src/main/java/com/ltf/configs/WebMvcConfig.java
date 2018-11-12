package com.ltf.configs;


import com.ltf.commons.DateConverterConfig;
import com.ltf.interceptors.ErrorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@EnableWebMvc
@EnableAsync
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean   //把我们的拦截器注入为bean
    public HandlerInterceptor getMyInterceptor(){
        return new ErrorInterceptor();
    }



    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(new DateConverterConfig());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
    }

   @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/resources/").addResourceLocations("classpath:/public/");
    }

/*     @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
       viewControllerRegistry.addViewController("/error").setViewName("error.html");
       viewControllerRegistry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
        pathMatchConfigurer.setUseSuffixPatternMatch(false);
    }*/

}
