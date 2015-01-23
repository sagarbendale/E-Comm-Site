package com.database;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ConnectMongo {
	static DB db=null;
	public static DB connect() throws UnknownHostException
	{
	db = (new MongoClient( "localhost" , 27017 )).getDB("ecomm-db");
	System.out.println("connecting to mongodb");
	return db;
	}

}
