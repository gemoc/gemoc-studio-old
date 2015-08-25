package cnrs.luchogie.up.data.rendering.point;



import cnrs.luchogie.up.data.*;
import cnrs.luchogie.up.system.*;

import java.awt.Color;

/**
 * @author Luc Hogie
 */
public class PolygoneRenderer extends PointRenderer
{
    private int radius = 10;
    private int numberOfEdges = 3;
    private Color fillColor = Color.white;
    
    /**
     * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
     */
    public void drawImpl(DataElement object, Space space)
    {
        Point point = (Point) object;
        Dimension xDimension = space.getXDimension();
        Dimension yDimension = space.getYDimension();

        int x = xDimension.convertToGraphicsCoordonateSystem(point.getX());
        int y = yDimension.convertToGraphicsCoordonateSystem(point.getY());

        if ( radius == 0 )
        {
            // draw nothing
        }
        if ( radius == 1 )
        {
            space.getFigureGraphics().drawLine(x, y, x, y);
        }
        else
        {
            Color color = getColor();
            int[] xs = new int[numberOfEdges];
            int[] ys = new int[numberOfEdges];
            findCoordinates(new Point(x, y), this.radius, Math.PI  / numberOfEdges, xs, ys);
            
            if ( fillColor != null )
            {
                space.getFigureGraphics().setColor(fillColor);
                space.getFigureGraphics().fillPolygon(xs, ys, numberOfEdges);
            }

            space.getFigureGraphics().setColor(color);
            space.getFigureGraphics().drawPolygon(xs, ys, numberOfEdges);
        }
    }

    private void findCoordinates(Point origin, int radius, double initialAngle, int[] xs, int[] ys)
    {
        Point rotatingPoint = new Point(origin.getX() + radius, origin.getY());
        rotatingPoint.rotate(initialAngle, origin);

        double angle = Math.PI * 2 / (double) xs.length;

        for (int i = 0; i < xs.length; ++i)
        {
            xs[i] = (int) rotatingPoint.getX();
            ys[i] = (int) rotatingPoint.getY();
            rotatingPoint.rotate(angle, origin);
        }
    }

    /**
     * Returns the size.
     * @return int
     */
    public int getRadius()
    {
        return radius;
    }

    /**
     * Sets the size.
     * @param size The size to set
     */
    public void setRadius(int size)
    {
        if ( size < 0 )
            throw new IllegalArgumentException( "size must be >= 0" );

        this.radius = size;
    }


    /**
     * Returns the fillColor.
     * @return Color
     */
    public Color getFillColor()
    {
        return fillColor;
    }



    /**
     * Sets the fillColor.
     * @param fillColor The fillColor to set
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
    }

    public String getPublicName()
    {
        return "polygon";
    }

}
