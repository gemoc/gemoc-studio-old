package cnrs.luchogie.up.system;

import java.awt.Color;
import java.awt.Graphics2D;

public class Grid extends SpaceElement
{
    private Graduation referenceGraduation;
    private double density = 0.25f;

    public Grid()
    {
	setColor(Color.lightGray);
	setVisible(true);
    }

    public Dimension getParentDimension()
    {
	return (Dimension) getParent();
    }

    public double getDensity()
    {
	return density;
    }

    public void setDensity(double d)
    {
	if (d < 0 || d > 1)
	    throw new IllegalArgumentException("density must be in the [0, 1] interval");

	this.density = d;
    }

    protected void draw(Graphics2D graphics)
    {
	if (isVisible())
	{
	    Dimension dimension = (Dimension) getParent();
	    Graduation graduation = getReferenceGraduation();
	    double step = graduation.getStep();
	    graphics.setColor(getColor());
	    int gridStep = (int) (1 / getDensity());
	    double min = Math.max(graduation.getMin(), dimension.getMin());
	    double max = Math.min(graduation.getMax(), dimension.getMax());

	    if (dimension.getOrientation() == Dimension.ORIENTATION_X)
	    {
		int gh = (int) graphics.getClipBounds().getHeight();

		for (double i = 0; i <= max; i += step)
		{
		    if (i > min)
		    {
			int gx = dimension.convertToGraphicsCoordonateSystem(i);

			for (int gy = 0; gy < gh; gy += gridStep)
			{
			    graphics.drawLine(gx, gy, gx, gy);
			}
		    }
		}

		for (double i = -step; i >= min; i -= step)
		{
		    if (i < max)
		    {
			int gx = dimension.convertToGraphicsCoordonateSystem(i);

			for (int gy = 0; gy < gh; gy += gridStep)
			{
			    graphics.drawLine(gx, gy, gx, gy);
			}
		    }
		}
	    }
	    else
	    {

		int gw = (int) graphics.getClipBounds().getWidth();

		for (double i = 0; i <= max; i += step)
		{
//		    i = lucci.math.MathsUtilities.round(i, 0);

		    if (i > min)
		    {
			int gy = dimension.convertToGraphicsCoordonateSystem(i);

			for (int gx = 0; gx < gw; gx += gridStep)
			{
			    graphics.drawLine(gx, gy, gx, gy);
			}
		    }
		}

		for (double i = -step; i >= min; i -= step)
		{
//		    i = lucci.math.MathsUtilities.round(i, 0);

		    if (i < max)
		    {
			int gy = dimension.convertToGraphicsCoordonateSystem(i);

			for (int gx = 0; gx < gw; gx += gridStep)
			{
			    graphics.drawLine(gx, gy, gx, gy);
			}
		    }
		}
	    }
	}
    }

    /**
     * Returns the referenceGraduation.
     * 
     * @return Graduation
     */
    public Graduation getReferenceGraduation()
    {
	if (referenceGraduation == null)
	{
	    Dimension dimension = (Dimension) getParent();
	    return dimension.getOriginAxis().getGraduation();
	}
	else
	{
	    return referenceGraduation;
	}
    }

    /**
     * Sets the referenceGraduation.
     * 
     * @param referenceGraduation
     *            The referenceGraduation to set
     */
    public void setReferenceGraduation(Graduation referenceGraduation)
    {
	this.referenceGraduation = referenceGraduation;
    }

    public String toString()
    {
	return "Grid";
    }
}
