package com.itsone.igm.contr.err;

public class ResponseType {
	public static final String SUCCESS					= "1";
	public static final String FAIL						= "0";
	
	public static final String ERR_000					= "000";
	public static final String WR_FAIL					= "success=0";

	// 공통
	public static final String WR_ERR_GEN_NOR			= "errCd=000";
	public static final String WR_ERR_COMMON_UPD_FAIL	= "errCd=550";
	
	// 파라미터
	public static final String WR_ERR_NOT_ENOUGH_PARAM	= "errCd=300"; // no 파라미터
	
	public static final Integer JSON_PARSING_ERR		= 0;
	
	// 로그인 관련
	public static final String WR_ERR_NO_ADM_INFO		= "errCd=500";
	
	public static final String WR_COMMON_UPDATE_FAIL	= "errCd=600";
}