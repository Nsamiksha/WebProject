package com.bridgeit.servlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.servlet.DAO.DAOImplementation;
import com.bridgeit.servlet.services.ServicesImplementation;

@WebServlet("/MailSend")
public class MailSender extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ServicesImplementation mailer = new ServicesImplementation();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String Email = request.getParameter("email");

		System.out.println(Email);

		boolean check = mailer.checkEmail(Email);
		if (check == true) {
			System.out.println("Email verified");
		} else {
			System.out.println("not verified");
		}
		request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		System.out.println("reg successfully");

	}

	
}
