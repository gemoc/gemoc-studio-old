package cnrs.luchogie.up.system;

/**
 * <p>Titre : </p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Société : </p>
 * @author non attribué
 * @version 1.0
 */

import java.awt.*;



/**
 *
 * <p>
 * This models the arrow that is drawn on the upper bound of the parent axis
 * line.
 * </p>
 * 
 * <p>
 * It is possible to set the length and the width of this arrow.
 * </p>
 * @author Luc Hogie
 */
public class Arrow extends SpaceElement
{
	private int width = 8;
	private int length = 12;


	public AxisLine getParentAxisLine()
	{
		return (AxisLine) getParent();
	}

    protected void draw( Graphics graduationGraphics, Graphics2D graphics )
    {
		if ( isVisible() )
		{
			AxisLine axisLine = (AxisLine) getParent();
			Axis axis = (Axis) axisLine.getParent();
			Dimension dimension = (Dimension) axis.getParent();
			Dimension siblingDimension = dimension.getSiblingDimension();

			if ( axis.getPosition() == Axis.ORIGIN &&
					(dimension.getMin() >= 0 || dimension.getMax() <= 0))
			{
				// if the graphics is too small, only origin axis's arrows should be drawn
			}
			else
			{
				Space space = (Space) dimension.getParent();

				if ( dimension.getOrientation() == Dimension.ORIENTATION_X )
				{
					// the arrow is drawn at the top of the axis line
					int x = dimension.convertToGraphicsCoordonateSystem(axisLine.getMax())
						+ siblingDimension.getLowerBoundAxis().getGraduation().getDedicatedPixelCount();

					// assuming we're drawing the arrow for the upper bound axis
					int y = dimension.getUpperBoundAxis().getGraduation().getDedicatedPixelCount();
					
					// if this is the arrow of the origin axis, we have to change the y
					if ( axis.getPosition() == Axis.ORIGIN )
					{
						y += siblingDimension.convertToGraphicsCoordonateSystem(0);
					}
					else if ( axis.getPosition() == Axis.LOWER_BOUND )
					{
						y += siblingDimension.getGraphicsSize(space.getGraphics());
					}

					Polygon polygon = new Polygon();
					polygon.addPoint(x, y);
					polygon.addPoint(x - getLength(), y - getWidth() / 2);
					polygon.addPoint(x - getLength(), y + getWidth() / 2);
					graduationGraphics.setColor(getColor());
					graduationGraphics.drawPolygon(polygon);
					graduationGraphics.fillPolygon(polygon);
				}
				else
				{
					int x = dimension.getLowerBoundAxis().getGraduation().getDedicatedPixelCount();
					int y = dimension.convertToGraphicsCoordonateSystem(axisLine.getMax())
						+ siblingDimension.getUpperBoundAxis().getGraduation().getDedicatedPixelCount();
					
					if ( axis.getPosition() == Axis.ORIGIN )
					{
						x += siblingDimension.convertToGraphicsCoordonateSystem(0);
					}
					else if ( axis.getPosition() == Axis.UPPER_BOUND )
					{
						x += siblingDimension.getGraphicsSize(space.getGraphics());
					}
					
					Polygon polygon = new Polygon();
					polygon.addPoint(x, y);
					polygon.addPoint(x - getWidth() / 2, y + getLength());
					polygon.addPoint(x + getWidth() / 2, y + getLength());
					graduationGraphics.setColor(getColor());
					graduationGraphics.drawPolygon(polygon);
					graduationGraphics.fillPolygon(polygon);
				}
			}
		}
    }

	/**
	 * Returns the length of the arrow.
	 * @return int
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * Returns the width of the arrow.
	 * @return int
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Sets the length of the arrow.
	 * @param length The length to set
	 */
	public void setLength(int length)
	{
		if ( length <= 0 )
			throw new IllegalArgumentException( "length must be > 0" );

		this.length = length;
	}

	/**
	 * Sets the width of the arrow.
	 * @param width The width to set
	 */
	public void setWidth(int width)
	{
		if ( width <= 0 )
			throw new IllegalArgumentException( "width must be > 0" );

		this.width = width;
	}
	
	public String toString()
	{
		return "Arrow";
	}
}