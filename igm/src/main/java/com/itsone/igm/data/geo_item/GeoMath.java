package com.itsone.igm.data.geo_item;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeoMath {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(GeoMath.class);
	
	public static double dist(double lat1, double lon1, double lat2, double lon2, String unit) {
		
	    double theta = lon1 - lon2;
	    double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
	            + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	    dist = Math.acos(dist);
	    dist = rad2deg(dist);
	    dist = dist * 60 * 1.1515;
	    
	    if (unit.equalsIgnoreCase("k")) {
	        dist = dist * 1.609344;
	    } else if (unit.equalsIgnoreCase("m")) {
	        dist = (dist * 1.609344) * 1000;
	    } else if (unit.equalsIgnoreCase("y")) {
	        dist = (dist * 1.609344) * 1000 * 1.094;
	    } else if (unit.equalsIgnoreCase("n")) {
	        dist = dist * 0.8684;
	    }

	    return (dist);
	}
	
	public static double deg2rad(double deg) {
	    return (deg * Math.PI / 180.0);
	}

	public static double rad2deg(double rad) {
	    return (rad * 180.0 / Math.PI);
	}
	
	public static GeoPoint getCentWeight(List<GeoPoint> polygon) {
		
		  double area = 0, cx = 0, cy = 0;

		  for(int i = 0; i < polygon.size(); i++){
		    int j = (i + 1) % polygon.size();

		    GeoPoint pt1 = polygon.get(i);
		    GeoPoint pt2 = polygon.get(j);

		    double x1 = pt1.getX();
		    double x2 = pt2.getX();
		    double y1 = pt1.getY();
		    double y2 = pt2.getY();

		    area += x1 * y2;
		    area -= y1 * x2;

		    cx += ((x1 + x2) * ((x1 * y2) - (x2 * y1)));
		    cy += ((y1 + y2) * ((x1 * y2) - (x2 * y1)));
		  }

		  area /= 2;
		  area = Math.abs(area);

		  cx = cx / (6.0 * area);
		  cy = cy / (6.0 * area);

		  return new GeoPoint(Math.abs(cx), Math.abs(cy));
		}
	
	public static GeoPoint getCentRect(List<GeoPoint> polygon) {
		
		double minX = 0.0, minY = 0.0, maxX = 0.0, maxY = 0.0;
		for (int i = 0; i < 4; i++) {

			if (minX == 0 || minX > polygon.get(i).getX()) minX = polygon.get(i).getX();
			if (maxX == 0 || maxX < polygon.get(i).getX()) maxX = polygon.get(i).getX();
			if (minY == 0 || minY > polygon.get(i).getY()) minY = polygon.get(i).getY();
			if (maxY == 0 || maxY < polygon.get(i).getY()) maxY = polygon.get(i).getY();
		
		}
		
		return new GeoPoint(minX + ((maxX - minX) / 2), minY + ((maxY - minY) / 2));
	}
	
	public static double getAngle(GeoPoint start, GeoPoint end) {
		
        double dy = end.getY() - start.getY();
        double dx = end.getX() - start.getX();
        double angle = Math.atan(dy / dx) * (180.0 / Math.PI);

        if (dx < 0.0) {
            angle += 180.0;
        } else {
            if (dy<0.0) angle += 360.0;
        }
        
        return angle;
    }
	
	public static List<GeoPoint> getRecToRaRect(double degree, List<GeoPoint> geos, GeoPoint cent) {
		
		List<GeoPoint> tGeos = getRecRot(degree, geos, cent);
		
		if (tGeos.get(0).getX() >= tGeos.get(3).getX()) tGeos.get(0).setX(tGeos.get(3).getX()); else tGeos.get(3).setX(tGeos.get(0).getX());
		if (tGeos.get(0).getY() >= tGeos.get(1).getY()) tGeos.get(1).setY(tGeos.get(0).getY()); else tGeos.get(0).setY(tGeos.get(1).getY());
		if (tGeos.get(1).getX() >= tGeos.get(2).getX()) tGeos.get(2).setX(tGeos.get(1).getX()); else tGeos.get(1).setX(tGeos.get(2).getX());
		if (tGeos.get(3).getY() >= tGeos.get(2).getY()) tGeos.get(3).setY(tGeos.get(2).getY()); else tGeos.get(2).setY(tGeos.get(3).getY());
		
        return getRecRot(-degree, tGeos, cent);
    }
	
	public static List<GeoPoint> getRecRot(double degree, List<GeoPoint> geos, GeoPoint cent) {
		
		List<GeoPoint> retGeos = new ArrayList<>();
		
		double cosRad = Math.cos(Math.toRadians(degree));
		double sinRad = Math.sin(Math.toRadians(degree));
		
		for (int i = 0; i < geos.size(); i++) {
			double x = cent.getX() + (cosRad * (geos.get(i).getX() - cent.getX()) - sinRad * (geos.get(i).getY() - cent.getY()) / Math.abs(Math.cos(Math.toRadians(cent.getY()))));
			double y = cent.getY() + (sinRad * (geos.get(i).getX() - cent.getX()) * Math.abs(Math.cos(Math.toRadians(cent.getY()))) + cosRad * (geos.get(i).getY() - cent.getY()));
			
			retGeos.add(new GeoPoint(x, y));
		}
		
		return retGeos;
	}
}