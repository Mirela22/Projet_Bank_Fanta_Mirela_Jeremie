package com.ib.bankFilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;


@WebFilter("/CookieFilter")
public class CookieFilter implements Filter {
	
	public static final String PUBLIC_PATH ="/login.jsp" ;
	public static final String COOKIE = "cookie";
   
    public CookieFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Cookie[] cookies=request.getCookies();
        if (cookies != null){
            for (Cookie oneCookie:cookies){
                if (oneCookie.getName().equals("Acces_token")){
                	
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/Accueilbis.jsp").forward(request, response);
        

	}
		


	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
