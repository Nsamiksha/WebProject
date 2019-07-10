package com.bridgeit.servlet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOImplementation implements IDAO {
	static Connection con;
    static String url;
	
    
    @Override
	public Connection getConnection() {

	      
	            
	    
	        
	         try
	         {
	            String url = "jdbc:mysql://localhost:3306/LOGIN"; 
	            

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            try
	            {            	
	               con = DriverManager.getConnection(url,"root","1234"); 
	                								
	            
	                 
	            }
	            
	            catch (SQLException ex)
	            {
	               ex.printStackTrace();
	            }
	         }

	         catch(ClassNotFoundException e)
	         {
	            System.out.println(e);
	         }

	      return con;
	
	   
		
	}

}
