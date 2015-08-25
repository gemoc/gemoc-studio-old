package cnrs.luchogie.up.data.rendering.figure;


import cnrs.luchogie.up.data.*;
import cnrs.luchogie.up.system.*;

import java.awt.Polygon;
/**
 * @author Luc Hogie
 */
public class PolygonFigureRenderer extends FigureRenderer
{
	private boolean filled = true;

	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		Figure pointList = (Figure) object;
		int pointCount = pointList.getPointCount();
		Polygon polygon = new Polygon();
	
		for (int i = 0; i < pointCount; ++i)
		{
			Point point = pointList.getPointAt(i);
			int px = space.getXDimension().convertToGraphicsCoordonateSystem(point.getX());
			int py = space.getYDimension().convertToGraphicsCoordonateSystem(point.getY());
			polygon.addPoint(px, py);
		}
		
		if ( filled )
		{
			space.getFigureGraphics().fillPolygon(polygon);
		}
		else
		{
			space.getFigureGraphics().drawPolygon(polygon);
		}
	}

	/**
	 * Returns the filled.
	 * @return boolean
	 */
	public boolean isFilled()
	{
		return filled;
	}

	/**
	 * Sets the filled.
	 * @param filled The filled to set
	 */
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
    
    public String getPublicName()
    {
        return "polygone";
    }

}
