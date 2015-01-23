package com.authorize;

import com.database.ConnectDB;
import com.sha1.Sha1;

import java.sql.*;

public class Login {
	public boolean checkDetails(String uid, String pass)

	{
		String Pass = null;
		boolean authorized = false;
		try {
			Connection con = ConnectDB.connect();

			Statement stmt = con.createStatement();
			String sql = "SELECT `pass` FROM userdetails WHERE uname=\'" + uid	+ "\'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pass = rs.getString("pass");
			}
			pass = Sha1.SHA1(pass);

			if (Pass != null) {
				if (Pass.equals(pass)) {
					authorized = true;
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return authorized;

	}

}
