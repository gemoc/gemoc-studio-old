package cnrs.luchogie.up.system;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

/**
 * <p>
 * A space is the abstract thing that defines the dimension X and Y. This models
 * the mathematical concept of space.
 * </p>
 * 
 * <p>
 * A space is made of:
 * <ul>
 * <li>2 dimensions (X and Y),
 * <li>an origin point with coordinates (0, 0),
 * <li>a scale that calculates the position on a Java Graphics2D of a logic
 * coordinate.
 * </ul>
 * </p>
 * 
 * <p>
 * The space features also a legend that will be drawn on top of the graphics
 * representation.
 * </p>
 * 
 * @author Luc Hogie.
 */

public class Space extends SpaceElement
{
    private Legend legend = new Legend("Ultimate Plotter");
    private Dimension xDimension;
    private Dimension yDimension;
    private Point2D originPoint = new Point2D.Double(0, 0);
    private Graphics2D graphics;
    private Graphics2D figureGraphics;

    /*
     * the imageObserver is the object that will render the image on its pane.
     * it can be a SwingPlotter
     */
    private ImageObserver imageObserver;

    private Color backgroundColor = Color.white;

    public Space()
    {
	init();
    }

    private void init()
    {
	Dimension xDimension = new Dimension();
	setXDimension(xDimension);
	xDimension.getLegend().setText("X dimension");

	Dimension yDimension = new Dimension();
	setYDimension(yDimension);
	yDimension.getLegend().setText("Y dimension");
	legend.setFont(new Font(null, Font.PLAIN, 20));
    }

    /**
     * Sets the X dimension of the space.
     * 
     * @param xDimension
     */
    public void setXDimension(Dimension xDimension)
    {
	if (xDimension == null)
	    throw new IllegalArgumentException("X dimension cannot be set to null");

	this.xDimension = xDimension;
	xDimension.setParent(this);
    }

    /**
     * Gets the X dimension of the space.
     * 
     * @return Dimension
     */
    public Dimension getXDimension()
    {
	return xDimension;
    }

    /**
     * Sets the Y dimension of the space.
     * 
     * @param yDimension
     */
    public void setYDimension(Dimension yDimension)
    {
	if (yDimension == null)
	    throw new IllegalArgumentException("Y dimension cannot be set to null");

	this.yDimension = yDimension;
	yDimension.setParent(this);
    }

    /**
     * Gets the X dimension of the space.
     * 
     * @return Dimension
     */
    public Dimension getYDimension()
    {
	return yDimension;
    }

    /**
     * Gets the origin point (the point with (0, 0) coordinates) of the space.
     * Obviously, the real position (on the Graphics2D) of this point is not (0,
     * 0).
     * 
     * @return Point2D
     */
    public Point2D getOriginPoint()
    {
	return originPoint;
    }

    /**
     * Gets the Java2D Graphics2D on which the space is to be drawn.
     * 
     * @return Graphics2D
     */
    protected Graphics2D getGraphics()
    {
	return graphics;
    }

    public void setGraphics(Graphics2D g)
    {
	this.graphics = g;
    }

    /**
     * Sets the range of the space. This is a facility method: this can be done
     * directly manipulating the dimensions of the space.
     * 
     * Warning! This is a convenience method. The Dimension, Graduation and
     * AxisLine classes allow you to have a better control.
     * 
     * @param xmin
     * @param xmax
     * @param xstep
     * @param ymin
     * @param ymax
     * @param ystep
     */
    public void setRange(double xmin, double xmax, double xstep, double ymin, double ymax, double ystep)
    {
	xDimension.setBounds(xmin, xmax);
	xDimension.getLowerBoundAxis().getGraduation().setStep(xstep);
	xDimension.getUpperBoundAxis().getGraduation().setStep(xstep);
	xDimension.getOriginAxis().getGraduation().setStep(xstep);

	yDimension.setBounds(ymin, ymax);
	yDimension.getLowerBoundAxis().getGraduation().setStep(ystep);
	yDimension.getUpperBoundAxis().getGraduation().setStep(ystep);
	yDimension.getOriginAxis().getGraduation().setStep(ystep);
    }

