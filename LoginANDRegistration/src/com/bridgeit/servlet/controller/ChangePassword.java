package com.bridgeit.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgeit.servlet.DTO.UserPojo;
import com.bridgeit.servlet.services.ServicesImplementation;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
//		String password = request.getParameter("password");
		String confpassword = request.getParameter("password");

		
			UserPojo user = new UserPojo();
			user.setEmail(email);
			user.setPassword(confpassword);
			ServicesImplementation service = new ServicesImplementation();
			int k = service.setPassword(user);
			if (k != 0) {
				System.out.println("Password Reset Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("SuccessfullyReset.jsp");
				rd.include(request, response);
				
			} else {
				response.sendRedirect("SetPassword.jsp");
			}

		}

	}


