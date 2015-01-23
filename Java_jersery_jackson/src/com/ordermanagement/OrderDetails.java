package com.ordermanagement;

import java.sql.Date;

public class OrderDetails {

	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	private String orderid;
	private String productid;
	private java.sql.Date pdate;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public java.sql.Date getPdate() {
		return pdate;
	}
	public void setPdate(java.sql.Date pdate) {
		this.pdate = pdate;
	}
	
	public OrderDetails(String orderid, String productid, Date pdate,
			String status) {
		super();
		this.orderid = orderid;
		this.productid = productid;
		this.pdate = pdate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderid=" + orderid + ", productid=" + productid
				+ ", pdate=" + pdate + "]";
	}

	
}
