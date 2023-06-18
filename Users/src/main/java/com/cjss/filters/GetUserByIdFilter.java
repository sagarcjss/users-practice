package com.cjss.filters;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class GetUserByIdFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(GetUserByIdFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("message from GetUserById Filter");
        chain.doFilter(request, response);
    }
}
