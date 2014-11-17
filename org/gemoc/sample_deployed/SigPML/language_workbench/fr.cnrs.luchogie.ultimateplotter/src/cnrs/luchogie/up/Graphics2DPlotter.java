package cnrs.luchogie.up;

import java.awt.*;

import cnrs.luchogie.up.data.*;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.FigureLegend;
import cnrs.luchogie.up.system.Legend;
import cnrs.luchogie.up.system.Space;

/**
 * The Graphics2DPlotter is the component that paint the user's Graphics2D.
 * The paint process is not implemented in a Swing component because the
 * user may want to get a graphical reprensentation of its 2D data without
 * showing it on a user interface widget: for example the user may want to
 * export the graphical representation to an image file or event
 * directly print it.
 * 
 * @author Luc Hogie
 */
public class Graphics2DPlotter
{
	private Figure figure;
	private Space space = new Space();
	private FigureLegend figureLegend = new FigureLegend();

	public int figureGraphicsX = 0;
	public int figureGraphicsY = 0;



    /**
     * Returns the space that is used to layout the data representation.
     * @return Space
     */
	public Space getSpace()
	{
	    return space;
	}

	/**
     * Sets she space that is used to layout the data representation.
	 * @param space The space to set
	 */
	public void setSpace(Space space)
	{
		if ( space == null )
			throw new IllegalArgumentException( "Space cannot be set to null" );

		this.space = space;
	}


	/**
     * Returns the figure that will be drawn.
	 */
	public Figure getFigure()
	{
		return figure;
	}

	/**
     * Sets the figure that will be drawn.
	 * @param figure
     */
	public void setFigure( Figure figure )
	{
		this.figure = figure;
	}

	
	/**
	 * Paints the space and the figure on the given graphics.
	 */
	public void paint( Graphics2D graphics )
	{
		figureGraphicsX = figureGraphicsY = 0;
		graphics.setColor( space.getBackgroundColor() );
		graphics.fillRect( 0, 0, (int) graphics.getClipBounds().getWidth(), (int) graphics.getClipBounds().getHeight() );
		drawEverything( graphics );
	}

	private void drawEverything( Graphics2D graphics )
	{

		Legend mainLegend = space.getLegend();

		if ( !mainLegend.isVisible() )
		{
			drawAxisLegendsAndAxisAndPoints( graphics );
		}
		else
		{
			int legendGraphicsX = 0;
			int legendGraphicsY = 0;
			int legendGraphicsW = (int) graphics.getClipBounds().getWidth();
			int legendGraphicsH = mainLegend.getFont().getSize() * 2;
			Graphics2D spaceLegendGraphics = (Graphics2D) graphics.create( legendGraphicsX, legendGraphicsY, legendGraphicsW, legendGraphicsH );
			mainLegend.draw( spaceLegendGraphics );

			int curveAndAxisLegendsGraphicsX = 0;
			int curveAndAxisLegendsGraphicsY = legendGraphicsH;
			int curveAndAxisLegendsGraphicsW = legendGraphicsW;
			int curveAndAxisLegendsGraphicsH = (int) (graphics.getClipBounds().getHeight() - legendGraphicsH);
			Graphics2D spaceAndDimensionLegendsGraphics = (Graphics2D) graphics.create( curveAndAxisLegendsGraphicsX, curveAndAxisLegendsGraphicsY, curveAndAxisLegendsGraphicsW, curveAndAxisLegendsGraphicsH );
			drawAxisLegendsAndAxisAndPoints( spaceAndDimensionLegendsGraphics );

			figureGraphicsY += curveAndAxisLegendsGraphicsY;
		}

	}

