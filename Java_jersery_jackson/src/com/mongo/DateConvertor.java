package com.mongo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateConvertor {
	
	
	public Date convert(String d)
	{
		
	Date date=null;
	try {
		if (d.equalsIgnoreCase(""))
		{
		}
		else
		{
			date = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(d);

		}
		
	} catch (ParseException e) {
		e.printStackTrace();
	}
	System.out.println(date);
	return date;
	
	}

}
