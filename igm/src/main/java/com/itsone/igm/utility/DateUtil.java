package com.itsone.igm.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static final String DATEFORMAT_DEFAULT = "yyyy.MM.dd";
	public static final String DATETIMEFORMAT_DEFAULT = "yyyy.MM.dd HH:mm:ss.SSS";
	
	public static String getCurrentDate() { return getCurrentDate(null); }
	public static String getCurrentDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(CommonUtil.isEmpty(format) ? DATEFORMAT_DEFAULT : format);
		return dateFormat.format(new Date(System.currentTimeMillis()));
	}	
	
	public static String getCurrentDateTime() { return getCurrentDateTime(null); }
	public static String getCurrentDateTime(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(CommonUtil.isEmpty(format) ? DATETIMEFORMAT_DEFAULT : format);
		return dateFormat.format(new Date(System.currentTimeMillis()));
	}	
	
	public static Date getStringToDate(String strDate) { return getStringToDate(strDate, null); }
	public static Date getStringToDate(String strDate, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(CommonUtil.isEmpty(format) ? DATEFORMAT_DEFAULT : format);
		try {
			return formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}	

	public static Date addDate(Integer interval) { return addDate(interval, new Date()); }
	public static Date addDate(Integer interval, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, interval);
		return cal.getTime();
	}
	
	public static Date addMonth(Integer interval) { return addMonth(interval, new Date()); }
	public static Date addMonth(Integer interval, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, interval);
		return cal.getTime();
	}
	
	public static Integer diffDate(Date date2) { return diffDate(new Date(), date2); }
	public static Integer diffDate(Date date1, Date date2) {
		long diff = date1.getTime() - date2.getTime();
		return Integer.parseInt(Long.toString(diff / (24 * 60 * 60 * 1000)));
	}
}