    /**
     * Sets the visibility of the grid.
     * 
     * Warning! This is a facade method. The grid class feature many methods
     * that allow a better control.
     * 
     * @param gridTracing
     */
    public void setGridVisible(boolean gridTracing)
    {
	getXDimension().getGrid().setVisible(gridTracing);
	getYDimension().getGrid().setVisible(gridTracing);
    }

    public void setArrowsVisible(boolean b)
    {
	getXDimension().getLowerBoundAxis().getLine().getArrow().setVisible(b);
	getXDimension().getOriginAxis().getLine().getArrow().setVisible(b);
	getXDimension().getUpperBoundAxis().getLine().getArrow().setVisible(b);
	getYDimension().getLowerBoundAxis().getLine().getArrow().setVisible(b);
	getYDimension().getOriginAxis().getLine().getArrow().setVisible(b);
	getYDimension().getUpperBoundAxis().getLine().getArrow().setVisible(b);
    }


    public enum MODE {MATHS, PHYSICS}
    
    public void setMode(MODE mode)
    {
	init();

	if (mode == MODE.MATHS)
	{
	    getLegend().setText("Maths mode");

	    getXDimension().getLowerBoundAxis().setVisible(false);
	    getXDimension().getUpperBoundAxis().setVisible(false);

	    getYDimension().getLowerBoundAxis().setVisible(false);
	    getYDimension().getUpperBoundAxis().setVisible(false);
	}
	else if (mode == MODE.PHYSICS)
	{
	    getLegend().setText("Physics mode");
	    setBackgroundColor(Color.black);
	    setColor(Color.white);

	    getXDimension().getOriginAxis().setVisible(false);

	    getYDimension().getOriginAxis().setVisible(false);

	    getXDimension().getLegend().setFont(new Font(null, Font.PLAIN, 12));
	    getYDimension().getLegend().setFont(new Font(null, Font.PLAIN, 12));
	    getXDimension().getOriginAxis().setVisible(false);
	    getXDimension().getLowerBoundAxis().getLine().getArrow().setVisible(false);
	    getXDimension().getUpperBoundAxis().getLine().getArrow().setVisible(false);
	    getYDimension().getOriginAxis().setVisible(false);
	    getYDimension().getLowerBoundAxis().getLine().getArrow().setVisible(false);
	    getYDimension().getUpperBoundAxis().getLine().getArrow().setVisible(false);
	}
    }

    public void draw(Graphics2D spaceGraphics, Graphics2D figureGraphics)
    {
	if (isVisible())
	{
	    // the first thing to do is to initialize the graduations and draw
	    // the grids

	    xDimension.getGrid().draw(figureGraphics);
	    yDimension.getGrid().draw(figureGraphics);


	    // then the rest can be drawn
	    xDimension.draw(spaceGraphics, figureGraphics);
	    yDimension.draw(spaceGraphics, figureGraphics);
	}
    }

    /**
     * Returns the imageObserver.
     * 
     * @return ImageObserver
     */
    public ImageObserver getImageObserver()
    {
	return imageObserver;
    }

    /**
     * Sets the imageObserver.
     * 
     * @param imageObserver
     *            The imageObserver to set
     */
    public void setImageObserver(ImageObserver imageObserver)
    {
	this.imageObserver = imageObserver;
    }

    public Legend getLegend()
    {
	return legend;
    }

    public void setLegend(Legend newLegend)
    {
	if (newLegend == null)
	    throw new IllegalArgumentException("the legend cannot be set to null");

	this.legend = newLegend;
	legend.setParent(this);
    }

    /**
     * Returns the backgroundColor.
     * 
     * @return Color
     */
    public Color getBackgroundColor()
    {
	return backgroundColor;
    }

    /**
     * Sets the backgroundColor.
     * 
     * @param backgroundColor
     *            The backgroundColor to set
     */
    public void setBackgroundColor(Color backgroundColor)
    {
	if (backgroundColor == null)
	    throw new IllegalArgumentException("backgroundColor cannot be set to null");

	this.backgroundColor = backgroundColor;
    }

    public String toString()
    {
	return "Space";
    }

    public Graphics2D getFigureGraphics()
    {
	return figureGraphics;
    }

    public void setFigureGraphics(Graphics2D graphics2D)
    {
	figureGraphics = graphics2D;
    }

}