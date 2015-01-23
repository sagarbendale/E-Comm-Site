package com.ordermanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.database.ConnectDB;
import com.mongo.DateConvertor;
import com.mongo.Product;
import com.mongo.ProductDetails;
import com.payment.CardDetail;
public class Order {

	private String address1=null;
	private String address2=null;
	private String city=null;
	private String state=null;
	private int zip;
	Connection con = ConnectDB.connect();
	int count=0;
	int userid=0;
	ProductDetails pd=new ProductDetails();
	PreparedStatement ps = null;
	Product product=null;
	DateConvertor date=new DateConvertor();
	DateCheck dc=new DateCheck();
	Statement stmt=null;
	String sql="";
	ResultSet rs=null;
	java.sql.Date sqlDate=null;
	InventoryUpdate quantity=new InventoryUpdate();

	public void placeorder(double product_id, String uname,CardDetail c)
	{	
		try 
		{
			product=pd.getProduct(product_id);

			stmt = con.createStatement();
			sql = "SELECT `quantity` FROM `inventory` WHERE productid = " + product_id;
			rs = stmt.executeQuery(sql);
			while (rs.next()) 
			{
				count = rs.getInt("quantity");
			}

			sql = "SELECT `userid` FROM userdetails WHERE uname=\'" + uname	+ "\'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				userid = rs.getInt("userid");
			}
			System.out.println("User Id from Order: "+userid);

			Date sdate=product.getSdate();
			Date edate=product.getEdate();
			String amount=product.getPrice();
			java.util.Date utilDate = new java.util.Date();
			sqlDate = new java.sql.Date(utilDate.getTime());	
			if(dc.check(sdate,edate))
			{
				System.out.println("inside date");
				if(count>0)
				{
					System.out.println("inside count");
					
					sql = "INSERT INTO `order` (userid, productid, amount, date, address1, address2, city, state, zip, status, ccholder, ccno, ccsec, cctype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					ps = con.prepareStatement(sql);
					ps.setInt(1, userid);
					ps.setDouble(2,product_id);
					ps.setString(3, amount);
					ps.setDate(4, sqlDate);
					ps.setString(5, address1);
					ps.setString(6, address2);
					ps.setString(7, city);
					ps.setString(8, state);
					ps.setInt(9, zip);
					ps.setString(10, "Processing");
					ps.setString(11, c.getCcholder());
					ps.setInt(12, c.getCcno());
					ps.setInt(13, c.getCcsec());
					ps.setString(14, c.getCctype());
					
					

					System.out.println(ps);
					ps.execute();
					quantity.decreamentCount(product_id);
					System.out.println("order placed");

				}


			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}


	public void cancelOrder(int orderid)
	{
		double productid=0;
		try 
		{
			stmt = con.createStatement();
			sql = "SELECT `productid`,`date` FROM `order` WHERE orderid = " + orderid;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				productid = rs.getInt("productid");
				sqlDate=rs.getDate("date");
			}
			if(dc.cancelCheck(sqlDate))
			{
				//sql = "DELETE FROM `order` WHERE `orderid` = "+ orderid;
				sql="UPDATE `eCommDB`.`order` SET `status`='Cancelled' WHERE `orderid`= "+ orderid;

				stmt.executeUpdate(sql);
				quantity.increamentCount(productid);
				System.out.println("Order : "+ orderid +" deleted");

			}

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

}
