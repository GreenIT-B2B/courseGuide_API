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
public class Wmg0200Vo implements Serializable {
	private static final long serialVersionUID = -7197936343228120129L;
	
	private String cgDiv;
	private String coDiv;
	private String crsCd;
	private String crsName;
	private Integer holeNo;
	private String holeNoNm;
	private Integer par;
	private Integer handi;
	
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
	
	private Double pinGeoY;
	private Double pinGeoX;
	
	private Double ipZGeoY;
	private Double ipZGeoX;
	
	private Double ipFGeoY;
	private Double ipFGeoX;
	
	private Double ipSGeoY;
	private Double ipSGeoX;
	
	private Double ipTGeoY;
	private Double ipTGeoX;	
	
	private String holeExpl;
	
	private Integer pinDist;
	private Integer backDist;
	private Integer frontDist;
	
	private String useYn;
	
	@JsonIgnore
	private Date updateDatetime;
	private String updDatetime;
	
	List<Wmg0201Vo> wmg201s;
	List<Wmg0202Vo> wmg202s;
	List<Wmg0203Vo> wmg203s;
}