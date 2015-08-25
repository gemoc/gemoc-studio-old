/*
 * Created on Apr 30, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.data;



import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;


/**
 * @author luc.hogie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FigureUtilities extends Figure
{
	public static Point getClosestPoint(final Point referencePoint, final Figure figure)
	{
		if (figure == null)
			throw new NullPointerException();
			
		Point closestPoint = null;
		double distance = Integer.MAX_VALUE;

		for (Point p : figure.retrieveAllPoints())
		{
			double d = p.getDistanceTo(referencePoint);
				
			if (d < distance)
			{
				distance = d;
				closestPoint = p;
			}
		}

		return closestPoint;
	}

}
