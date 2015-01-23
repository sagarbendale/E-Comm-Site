package com.database;

import java.sql.*;

public class ConnectDB {
	static Connection conn = null;

	public static Connection connect() {
		final String DB_URL = "jdbc:mysql://localhost/eCommDB";

		final String USER = "root";
		final String PASS = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}