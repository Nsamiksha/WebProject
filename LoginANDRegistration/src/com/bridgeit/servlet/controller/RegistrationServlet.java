package com.bridgeit.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.servlet.DTO.UserPojo;
import com.bridgeit.servlet.services.ServicesImplementation;

public class RegistrationServlet extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserPojo user = new UserPojo();

		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		ServicesImplementation service = new ServicesImplementation();
		int i = service.addUsers(user);
		if (i > 0) {
			System.out.println("Succesfully Registered ");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
//			response.sendRedirect("Login.jsp");
		}

	}
}
