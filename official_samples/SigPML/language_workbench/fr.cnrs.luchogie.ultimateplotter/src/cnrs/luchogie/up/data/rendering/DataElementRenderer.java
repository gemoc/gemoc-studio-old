package cnrs.luchogie.up.data.rendering;


import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.system.*;

import java.awt.*;

/**
 * @author Luc Hogie
 */
public abstract class DataElementRenderer
{
	private Color color = new Color( 0, 0, 255);
	private Stroke stroke = new BasicStroke();


	public final void draw( DataElement object, Space space )
	{
		//System.out.println(getClass().getName() + " is drawing");
		//if ( getClass() == PointAsDotRenderer.class)new Error().printStackTrace();
		Graphics2D graphics = space.getFigureGraphics();
		graphics.setColor(getColor());
		graphics.setStroke(getStroke());
		drawImpl(object, space);
	}


	protected abstract void drawImpl( DataElement object, Space space );

	/**
	 * Returns the color.
	 * @return Color
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * Sets the color.
	 * @param color The color to set
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}


	public Stroke getStroke()
	{
	    return stroke;
	}
	
	public void setStroke(Stroke stroke)
	{
	    this.stroke = stroke;
	}
    
    public String getPublicName()
    {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf('.'));
    }
}
