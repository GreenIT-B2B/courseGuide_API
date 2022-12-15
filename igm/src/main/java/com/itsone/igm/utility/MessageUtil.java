package com.itsone.igm.utility;

import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;

public class MessageUtil {

	private static MessageSourceAccessor messageSourceAccessor;
	public static void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
		MessageUtil.messageSourceAccessor = messageSourceAccessor;
	}

	public static String getValue(String key) {
		return messageSourceAccessor.getMessage(key, Locale.KOREAN);
	}
	
	public static String getValue(String key, String defalutValue) {
		return messageSourceAccessor.getMessage(key, defalutValue, Locale.KOREAN);
	}	
	
	public static int getIntValue(String key , int defaultValue) {
		return Integer.parseInt(getValue(key, "0"));
	}
}