package com.itsone.igm.data.json_item;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GeoPointItem implements Serializable {
	private static final long serialVersionUID = -8964154639761292123L;

	private double lon;
    private double lat;
    private double height;
}