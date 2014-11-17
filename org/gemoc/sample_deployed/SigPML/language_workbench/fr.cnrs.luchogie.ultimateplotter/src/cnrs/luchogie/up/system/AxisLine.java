package cnrs.luchogie.up.system;

import java.awt.*;


/**
 * <p>
 * The axis line belong to an axis. The bounds of the line may differ from
 * the bounds of the parent axis.
 * </p>
 *
 * <p>
 * On the upper bound of the line is drawn an arrow.
 * </p>
 *
 * @author Luc Hogie
 */
public class AxisLine extends BoundedSpaceElement
{
	private Arrow arrow = null;

	public AxisLine()
	{
		setArrow( new Arrow() );
	}

	public Axis getParentAxis()
	{
		return (Axis) getParent();
	}



	/**
	 * Returns the arrow.
	 * @return Arrow
	 */
	public Arrow getArrow()
	{
		return arrow;
	}

	/**
	 * Sets the arrow.
	 * @param arrow The arrow to set
	 */
	public void setArrow(Arrow arrow)
	{
		if ( arrow == null )
			throw new IllegalArgumentException( "arrow cannot be set to null" );

		arrow.setParent(this);
		this.arrow = arrow;
	}

	
    protected void draw( Graphics graduationGraphics, Graphics2D graphics )
    {
		if ( isVisible() )
		{
			Axis axis = (Axis) getParent();
	    	Dimension dimension = (Dimension) axis.getParent();

		    if ( isMinimumIsAutomatic() )
		    {
		    	setMin(dimension.getMin());
		    	setMinimumIsAutomatic(true);
		    }

		    if ( isMaximumIsAutomatic() )
		    {
		    	setMax(dimension.getMax());
		    	setMaximumIsAutomatic(true);
		    }

		    graphics.setColor(getColor());
			int position = axis.getPosition();
    	    int v1 = dimension.convertToGraphicsCoordonateSystem( getMin() );
		    int v2 = dimension.convertToGraphicsCoordonateSystem( getMax() );
			
			if ( ((Dimension) axis.getParent()).getOrientation() == Dimension.ORIENTATION_X )
			{
				if ( position == Axis.LOWER_BOUND )
				{
					int y = (int) graphics.getClipBounds().getHeight() - 1;
				    graphics.drawLine( v1, y, v2, y );
				}
				else if ( position == Axis.UPPER_BOUND )
				{
				    graphics.drawLine( v1, 0, v2, 0 );
				}
				else
				{
				    int y = dimension.getSiblingDimension().convertToGraphicsCoordonateSystem( 0 );
				    graphics.drawLine( v1, y, v2, y );
				}
			}
			else
			{
				if ( position == Axis.LOWER_BOUND )
				{
				    graphics.drawLine( 0, v1, 0, v2 );
				}
				else if ( position == Axis.UPPER_BOUND )
				{
					int x = (int) graphics.getClipBounds().getWidth() - 1;
				    graphics.drawLine( x, v1, x, v2 );
				}
				else
				{
				    int x = dimension.getSiblingDimension().convertToGraphicsCoordonateSystem( 0 );
				    graphics.drawLine( x, v1, x, v2 );
				}
			}

			getArrow().draw( graduationGraphics, graphics );
		}
    }

	public String toString()
	{
		return "Line";
	}
}

