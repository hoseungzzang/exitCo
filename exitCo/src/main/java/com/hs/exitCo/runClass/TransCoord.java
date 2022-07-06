package com.hs.exitCo.runClass;

import java.awt.geom.Point2D;


import com.jhlabs.map.proj.Projection;
import com.jhlabs.map.proj.ProjectionFactory;
public class TransCoord {
	public String[] transform2(String x, String y) {

		String[] proj4 = new String[] {
		        "+proj=tmerc",
		        "+lat_0=38N",
		        "+lon_0=127.00289027777777777776E",
		        "+ellps=bessel",
		        "+units=m",
		        "+x_0=200000",
		        "+y_0=500000",
		        "+k=1.0"
		};
		Projection proj = ProjectionFactory.fromPROJ4Specification(proj4);

		Point2D.Double srcProjec= new Point2D.Double(Double.parseDouble(x),Double.parseDouble(y));
		Point2D.Double dstProject = proj.inverseTransform(srcProjec, new Point2D.Double());
		String [] arr = new String[2];
		arr[0] = Double.toString(dstProject.x);
		arr[1] = Double.toString(dstProject.y);
	    return arr;
	  }
}
