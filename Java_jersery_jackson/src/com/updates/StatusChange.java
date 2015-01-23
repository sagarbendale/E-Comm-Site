package com.updates;

import java.sql.Connection;
import java.sql.Statement;

import com.database.ConnectDB;

public class StatusChange implements Runnable {

	public void run()
	{
	while(true)
		{
			Connection con = ConnectDB.connect();

			String sql=  " update `order` SET status='Processed' where status = 'Processing' and  (( TO_DAYS(NOW()) - TO_DAYS(date)  ) >= 3)";
		try {
			Statement stmt = con.createStatement();

			stmt.execute(sql);
			System.out.println("Status Updated");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		}
	}
}
