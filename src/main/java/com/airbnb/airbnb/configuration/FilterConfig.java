package com.airbnb.airbnb.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class FilterConfig {

    @Bean
    public OncePerRequestFilter myFilter() {
        return new WebFilter();
    }

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> jwtFilter() {
        FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(myFilter());
        registrationBean.addUrlPatterns("/guestApi/*");
        return registrationBean;
    }
}