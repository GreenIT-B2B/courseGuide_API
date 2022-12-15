package com.itsone.igm.data.json_item;

import java.io.Serializable;
import java.util.List;

import com.itsone.igm.vo.Wmg0050Vo;
import com.itsone.igm.vo.Wmg0100Vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WmgUpdCompItem implements Serializable {
	private static final long serialVersionUID = -7162281189793264891L;

	
	Wmg0050Vo compInfo;
	List<Wmg0100Vo> courData;
}