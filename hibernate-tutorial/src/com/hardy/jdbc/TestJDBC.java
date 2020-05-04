package com.hardy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJDBC {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			
			System.out.println("Connecting to db "+jdbcurl);
			Connection myConnection = DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("Connection successful");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
