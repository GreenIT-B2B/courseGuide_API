package com.itsone.igm.helper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelper {
	private final String TAG = this.getClass().getSimpleName();

	private static volatile DataHelper instance;
	private DataHelper() {}
	public static DataHelper inst() {
		if (instance == null) { instance = new DataHelper(); }
		return instance;
	}
	
	public SimpleDateFormat trsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public SimpleDateFormat trsFormatMid = new SimpleDateFormat("yyyyMMddHHmmss");
	
	
	public String millToDateTimeString(long mills) {
		String date = "";

		if (mills > 0) {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			date = formatter.format(new Timestamp(mills));
		}

		return date;
	}
	
	public Date millToDateTime(long mills) {
		if (mills > 0) return new Timestamp(mills);
		return null;
	}
}
