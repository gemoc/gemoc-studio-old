package cnrs.luchogie.up.data.rendering.point;



import cnrs.luchogie.up.data.*;
import cnrs.luchogie.up.system.*;

import java.awt.Color;

/**
 * @author Luc Hogie
 */
public class CirclePointRenderer extends PointRenderer
{
	private int radius = 5;
	private Color fillColor = Color.white;
	private boolean useGradient = false;
	
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

			if ( useGradient )
			{
				for (int i = 1; i <= radius; ++i)
				{
					int hs = i / 2;
					Color c = new Color( color.getRed(), color.getGreen(), color.getBlue(), 255-i * 255 / radius );
					space.getFigureGraphics().setColor(c);
					space.getFigureGraphics().drawOval(x - hs, y - hs, i, i);
				}
			}
			else
			{
				if ( fillColor != null )
				{
					space.getFigureGraphics().setColor(fillColor);
					space.getFigureGraphics().fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
				}

				space.getFigureGraphics().setColor(color);
				space.getFigureGraphics().drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
			}
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
	 * Returns the useGradient.
	 * @return boolean
	 */
	public boolean isUseGradient()
	{
		return useGradient;
	}


	/**
	 * Sets the fillColor.
	 * @param fillColor The fillColor to set
	 */
	public void setFillColor(Color fillColor)
	{
		this.fillColor = fillColor;
	}

	/**
	 * Sets the useGradient.
	 * @param useGradient The useGradient to set
	 */
	public void setUseGradient(boolean useGradient)
	{
		this.useGradient = useGradient;
	}
    
    public String getPublicName()
    {
        return "circle";
    }

}
