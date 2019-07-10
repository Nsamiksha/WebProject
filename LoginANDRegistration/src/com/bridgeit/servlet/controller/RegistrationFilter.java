package com.bridgeit.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;




@WebServlet("/registrationServlet")
public class RegistrationFilter implements Filter {

   

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpServletRequest request = (HttpServletRequest) req; 
		String userName = request.getParameter("username");
		
		
		  Pattern userNamePattern = Pattern.compile("[a-z0-9_-]{8}$");
	     

		         
		        Matcher match = userNamePattern.matcher(userName);
		        
		        if(match.matches()){
		        	out.print("success");
		        	chain.doFilter(req, response);
		        }
		        else {
		        	out.print("invalid username");
		        	RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
		        	rd.forward(request, response);
		        }
		       
		
		
		
	}

	 public void destroy() {}  
}
