package com.itsone.igm.data.json_item;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WmgUpdCompData implements Serializable {
	private static final long serialVersionUID = -4869287189093264891L;

	List<WmgUpdCompItem> compData;
}