package cnrs.luchogie.up.system;


import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;


public class Legend extends SpaceElement
{
	private static Font defaultFont = new Font( null, Font.PLAIN, 16 );
	private String text = "No legend defined";
	private Font f = defaultFont;
	private Color backgroundColor = null;

	public Legend()
	{
		this( "Legend" );
	}

	public Legend( String text )
	{
		setText( text );
	}


	public Color getBackgroundColor()
	{
	    return backgroundColor;
	}

	public void setBackgroundColor( Color b )
	{
	    backgroundColor = b;
	}

	/**
	 * Gets the text of the legend.
	 * @return String
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * Sets the text of the legend.
	 * @param text
	 */
	public void setText( String text )
	{
		if ( text == null )
			throw new IllegalArgumentException( "legend text cannot be set to null" );

		this.text = text;
	}

	/**
	 * Gets the font of the legend.
	 * @return Font
	 */
	public Font getFont()
	{
		return f;
	}

	/**
	 * Sets the font of the legend.
	 * @param f
	 */
	public void setFont( Font f )
	{
		if ( f == null )
			throw new IllegalArgumentException( "null font is not allowed" );

		this.f = f;
	}


	public void draw( Graphics2D graphics )
	{
	    if ( backgroundColor != null )
	    {
			graphics.setColor( backgroundColor );
			graphics.fillRect( 0, 0, (int) graphics.getClipBounds().getWidth(), (int) graphics.getClipBounds().getHeight() );
	    }

	    String text = getText();
	    Font font = getFont();
	    FontRenderContext frc = graphics.getFontRenderContext();
	    GlyphVector gv = font.createGlyphVector( frc, text );
	    Rectangle2D r = gv.getPixelBounds(null, 0, 0);
	    int textWidth = (int) r.getWidth();
	    int textHeight = (int) r.getHeight();
	    int textX = (int) -textWidth / 2;
	    int textY = (int) textHeight / 2;
	    graphics.translate( graphics.getClipBounds().getWidth() / 2, graphics.getClipBounds().getHeight() / 2 );

		// if the legend is the Y dimension legend, it has to be rotated
		if ( getParent() instanceof Dimension && ((Dimension) getParent()).getParentSpace().getYDimension().getLegend() == this )
		{
			graphics.rotate( -Math.PI / 2 );
		}

	    graphics.setColor( getColor() );
	    graphics.drawGlyphVector( gv, textX, textY );
	    graphics.translate( -graphics.getClipBounds().getWidth() / 2, -graphics.getClipBounds().getHeight() / 2 );
	}
	public String toString()
	{
		return "Legend";
	}
}
