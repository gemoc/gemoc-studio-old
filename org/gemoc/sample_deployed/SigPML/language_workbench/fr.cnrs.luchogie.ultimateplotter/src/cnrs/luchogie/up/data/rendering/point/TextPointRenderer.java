package cnrs.luchogie.up.data.rendering.point;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;

import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;



/**
 * @author Luc Hogie
 */
public class TextPointRenderer extends PointRenderer
{
	private String text = "";
	private Font font = new Font(null, Font.PLAIN, 12);
	
	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		Dimension xDimension = space.getXDimension();
		Dimension yDimension = space.getYDimension();

		Point point = (Point) object;
		int x = xDimension.convertToGraphicsCoordonateSystem(point.getX());
		int y = yDimension.convertToGraphicsCoordonateSystem(point.getY());
		space.getFigureGraphics().setColor(getColor());
		FontRenderContext frc = space.getFigureGraphics().getFontRenderContext();
		GlyphVector gv = font.createGlyphVector( frc, text );
		Rectangle2D r = gv.getLogicalBounds();
		x =  x - (int) r.getWidth() / 2 + getXShift();
		y =  y + (int) r.getHeight() / 2 + getYShift();
		space.getFigureGraphics().drawGlyphVector( gv, x, y );
	}

	/**
	 * Returns the font.
	 * @return Font
	 */
	public Font getFont()
	{
		return font;
	}

	/**
	 * Returns the text.
	 * @return String
	 */
	public String getText()
	{
		return text;
	}


	/**
	 * Sets the font.
	 * @param font The font to set
	 */
	public void setFont(Font font)
	{
		if ( font == null )
			throw new IllegalArgumentException( "font cannot be set to null" );

		this.font = font;
	}

	/**
	 * Sets the text.
	 * @param text The text to set
	 */
	public void setText(String text)
	{
		if ( text == null )
		{
			text = null;
		}

		this.text = text;
	}
    
    public String getPublicName()
    {
        return "text";
    }

}
