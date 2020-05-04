package com.hardy.assignements.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	
	public static void main(String []args) {

		String jdbcurl = "jdbc:mysql://localhost:3306/employee_tracker?useSSL=false&serverTimezone=UTC";
		String user = "employee";
		String pass = "employee";
		
		try {
			
			System.out.println("Connecting to db "+jdbcurl);
			Connection myConnection = DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("Connection successful");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
