package com.ordermanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.database.ConnectDB;

public class UserOrders {

	public ArrayList<OrderDetails> getAllOrders(String username)
	{
		ArrayList<OrderDetails> orderid=new ArrayList<OrderDetails>();
		ResultSet rs=null;
		Connection con = ConnectDB.connect();
		try 
		{
			int userid=0;
			Statement stmt = con.createStatement();
			String sql = "SELECT `userid` FROM `userdetails` WHERE uname= \'" + username+"\'";
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				userid=rs.getInt("userid");
			}
			sql = "SELECT * FROM `order` WHERE userid=" + userid;
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				orderid.add((new OrderDetails(rs.getString("orderid"),rs.getString("productid"),rs.getDate("date"),rs.getString("status"))));
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return orderid;
	}

}
