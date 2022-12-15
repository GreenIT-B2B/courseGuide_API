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
public class Wmg0202Vo implements Serializable {
	private static final long serialVersionUID = -6127932343928920123L;
	
	private String cgDiv;
	private String coDiv;
	private String crsCd;
	private Integer holeNo;
	
	private Integer dotGp;
	private Integer dotSeq;
	
	private Double dotGeoY;
	private Double dotGeoX;	
	
	private String useYn;

	@JsonIgnore
	private Date updateDatetime;
	private String updDatetime;
}