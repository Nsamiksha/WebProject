package com.bridgeit.servlet.services;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import com.bridgeit.servlet.DAO.DAOImplementation;
import com.bridgeit.servlet.DTO.UserPojo;

import com.bridgeit.servlet.model.UserLogin;

public class ServicesImplementation implements IServices {

	Connection con = null;
	Statement st = null;
	boolean i = false;

	@Override
	public boolean loginValidation(UserLogin login) {

		try {
			DAOImplementation dao = new DAOImplementation();
			Connection con = dao.getConnection();
			String username = login.getUsername();
			String password = login.getPassword();

			Statement st = con.createStatement();
			ResultSet rs = null;
			String Query = "select * from members where uname='" + username + "' and pass='" + password + "' ";
			rs = st.executeQuery(Query);
			boolean b = rs.next();
			if (!b) {
				login.setValid(false);
			} else {
				login.setValid(true);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (st != null) {
				try {
//					st.close();
				} catch (Exception e) {
				}
				st = null;
			}

			if (con != null) {
				try {
//					con.close();
				} catch (Exception e) {
				}

				con = null;
			}
		}

		return i;

	}

	@Override
	public boolean checkEmail(String email) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			DAOImplementation connection = new DAOImplementation();
			con = connection.getConnection();

			ps = con.prepareStatement("select * from members where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {

				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				send("samikshapnannaware1995@gmail.com", "*******", email, "link",
						"http://localhost:8080/LoginANDRegistration/SetPassword.jsp");
				rs.close();
				ps.close();
//				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override

	public int addUsers(UserPojo user) {
		int i = 0;

		try {
			DAOImplementation dao = new DAOImplementation();
			Connection con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into members(first_name,last_name,email,uname,pass,regdate) values(?,?,?,?,?,?)");
			LocalDate myObj = LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			String formattedDate = myObj.format(myFormatObj);

			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6, formattedDate);

			i = ps.executeUpdate();
//			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return i;
	}

	@Override
	public void send(String from, String password, String to, String sub, String msg) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int setPassword(UserPojo user) {
		DAOImplementation dao = new DAOImplementation();
		Connection con = dao.getConnection();

		String query = "select * from members where email=?";

		String query1 = "update members set pass=? where email=?";

		ResultSet rs = null;
		int k = 0;
		try {

			String email = user.getEmail();
			String password = user.getPassword();

			PreparedStatement ps1 = con.prepareStatement(query);
			PreparedStatement ps = con.prepareStatement(query1);

			ps1.setString(1, email);

			System.out.println("pass" + password);
			ps.setString(1, password);
			ps.setString(2, email);
			rs = ps1.executeQuery();

//					System.out.println("result : "+rs);
			if (rs.next()) {
				k = ps.executeUpdate();
				System.out.println("password update");

			}

		} catch (Exception e) {
			System.out.println("password updation failed");
			e.printStackTrace();

		}

		return k;

	}

}
