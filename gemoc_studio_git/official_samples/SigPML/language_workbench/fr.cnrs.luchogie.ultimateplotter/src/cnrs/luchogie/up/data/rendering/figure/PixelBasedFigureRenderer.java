/*
 * Created on Dec 14, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.data.rendering.figure;



import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Space;


/**
 * @author luc.hogie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PixelBasedFigureRenderer extends FigureRenderer
{
	private int xstep = 1, ystep = 1;

	/* (non-Javadoc)
	 * @see org.lucci.up.data.rendering.DataElementRenderer#drawImpl(org.lucci.up.data.DataElement, org.lucci.up.system.Space)
	 */
	protected void drawImpl(DataElement object, Space space)
	{
		Figure figure = (Figure) object;
		List points = new Vector();
		
		for (int i = 0; i < figure.getPointCount(); ++i)
		{
			Point point = figure.getPointAt(i);
			int x = space.getXDimension().convertToGraphicsCoordonateSystem(point.getX());
			int y = space.getYDimension().convertToGraphicsCoordonateSystem(point.getY());
			points.add(new int[] {x, y});
		}
		
		Dimension dimension = space.getFigureGraphics().getClip().getBounds().getSize();
		
		for (int x = 0; x < dimension.width; x += xstep)
		{
			for (int y = 0; y < dimension.height; y += ystep)
			{
				double temperature = getTemperature(x, y, points);
				space.getFigureGraphics().setColor( getColor(temperature) );
				space.getFigureGraphics().fillRect(x, y, xstep, ystep);
			}
		}
	}

	protected Color getColor(double temperature)
	{
		Color color = getColor();
		Color newColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) (255 * temperature));
		return newColor;
	}


	protected double getTemperature(int x, int y, List points)
	{
		double distance = getDistance(x, y, points);
		double f = 1f / (2f + (float) Math.cos(distance/20f));
		return f; 
	}
	
	private int getDistance(int x, int y, List points)
	{
		int minDistance = 1000;
		
		for (int i = 0; i < points.size(); ++i)
		{
			int[] ps = (int[]) points.get(i);
			int dx = Math.abs(x - ps[0]);
			int dy = Math.abs(y - ps[1]);
			int d = (int) Math.sqrt(dx * dx + dy * dy);

			if ( d < minDistance )
				minDistance = d;
		}

//		System.out.println(distanceSum);
		return minDistance;
//		return 3;
	}
    
    public String getPublicName()
    {
        return "pixel-based";
    }

}
