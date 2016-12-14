package com.kaishengit.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;

/**
 * Servlet Filter implementation class ValidateFinal
 */
public class ValidateFinal extends AbstractFilter{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

		String uri = httpServletRequest.getRequestURI()	;

		if("/".equals(uri) || "/index.jsp".equals(uri) || "/login".equals(uri) || uri.startsWith("/static/")){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}else{
			HttpSession session = httpServletRequest.getSession();
			Admin admin = (Admin) session.getAttribute("admin");

			if(admin != null){
				filterChain.doFilter(httpServletRequest, httpServletResponse);
			}else{
				httpServletResponse.sendRedirect("/login?callback="+uri);
			}
		}
	}

}
