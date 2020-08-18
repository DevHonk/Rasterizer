package fr.noristus.rasterizer.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil 
{
	private static Calendar calendar = new GregorianCalendar();
	
	public static String hmsDateString()
	{
		String currentHour = to24(calendar.get(Calendar.HOUR_OF_DAY));
		String currentMinute = to24(calendar.get(Calendar.MINUTE));
		String currentSecond = to24(calendar.get(Calendar.SECOND));
		
		return String.format("%s:%s:%s", currentHour, currentMinute, currentSecond);
	}
	
	private static String to24(int value)
	{
		return "" + (value > 9 ? value : "0" + value);
	}
}
