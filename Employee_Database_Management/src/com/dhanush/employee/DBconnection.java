package com.dhanush.employee;

import java.sql.Connection;

import java.sql.DriverManager;

public class DBconnection {

	static Connection con;
	public static Connection createDbconnection()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/employeedb";
		String username="root";
		String password="dhanush@82961";
		con=DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return con;
		
	}

}
