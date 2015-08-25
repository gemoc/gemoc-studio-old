package cnrs.luchogie.up.system;

import java.awt.Graphics2D;


/**
 *
 * <p>
 * There are 3 axis in a dimension.
 * <ul>
 * <li>The lower bound axis,
 * <li>the upper bound axis,
 * <li>the origin axis.
 * </ul>
 * </p>
 * 
 * <p>Because the orgin axis is not always visible (e.g. if the data
 * is defined in a strictly positive or stricty negative interval)
 * we have the need to show axis that are always visible and do not
 * depend on the location of the input data. The lower bound and
 * upper bound axis are drawn respectively on the lower and upper
 * bounds of the parent dimensions.
 * </p>
 * 
 * <p>An axis has an axis line that may or may not be drawn and a
 * graduation.
 * </p>
 * 
 * <p>On a dimension, each axis has its own line and graduation, which
 * allow a very powerful customization.
 * </p>
 *
 * @author Luc Hogie
 */
public class Axis extends SpaceElement
{
	private AxisLine line = null;
	private Graduation graduation = null;


	public final static int LOWER_BOUND = 0;
	public final static int ORIGIN = 1;
	public final static int UPPER_BOUND = 2;
	

	public Axis()
	{
	    setGraduation( new Graduation() );
	    setLine( new AxisLine() );
	}


	public Dimension getParentDimension()
	{
		return (Dimension) getParent();
	}


    /**
     * Returns the axis line for this axis.
     * @return AxisLine
     */
	public AxisLine getLine()
	{
		return line;
	}

    /**
     * Sets the axis line for this axis.
     * @param line the new line that will be used
     */
	public void setLine( AxisLine line )
	{
		if ( line == null )
			throw new IllegalArgumentException( "axis line cannot be set to null" );

		line.setParent( this );
		this.line = line;
	}


	/**
	 * Gets the graduation of the axis.
	 * @return Graduation
	 */
	public Graduation getGraduation()
	{
		return graduation;
	}

	/**
	 * Sets the graduation of the axis.
	 * @param graduation
	 */
	public void setGraduation( Graduation graduation )
	{
		if ( graduation == null )
			throw new IllegalArgumentException( "axis graduation cannot be set to null" );

		this.graduation = graduation;
		graduation.setParent( this );
	}

    /**
     * Returns the position of the axis in its parent dimension.
     * The position can take 3 possible values:
     * <ul>
     * <li>Axis.LOWER_BOUND
     * <li>Axis.UPPER_BOUND
     * <li>Axis.ORIGIN
     * </ul>
     * @return int
     */
	public int getPosition()
	{
		Dimension dimension = (Dimension) getParent();
		
		if ( this == dimension.getLowerBoundAxis() )
		{
			return LOWER_BOUND;
		}
		else if ( this == dimension.getOriginAxis() )
		{
			return ORIGIN;
		}
		else if ( this == dimension.getUpperBoundAxis() )
		{
			return UPPER_BOUND;
		}
		else
		{
			throw new IllegalStateException( "the axis does not belong to a dimension" );
		}
	}

	protected void draw( Graphics2D spaceGraphics, Graphics2D figureGraphics )
	{
		if ( isVisible() )
		{
		    getGraduation().draw( spaceGraphics, figureGraphics );
		    getLine().draw( spaceGraphics, figureGraphics );
		}
	}
	
    
    protected Axis[] getSiblingAxis()
    {
		Dimension dimension = (Dimension) getParent();

		if ( getPosition() == LOWER_BOUND )
		{
			return new Axis[] { dimension.getOriginAxis(), dimension.getUpperBoundAxis() };
		}
		else if ( getPosition() == ORIGIN )
		{
			return new Axis[] { dimension.getLowerBoundAxis(), dimension.getUpperBoundAxis() };
		}
		else
		{
			return new Axis[] { dimension.getLowerBoundAxis(), dimension.getOriginAxis() };
		}
    }

	public String toString()
	{
		String position;
		
		if ( getPosition() == LOWER_BOUND )
		{
			position = "lower bound axis";
		}
		else if ( getPosition() == UPPER_BOUND )
		{
			position = "upper bound axis";
		}
		else if ( getPosition() == ORIGIN )
		{
			position = "origin axis";
		}
		else
		{
			position = "axis";
		}
		
		return position;
	}
}
