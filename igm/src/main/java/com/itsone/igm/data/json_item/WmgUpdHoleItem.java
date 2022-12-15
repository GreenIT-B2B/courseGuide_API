package com.itsone.igm.data.json_item;

import java.io.Serializable;
import java.util.List;

import com.itsone.igm.vo.Wmg0200Vo;
import com.itsone.igm.vo.Wmg0201Vo;
import com.itsone.igm.vo.Wmg0202Vo;
import com.itsone.igm.vo.Wmg0203Vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WmgUpdHoleItem implements Serializable {
	private static final long serialVersionUID = -7662213189892261491L;
	
	Wmg0200Vo holeInfo;
	List<Wmg0201Vo> tees;
	List<Wmg0202Vo> dots;
	List<Wmg0203Vo> areas;
}