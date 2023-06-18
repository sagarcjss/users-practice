package com.cjss.configuration;

import com.cjss.filters.GetUserByIdFilter;
import com.cjss.filters.ValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfigurations {

    @Bean
    public FilterRegistrationBean<ValidationFilter> validation1(){
        FilterRegistrationBean<ValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ValidationFilter());
        registrationBean.addUrlPatterns("/user-save");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<GetUserByIdFilter> getUserById(){
        FilterRegistrationBean<GetUserByIdFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new GetUserByIdFilter());
        registrationBean.addUrlPatterns("/get/{id}");
        return registrationBean;
    }
}
