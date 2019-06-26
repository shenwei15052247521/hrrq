package com.lanswon.auth.filters;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 *
 */
@Slf4j
public class SecurityFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("SecurityFilter初始化完成...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

	}

	@Override
	public void destroy() {
		log.info("SecurityFilter已销毁...");
	}
}
