package cnrs.luchogie.up.data.rendering.point;



import java.awt.Color;

import cnrs.luchogie.up.data.*;
import cnrs.luchogie.up.system.*;

/**
 * @author Luc Hogie
 */

public class HistogramPointRenderer extends PointRenderer
{
    private double barWidth = 1;

    private Color fillColor = Color.white;

    /**
     * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
     */
    public void drawImpl(DataElement object, Space space)
    {
        Point point = (Point) object;
        Dimension xDimension = space.getXDimension();
        Dimension yDimension = space.getYDimension();

        int x1 = xDimension.convertToGraphicsCoordonateSystem(point.getX() - getBarWidth() / 2);
        int y1 = yDimension.convertToGraphicsCoordonateSystem(point.getY());

        int x2 = xDimension.convertToGraphicsCoordonateSystem(point.getX() + getBarWidth() / 2);
        int y2 = yDimension.convertToGraphicsCoordonateSystem(0);
        space.getFigureGraphics().setColor(this.fillColor);
        space.getFigureGraphics().fillRect(x1, y1, x2 - x1, y2 - y1);
        space.getFigureGraphics().setColor(java.awt.Color.black);
        space.getFigureGraphics().drawRect(x1, y1, x2 - x1, y2 - y1);
    }

    public double getBarWidth()
    {
        return barWidth;
    }

    public void setBarWidth(double barWidth)
    {
        this.barWidth = barWidth;
    }

    public Color getFillColor()
    {
        return fillColor;
    }

    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
    }
    
    public String getPublicName()
    {
        return "bar chart";
    }

}