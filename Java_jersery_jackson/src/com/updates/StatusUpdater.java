package com.updates;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class StatusUpdater implements ServletContextListener {

	private Thread checkstatus = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		checkstatus=new Thread(new StatusChange());
		checkstatus.start();
	}

}
