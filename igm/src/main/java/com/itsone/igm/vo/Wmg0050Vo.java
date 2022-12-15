package com.itsone.igm.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wmg0050Vo implements Serializable {
	private static final long serialVersionUID = -6314731453275120129L;
	
	private String cgDiv;
	private String coDiv;
	private String coName;
	
	private String pinClrF;
	private String pinClrS;
	private String pinClrT;

	private String debugYn;
	private String realGpsYn;
	private double rgGeoY;
	private double rgGeoX;
	
	private String useYn;
	
	@JsonIgnore
	private Date updateDatetime;
	private String updDatetime;
	
	List<Wmg0100Vo> courData;
}