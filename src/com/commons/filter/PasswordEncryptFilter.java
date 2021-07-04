package com.commons.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class PasswordEncryptFilter
 */

//필터링의 기준은 주소매핑만 하는 것이 아니라 서블릿 이름으로도 가능
@WebFilter(servletNames = {
		 "signupend"  , "loginservlet" ,"memberupdateservlet" ,"updatePasswordEnd"
})
public class PasswordEncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PasswordEncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
        PasswordEncryptWrapper pew = new PasswordEncryptWrapper((HttpServletRequest)request);
		// pass the request along the filter chain
		chain.doFilter(pew, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
