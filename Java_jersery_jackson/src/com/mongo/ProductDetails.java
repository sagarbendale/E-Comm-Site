package com.mongo;

import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.database.ConnectMongo;
import com.mongodb.DB;

public class ProductDetails {
	
	Product product=null;

	public Product getProduct(double product_id) {
		
		try {
			int i=(int)product_id;
			String productid = String.valueOf(i);
			System.out.println(productid);
			DB db=ConnectMongo.connect();
			Jongo jongo = new Jongo(db);
			MongoCollection products = jongo.getCollection("products");
			
			product= products.findOne("{ product_id : \""+productid+"\"}").as(Product.class);
			System.out.println("products.findOne(\"{ product_id : "+productid+"}\")");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return product;
	}
	

}
