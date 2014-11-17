package cnrs.luchogie.up.data.rendering.figure;

import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;

public class RectangleRenderer extends FigureRenderer
{
    private boolean filled = false;
    
    public boolean isFilled()
    {
        return filled;
    }

    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }

    /**
     * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
     */
    public void drawImpl(DataElement object, Space space)
    {
        Figure pointList = (Figure) object;
        Dimension xDimension = space.getXDimension();
        Dimension yDimension = space.getYDimension();

        Point p1 = pointList.getPointAt(0);
        int p1x = xDimension.convertToGraphicsCoordonateSystem(p1.getX());
        int p1y = yDimension.convertToGraphicsCoordonateSystem(p1.getY());

        Point p2 = pointList.getPointAt(1);
        int p2x = xDimension.convertToGraphicsCoordonateSystem(p2.getX());
        int p2y = yDimension.convertToGraphicsCoordonateSystem(p2.getY());

        space.getFigureGraphics().setColor(getColor());
        space.getFigureGraphics().setStroke(getStroke());
        
        if (isFilled())
        {
            space.getFigureGraphics().fillRect(p1x, p1y, p2x, p2y);
        }
        else
        {
            space.getFigureGraphics().drawRect(p1x, p1y, p2x, p2y);
        }
    }

    public String getPublicName()
    {
        return "rectangle";
    }

}