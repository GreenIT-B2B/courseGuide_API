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
public class Wmg0201Vo implements Serializable {
	private static final long serialVersionUID = -5327938343928120129L;
	
	private String cgDiv;
	private String coDiv;
	private String crsCd;
	private Integer holeNo;
	
	private Integer teeSeq;
	private String teeClr;
	private String teeNm;
	private String teeCode;
	private String teeNmSec;
	
	private Double teeGeoY;
	private Double teeGeoX;	
	
	private String useYn;

	@JsonIgnore
	private Date updateDatetime;
	private String updDatetime;
}