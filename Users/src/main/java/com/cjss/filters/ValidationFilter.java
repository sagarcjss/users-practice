package com.cjss.filters;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class ValidationFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(ValidationFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("message from Validation Filter....");
        chain.doFilter(request, response);
    }
}
