package cnrs.luchogie.up.data.rendering.figure;



import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;
/**
 * @author Luc Hogie
 * 
 * Draws a line between each point of the figure to the barycenter of the set of points in the figure.
 */


public class BarycenterFigureRenderer extends FigureRenderer
{
	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		Figure pointList = (Figure) object;
		int pointCount = pointList.getPointCount();

		if ( pointCount > 0 )
		{
			double x = pointList.getPointAt( 0 ).getX();
			double y = pointList.getPointAt( 0 ).getY();
	
			for (int i = 1; i < pointCount; ++i)
			{
				x += pointList.getPointAt( i ).getX();
				y += pointList.getPointAt( i ).getY();
			}

			Dimension xDimension = space.getXDimension();
			Dimension yDimension = space.getYDimension();

			int bx = xDimension.convertToGraphicsCoordonateSystem(x / pointCount);
			int by = yDimension.convertToGraphicsCoordonateSystem(y / pointCount);

			for (int i = 0; i < pointCount; ++i)
			{
				Point point = pointList.getPointAt(i);
				int px = xDimension.convertToGraphicsCoordonateSystem(point.getX());
				int py = yDimension.convertToGraphicsCoordonateSystem(point.getY());
				space.getFigureGraphics().drawLine( bx, by, px, py );
			}
		}
	}
    
    public String getPublicName()
    {
        return "Barycenter";
    }
}
