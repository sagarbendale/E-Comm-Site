package com.authorize;

import com.database.ConnectDB;
import com.sha1.Sha1;

import java.sql.*;

public class SignUp {

	public void createUser(String email, String fname, String lname,
			String uname, String pass) {

		System.out.println("1");
		String sql = null;
		String UserName = null;
		String Email = null;

		try {

			Connection con = ConnectDB.connect();

			Statement stmt = con.createStatement();
			PreparedStatement ps = null;
			sql = "SELECT `uname`,`email` FROM userdetails WHERE uname=\'"
					+ uname + "\'";

			System.out.println("12" + sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UserName = rs.getString("uname");
				Email = rs.getString("email");

			}
			if (UserName != null) {
				System.out.println("User Name Already Exist");
			}
			if (Email != null) {
				System.out.println("Email Id Already Exist");
			} else {
				pass = Sha1.SHA1(pass);
				System.out.println(pass);
				sql = "INSERT INTO userdetails (fname, lname, email, uname, pass) VALUES (?, ?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, email);
				ps.setString(4, uname);
				ps.setString(5, pass);

				ps.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
