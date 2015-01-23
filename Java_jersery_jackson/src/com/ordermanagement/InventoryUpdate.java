package com.ordermanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.database.ConnectDB;

public class InventoryUpdate {
	Connection con = ConnectDB.connect();
	Statement stmt=null;
	String sql="";

	public void increamentCount(double productid)
	{
		try 
		{
			stmt = con.createStatement();
			sql="UPDATE `inventory` SET `quantity` = `quantity` + 1 WHERE  `productid` = "+productid;
			stmt.executeUpdate(sql);
			System.out.println("Quantity increameneted for product : "+ productid);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void decreamentCount(double productid)
	{
		try 
		{
			stmt = con.createStatement();
			sql="UPDATE `inventory` SET `quantity` = `quantity` - 1 WHERE  `productid` = "+productid;
			stmt.executeUpdate(sql);
			System.out.println("Quantity decreamented for product : "+ productid);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
