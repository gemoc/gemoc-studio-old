/*
 * Created on Mar 22, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.util.Vector;

import cnrs.luchogie.up.data.Figure;


public class FigureLegend extends Legend
{
	private int lineSpacingInPixel = 5;
	private Color textColor = null;
	private Color borderLineColor = null; 
	private Color backgroundColor = null; 

	public void draw(Graphics2D g, Space space, Figure figure)
	{
		if (isVisible())
		{
			int iconWidth = 10;
			Vector glyphVectors = new Vector();

			if ( figure.getPointCount() == 0 && figure.getFigureCount() > 1 )
			{
				int legendGraphicsWidth = 0;
				int legendGraphicsHeight = 0;

				for (int i = 0; i < figure.getFigureCount(); ++i)
				{
					Figure subFigure = figure.getFigureAt(i);

					if (subFigure.getFigureCount() == 0 && subFigure.getRendererCount() == 1)
					{
						Font font = new Font( null, Font.PLAIN, 16 );
						FontRenderContext frc = g.getFontRenderContext();
						GlyphVector gv = font.createGlyphVector( frc, subFigure.getName().trim() );
						glyphVectors.add(new Object[] {gv, subFigure.getRendererAt(0).getColor()});
						legendGraphicsHeight += font.getSize() + lineSpacingInPixel;
						int textWith = gv.getVisualBounds().getBounds().getSize().width;
						if (legendGraphicsWidth < textWith) legendGraphicsWidth = textWith;
					}
				}

				legendGraphicsWidth += iconWidth + 8;
				legendGraphicsHeight += lineSpacingInPixel;

				int x = g.getClipBounds().getSize().width - legendGraphicsWidth - 10;
				int y = 10;
				Graphics2D legendGraphics = (Graphics2D) g.create(x, y, legendGraphicsWidth, legendGraphicsHeight);

				Color backgroundColor = null;

				if (getBackgroundColor() == null)
				{
					backgroundColor = space.getBackgroundColor();
					backgroundColor = new Color(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue(), 220);
				}
				else
				{
					backgroundColor = getBackgroundColor();
				}

				legendGraphics.setColor(backgroundColor);
				legendGraphics.fillRect(0, 0, legendGraphicsWidth, legendGraphicsHeight);

				if (borderLineColor != null)
				{
					legendGraphics.setColor(borderLineColor);
					legendGraphics.drawRect(0, 0, legendGraphicsWidth - 1, legendGraphicsHeight - 1);
				}

				int figureLegendY = 0;

				for (int i = 0; i < glyphVectors.size(); ++i)
				{
					GlyphVector gv = (GlyphVector) ((Object[]) glyphVectors.get(i))[0];
					Color color = (Color) ((Object[]) glyphVectors.get(i))[1];
					figureLegendY += (int) (gv.getVisualBounds().getHeight() + lineSpacingInPixel);
					legendGraphics.setColor(color);
					legendGraphics.drawLine(2, (int) (figureLegendY - gv.getVisualBounds().getHeight() / 3), iconWidth, (int) (figureLegendY - gv.getVisualBounds().getHeight() / 3));

					if (textColor != null)
					{
						legendGraphics.setColor(textColor);
					}

					legendGraphics.drawGlyphVector( gv, 2 + iconWidth + 2, figureLegendY );
				}
			}
		}
	}
	
	public int getLineSpacingInPixel()
	{
		return lineSpacingInPixel;
	}

	public void setLineSpacingInPixel(int i)
	{
		if (lineSpacingInPixel < 0)
			throw new IllegalArgumentException("invalid line spacing is negative");

		lineSpacingInPixel = i;
	}

	public Color getBorderLineColor()
	{
		return borderLineColor;
	}

	public Color getTextColor()
	{
		return textColor;
	}

	public void setBorderLineColor(Color color)
	{
		borderLineColor = color;
	}

	public void setTextColor(Color color)
	{
		textColor = color;
	}

	public Color getBackgroundColor()
	{
		return backgroundColor;
	}

	public void setBackgroundColor(Color color)
	{
		backgroundColor = color;
	}

	public String toString()
	{
		return "Figures legend";
	}
}
