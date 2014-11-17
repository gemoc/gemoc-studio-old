package cnrs.luchogie.up.data.rendering.figure;




import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;
/**
 * @author Luc Hogie
 * 
 * This renderer draws a line between each point and its subsequent point. This is a very
 * common process used to draw curves.
 */


public class ConnectedLineFigureRenderer extends FigureRenderer
{
	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		Figure pointList = (Figure) object;
		int pointCount = pointList.getPointCount();
		int step = 1;
	
		if (pointCount > 200 && isShownPointReductionEnabled())
		{
			step = (int) (pointCount / 200);
		}

		for (int i = step; i < pointCount; i += step)
		{
			Point point = pointList.getPointAt(i);
			Dimension xDimension = space.getXDimension();
			Dimension yDimension = space.getYDimension();

			int px = xDimension.convertToGraphicsCoordonateSystem(point.getX());
			int py = yDimension.convertToGraphicsCoordonateSystem(point.getY());

			Point previousPoint = pointList.getPointAt( i - step );
			int ppx = xDimension.convertToGraphicsCoordonateSystem(previousPoint.getX());
			int ppy = yDimension.convertToGraphicsCoordonateSystem(previousPoint.getY());

			space.getFigureGraphics().setColor(getColor());
            space.getFigureGraphics().setStroke(getStroke());
			space.getFigureGraphics().drawLine( ppx, ppy, px, py );
		}
	}
    
    public String getPublicName()
    {
        return "connected line";
    }

}
