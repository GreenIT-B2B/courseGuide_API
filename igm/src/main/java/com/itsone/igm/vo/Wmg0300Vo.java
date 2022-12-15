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
public class Wmg0300Vo implements Serializable {
	private static final long serialVersionUID = -3727132943925922123L;
	
	private String mbName;
	private Integer mbSeq;
	private String mbOs;
	private double mbHalfWidth;
	private double mbHalfHeight;
	private double mbBaseDistWidth;
	private double mbBaseDistHeight;
	private double mbBaseZoom;
	private String mbImgUrl;
	
	private String useYn;

	@JsonIgnore
	private Date updateDatetime;
	private String updDatetime;
}