	private void drawAxisLegendsAndAxisAndPoints( Graphics2D spaceAndDimensionLegendsGraphics )
	{
		Dimension xDimension = space.getXDimension();
		Dimension yDimension = space.getYDimension();
		Legend xLegend = xDimension.getLegend();
		Legend yLegend = yDimension.getLegend();

		if ( xLegend.isVisible() && yLegend.isVisible() )
		{
			int curveGraphicsX = yLegend.getFont().getSize() * 2;
			int curveGraphicsY = 0;
			int curveGraphicsW = (int) (spaceAndDimensionLegendsGraphics.getClipBounds().getWidth() - curveGraphicsX);
			int curveGraphicsH = (int) spaceAndDimensionLegendsGraphics.getClipBounds().getHeight() - xLegend.getFont().getSize() * 2;
			Graphics2D spaceGraphics = (Graphics2D) spaceAndDimensionLegendsGraphics.create( curveGraphicsX, curveGraphicsY, curveGraphicsW, curveGraphicsH );
			space.setGraphics(spaceGraphics);
			drawSpaceAndFigure( spaceGraphics );

			int xLegendGraphicsX = curveGraphicsX;
			int xLegendGraphicsY = curveGraphicsH;
			int xLegendGraphicsW = curveGraphicsW;
			int xLegendGraphicsH = (int) (spaceAndDimensionLegendsGraphics.getClipBounds().getHeight() - curveGraphicsH);
			Graphics2D xLegendGraphics = (Graphics2D) spaceAndDimensionLegendsGraphics.create( xLegendGraphicsX, xLegendGraphicsY, xLegendGraphicsW, xLegendGraphicsH );
			xLegend.draw( xLegendGraphics );

			int yLegendGraphicsX = 0;
			int yLegendGraphicsY = 0;
			int yLegendGraphicsW = curveGraphicsX;
			int yLegendGraphicsH = curveGraphicsH;
			Graphics2D yLegendGraphics = (Graphics2D) spaceAndDimensionLegendsGraphics.create( yLegendGraphicsX, yLegendGraphicsY, yLegendGraphicsW, yLegendGraphicsH );
			yLegend.draw( yLegendGraphics );

			figureGraphicsX += curveGraphicsX;
			figureGraphicsY += curveGraphicsY;
		}
		else if ( xLegend.isVisible() )
		{
			int curveGraphicsX = 0;
			int curveGraphicsY = 0;
			int curveGraphicsW = (int) (spaceAndDimensionLegendsGraphics.getClipBounds().getWidth() - curveGraphicsX);
			int curveGraphicsH = (int) spaceAndDimensionLegendsGraphics.getClipBounds().getHeight() - xLegend.getFont().getSize() * 2;
			Graphics2D spaceGraphics = (Graphics2D) spaceAndDimensionLegendsGraphics.create( curveGraphicsX, curveGraphicsY, curveGraphicsW, curveGraphicsH );
			space.setGraphics(spaceGraphics);
			drawSpaceAndFigure( spaceGraphics );

			int xLegendGraphicsX = curveGraphicsX;
			int xLegendGraphicsY = curveGraphicsH;
			int xLegendGraphicsW = curveGraphicsW;
			int xLegendGraphicsH = (int) (spaceAndDimensionLegendsGraphics.getClipBounds().getHeight() - curveGraphicsH);
			Graphics2D xLegendGraphics = (Graphics2D) spaceAndDimensionLegendsGraphics.create( xLegendGraphicsX, xLegendGraphicsY, xLegendGraphicsW, xLegendGraphicsH );
			xLegend.draw( xLegendGraphics );

			figureGraphicsX += curveGraphicsX;
			figureGraphicsY += curveGraphicsY;
		}
		else if ( yLegend.isVisible() )
		{
			int curveGraphicsX = yLegend.getFont().getSize() * 2;
			int curveGraphicsY = 0;
			int curveGraphicsW = (int) (spaceAndDimensionLegendsGraphics.getClipBounds().getWidth() - curveGraphicsX);
			int curveGraphicsH = (int) spaceAndDimensionLegendsGraphics.getClipBounds().getHeight();
			Graphics2D spaceGraphics = (Graphics2D) spaceAndDimensionLegendsGraphics.create( curveGraphicsX, curveGraphicsY, curveGraphicsW, curveGraphicsH );
			space.setGraphics(spaceGraphics);
			drawSpaceAndFigure( spaceGraphics );

			int yLegendGraphicsX = 0;
			int yLegendGraphicsY = 0;
			int yLegendGraphicsW = curveGraphicsX;
			int yLegendGraphicsH = curveGraphicsH;
			Graphics2D yLegendGraphics = (Graphics2D) spaceAndDimensionLegendsGraphics.create( yLegendGraphicsX, yLegendGraphicsY, yLegendGraphicsW, yLegendGraphicsH );
			yLegend.draw( yLegendGraphics );

			figureGraphicsX += curveGraphicsX;
			figureGraphicsY += curveGraphicsY;
		}
		else
		{
			space.setGraphics(spaceAndDimensionLegendsGraphics);

			drawSpaceAndFigure( spaceAndDimensionLegendsGraphics );
		}
	}

