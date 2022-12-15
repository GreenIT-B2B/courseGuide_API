package com.itsone.igm.data.json_item;

import java.io.Serializable;
import java.util.List;

import com.itsone.igm.vo.Wmg0050Vo;
import com.itsone.igm.vo.Wmg0100Vo;
import com.itsone.igm.vo.Wmg0200Vo;
import com.itsone.igm.vo.Wmg0203Vo;
import com.itsone.igm.vo.Wmg0300Vo;
import com.itsone.igm.vo.WmgAdminActVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WmgGiItem implements Serializable {
	private static final long serialVersionUID = -7962251139791464191L;
	
	private String success;
	
	WmgAdminActVo wmgAdmActData;
	Wmg0050Vo wmgCompInfo;
	
	List<Wmg0100Vo> wmgCourInfoData;
	List<Wmg0200Vo> wmgHoleInfoData;
	
	List<Wmg0050Vo> wmgCompInfoData;
	List<Wmg0300Vo> mobileInfoData;
	
	List<Wmg0203Vo> wmgAreaInfoData;
}