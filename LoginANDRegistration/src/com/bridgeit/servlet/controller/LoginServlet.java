package com.bridgeit.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.servlet.model.UserLogin;
import com.bridgeit.servlet.services.ServicesImplementation;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserLogin login = new UserLogin();

		String username =request.getParameter("uname");
		String password = request.getParameter("pass");
		
		if( username==null||password==null) {
			System.out.println("please enter valid information");
		}
		else {

			login.setUsername(username);
			login.setPassword(password);
		ServicesImplementation service = new ServicesImplementation();

	service.loginValidation(login);

		if (login.isValid())
	     {
		        
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUser",login); 
	          response.sendRedirect("LoggedIn.jsp");  		
	     }
		        
	     else 
	          response.sendRedirect("Login.jsp"); 
	} 
			
		}

	}

