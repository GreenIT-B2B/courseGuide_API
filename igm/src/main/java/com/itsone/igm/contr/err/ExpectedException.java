package com.itsone.igm.contr.err;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpectedException extends RuntimeException {
	private static final Logger logger = LoggerFactory.getLogger(ExpectedException.class);
	
	private static final long serialVersionUID = -4354286389516313213L;
	
	public static final ExpectedException FAIL_NO_CODE = new ExpectedException(ResponseType.WR_FAIL);
	public static final ExpectedException FAIL_ERR_GEN_NOR = new ExpectedException(ResponseType.WR_FAIL + "," + ResponseType.WR_ERR_GEN_NOR);
	
	public static final ExpectedException FAIL_ERR_NOT_ENOUGH_PARAM = new ExpectedException(ResponseType.WR_FAIL + "," + ResponseType.WR_ERR_NOT_ENOUGH_PARAM);
	
	public static final ExpectedException FAIL_NO_ADM_INFO = new ExpectedException(ResponseType.WR_FAIL + "," + ResponseType.WR_ERR_NO_ADM_INFO);
	
	public static final ExpectedException FAIL_COMMON_UPDATE_FAIL = new ExpectedException(ResponseType.WR_FAIL + "," + ResponseType.WR_COMMON_UPDATE_FAIL);
	
	
	
	public ExpectedException(String s) {
		super(s);
	}
	
	@Override 
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}
