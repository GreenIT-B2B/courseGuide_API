package com.itsone.igm.data.geo_item;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GeoPoint {
	private double x; // lon
	private double y; // lat
}