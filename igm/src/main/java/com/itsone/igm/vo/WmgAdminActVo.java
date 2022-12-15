package com.itsone.igm.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WmgAdminActVo implements Serializable {
	private static final long serialVersionUID = -2147938453275418129L;
	
	private String admCd;
	private String admPw;
	private String admPwValue;
	private Integer admLv;
	private String admName;
	private String admTel;
	
	private String actType;
	private String actCgDiv;
	private String actCoDiv;
	private String actCrsCd;
	private Integer actHoleNo;
	private String actPointType;
	
	private String useYn;

	@JsonIgnore
	private Date updateDatetime;
	private String updDatetime;
}