	private void drawSpaceAndFigure( Graphics2D spaceGraphics )
	{
		Dimension xDimension = getSpace().getXDimension();
		Dimension yDimension = getSpace().getYDimension();

		if (figure != null)
		{
			xDimension.updateBounds(figure);
			yDimension.updateBounds(figure);
			
			if (true)//space.isOrthogonal())
			{
				
			}
		}

		// the size required to set the size of the X graduation is known using the
		// size of the font used. This size is used to calculate the Y size of the
		// figure graphics, then the Y shown steps, then the size required to show the
		// Y graduation
		double ySize = spaceGraphics.getClipBounds().getHeight() 
			- space.getXDimension().getLowerBoundAxis().getGraduation().getFont().getSize() 
			- space.getXDimension().getLowerBoundAxis().getGraduation().getPixelCountBetweenAxisLineAndText()
			- space.getXDimension().getUpperBoundAxis().getGraduation().getFont().getSize()
			- space.getXDimension().getUpperBoundAxis().getGraduation().getPixelCountBetweenAxisLineAndText();

		space.getYDimension().getLowerBoundAxis().getGraduation().update( ySize, spaceGraphics );
		space.getYDimension().getOriginAxis().getGraduation().update( ySize, spaceGraphics );
		space.getYDimension().getUpperBoundAxis().getGraduation().update( ySize, spaceGraphics );

		double xSize = spaceGraphics.getClipBounds().getWidth()
			- space.getYDimension().getLowerBoundAxis().getGraduation().getDedicatedPixelCount() 
			- space.getYDimension().getLowerBoundAxis().getGraduation().getPixelCountBetweenAxisLineAndText()
			- space.getYDimension().getUpperBoundAxis().getGraduation().getDedicatedPixelCount()
			- space.getYDimension().getUpperBoundAxis().getGraduation().getPixelCountBetweenAxisLineAndText();
			
		space.getXDimension().getLowerBoundAxis().getGraduation().update( xSize, spaceGraphics );
		space.getXDimension().getOriginAxis().getGraduation().update( xSize, spaceGraphics );
		space.getXDimension().getUpperBoundAxis().getGraduation().update( xSize, spaceGraphics );

		int xp = space.getXDimension().getLowerBoundAxis().getGraduation().getDedicatedPixelCount();
		int yp = space.getYDimension().getLowerBoundAxis().getGraduation().getDedicatedPixelCount();
		int xs = space.getXDimension().getUpperBoundAxis().getGraduation().getDedicatedPixelCount();
		int ys = space.getYDimension().getUpperBoundAxis().getGraduation().getDedicatedPixelCount();
		int curveGraphicsX = yp;
		int curveGraphicsY = xs;
		int curveGraphicsW = (int) spaceGraphics.getClipBounds().getWidth() - yp - ys;
		int curveGraphicsH = (int) spaceGraphics.getClipBounds().getHeight() - xp - xs;

		figureGraphicsX += curveGraphicsX;
		figureGraphicsY += curveGraphicsY;

		if ( curveGraphicsW > 0 && curveGraphicsH > 0 )
		{
			Graphics2D figureGraphics = (Graphics2D) spaceGraphics.create( curveGraphicsX, curveGraphicsY, curveGraphicsW, curveGraphicsH );
			space.setFigureGraphics(figureGraphics);
			updateFigureRightBeforePainting();

			double xRange = xDimension.getMax() - xDimension.getMin();
			double yRange = yDimension.getMax() - yDimension.getMin();
			space.getOriginPoint().setLocation((int) (figureGraphics.getClipBounds().getWidth() * -xDimension.getMin() / xRange),
				(int) (figureGraphics.getClipBounds().getHeight() * yDimension.getMax() / yRange));


			space.draw( spaceGraphics, figureGraphics );

			if ( figure != null )
			{
				figure.draw( space );
				figureLegend.draw(figureGraphics, space, figure);
			}

			// the figure graphics shouldn't be set to null because it will be required for calculating
			// the logical location of user mouse pointing on the curve, which aim at enabling
			// user selections
//			space.setFigureGraphics(null);
		}
	}

	/**
	 * The user should redefine this method if he wants the figure (and/or its renderers)
	 * to be defined just before repainting.
	 */
	public void updateFigureRightBeforePainting()
	{
	}

	public FigureLegend getFigureLegend()
	{
		return figureLegend;
	}
}
