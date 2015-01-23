package com.ordermanagement;

import java.util.Date;

public class DateCheck {
	boolean validated;

	public boolean check(Date sdate, Date edate)
	{
		validated=false;
		Date current=new Date();
		if(edate!=null)
		{
			if(current.after(sdate) && current.before(edate)) 
			{
				validated=true;
			}
		}
		if(current.after(sdate) && edate==null) 
		{
			validated=true;
		}

		System.out.println("Date Check Validation : "+validated);
		return validated;
	}

	public boolean cancelCheck(java.sql.Date sqlDate)
	{
		validated=false;
		Date date=sqlDate;
		Date current=new Date();
		if(current.after(date))
		{
			long diff = current.getTime() - date.getTime();
			System.out.println("Date Check: difference in time: "+diff);
			if(diff<(3*86400000))
				validated=true;
		}
		System.out.println("Date Check Validation : "+validated);

		return validated;
	}



}
