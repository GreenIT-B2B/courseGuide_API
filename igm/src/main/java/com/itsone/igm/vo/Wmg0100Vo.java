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
public class Wmg0100Vo implements Serializable {
	private static final long serialVersionUID = -4187931453275120129L;
	
	private String cgDiv;
	private String coDiv;
	private String crsCd;
	private Integer crsSeq;
	private String crsName;
	
	private Double tlLaY;
	private Double tlLoX;
	private Double trLaY;
	private Double trLoX;
	private Double blLaY;
	private Double blLoX;
	private Double brLaY;
	private Double brLoX;
	
	private Double centerGeoY;
	private Double centerGeoX;
	private Double rotate;
	private Integer zoomW;
	private Double zoomN;
	
	private String useYn;

	@JsonIgnore
	private Date updateDatetime;
	private String updDatetime;
}