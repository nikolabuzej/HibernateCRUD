package com.niki030.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJDBC {
	public static void main(String[] args) {
		String jdbcurl="jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useSSL=false&serverTimeZone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			System.out.println("Connecting to database");
			Connection myCon=DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("connection successful");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
