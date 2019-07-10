package com.bridgeit.servlet.services;

import java.sql.SQLException;

import com.bridgeit.servlet.DTO.UserPojo;
import com.bridgeit.servlet.model.UserLogin;

public interface IServices {

	public void send(String from, String password, String to, String sub, String msg);

	int addUsers(UserPojo user) throws SQLException;

	boolean loginValidation(UserLogin login);

	int setPassword(UserPojo user);
	
	public boolean checkEmail(String email);
}
