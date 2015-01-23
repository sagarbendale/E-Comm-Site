package com.mongo;

import java.util.Date;

public class Product {
	private Double id;
	private String type;
	private String brand;
	private String diagonal_length;
	private String HD;
	private String length;
	private String width;
	private String height;
	private String price;
	private String description;
	private String warranty_period;
	private String img;
	private String quantity;
	private Date sdate;
	private Date edate;
	private String frequncy;
	private String lan_ports;
	private String megapixel;
	private String opticalzoom="";
	private String battery="";
	private String product_id="";

	public Double getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getBrand() {
		return brand;
	}
	public String getDiagonal_length() {
		return diagonal_length;
	}
	public String getHD() {
		return HD;
	}
	public String getLength() {
		return length;
	}
	public String getWidth() {
		return width;
	}
	public String getHeight() {
		return height;
	}
	public String getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public String getWarranty_period() {
		return warranty_period;
	}
	public String getImg() {
		return "http://localhost:8080/"+img;
	}
	public String getQuantity() {
		return quantity;
	}
	public Date getSdate() {
		return sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public String getFrequncy() {
		return frequncy;
	}
	public String getLan_ports() {
		return lan_ports;
	}
	public String getMegapixel() {
		return megapixel;
	}
	public String getOpticalzoom() {
		return opticalzoom;
	}
	public String getBattery() {
		return battery;
	}
	public String getProduct_id() {
		return product_id;
	}



}
