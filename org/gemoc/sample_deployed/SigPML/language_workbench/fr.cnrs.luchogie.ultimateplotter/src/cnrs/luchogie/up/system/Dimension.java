package cnrs.luchogie.up.system;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import cnrs.luchogie.up.data.Figure;


/**
 * <p>
 * This call models the mathematic concept of dimension:
 * a 2-dimensional space is constituted of 2 dimensions.
 * </p>
 * 
 * <p>
 * A dimension is itselft bounded because it may be graphically
 * represented on a different interval that its parent space.
 * </p>
 * 
 * @author Luc Hogie
 */
public class Dimension extends BoundedSpaceElement
{
	public static final int ORIENTATION_X = 1;
	public static final int ORIENTATION_Y = 2;

	private Legend legend;
	private Axis lowerBoundAxis;
	private Axis upperBoundAxis;
	private Axis originAxis;
	private double border = 0.1f;
	protected Grid grid;

	public Dimension()
	{
	    setLowerBoundAxis( new Axis() );
	    setUpperBoundAxis( new Axis() );
	    setOriginAxis( new Axis() );
	    setLegend( new Legend() );
	    setGrid(new Grid());
	}

	public Space getParentSpace()
	{
		return (Space) getParent();
	}



	/**
	 * Gets the grid of the graduation.
	 * @return Grid
	 */
	public Grid getGrid()
	{
		return grid;
	}

	/**
	 * Sets the grid of the graduation.
	 * @param newGrid
	 */
	public void setGrid( Grid newGrid )
	{
		if ( newGrid == null )
			throw new IllegalArgumentException( "the grid cannot be set to null" );

		this.grid = newGrid;
		this.grid.setParent( this );
	}


	/**
	 * Gets the lower bounds axis of the dimension
	 * @return Axis
	 */
	public Axis getLowerBoundAxis()
	{
		return lowerBoundAxis;
	}

	/**
	 * Sets the lower bounds axis of the dimension.
	 * @param axis
	 */
	public void setLowerBoundAxis( Axis axis )
	{
		if ( axis == null )
			throw new IllegalArgumentException( "axis cannot be set to null" );

		this.lowerBoundAxis = axis;
		axis.setParent( this );
	}

	/**
	 * Gets the upper bounds axis of the dimension
	 * @return Axis
	 */
	public Axis getUpperBoundAxis()
	{
		return upperBoundAxis;
	}

	/**
	 * Sets the upper bounds axis of the dimension.
	 * @param axis
	 */
	public void setUpperBoundAxis( Axis axis )
	{
		if ( axis == null )
			throw new IllegalArgumentException( "axis cannot be set to null" );

		this.upperBoundAxis = axis;
		axis.setParent( this );
	}

	/**
	 * Gets the origin axis of the dimension
	 * @return Axis
	 */
	public Axis getOriginAxis()
	{
		return originAxis;
	}

	/**
	 * Sets the origin axis of the dimension.
	 * @param axis
	 */
	public void setOriginAxis( Axis axis )
	{
		if ( axis == null )
			throw new IllegalArgumentException( "axis cannot be set to null" );

		this.originAxis = axis;
		axis.setParent( this );
	}

	/**
	 * Returns the border.
	 * @return float
	 */
	public double getBorder()
	{
		return border;
	}

	/**
	 * Sets the border. 
	 * @param border The border to set
	 */
	public void setBorder(double border)
	{
		this.border = border;
	}


	/**
	 * Gets the legend of the dimension. This explains what is
	 * the dimension used for.
	 * @return Legend
	 */
	public Legend getLegend()
	{
		return legend;
	}

	/**
	 * Sets the legend of the dimension. This explains what is
	 * the dimension used for.
	 * @param newLegend
	 */
	public void setLegend( Legend newLegend )
	{
		if ( newLegend == null )
			throw new IllegalArgumentException( "axis legend cannot be set to null" );

		this.legend = newLegend;
		legend.setParent(this);
	}

	/**
	 * Gets the orientation of the dimension. The dimension
	 * is <code>X</code> or <code>Y</code>.
	 * @return int
	 */
	public int getOrientation()
	{
		Space scale = (Space) getParent();

		if ( this == scale.getXDimension() )
		{
			return ORIENTATION_X;
		}
		else if ( this == scale.getYDimension() )
		{
			return ORIENTATION_Y;
		}
		else
		{
			throw new IllegalStateException( "parent dimension does not belong to a scale" );
		}
	}

	protected void draw( Graphics2D spaceGraphics, Graphics2D figureGraphics )
	{
		if ( isVisible() )
		{
			getLowerBoundAxis().draw(spaceGraphics, figureGraphics);
			getOriginAxis().draw(spaceGraphics, figureGraphics);
			getUpperBoundAxis().draw(spaceGraphics, figureGraphics);
		}
	}
	
    public void updateBounds( Figure figure )
    {
    	Figure.Extremi extremi = figure.getExtremums();

    	if ( isMinimumIsAutomatic() )
	    {
			if ( extremi == null )
			{
				setMin(-10);
			}
			else
			{
				if ( getOrientation() == ORIENTATION_X )
				{
					setMin(extremi.minX);
				}
				else
				{
					setMin(extremi.minY);
				}
			}
			
			setMinimumIsAutomatic(true);
	    }
   
    	if ( isMaximumIsAutomatic() )
	    {
			if ( extremi == null )
			{
				setMax(10);
			}
			else
			{
				if ( getOrientation() == ORIENTATION_X )
				{
					setMax(extremi.maxX);
				}
				else
				{
					setMax(extremi.maxY);
				}
			}

			setMaximumIsAutomatic(true);
	    }

    	if (isMinimumIsAutomatic() && isMaximumIsAutomatic())
    	{
        	if ( getMin() == getMax() )
    		{
    			setBounds( getMin() - 1, getMax() + 1 );
    		}
    		else
    		{
    			double range = getMax() - getMin();
    			setBounds(getMin() - range * border, getMax() + range * border );
    		}

			setMinimumIsAutomatic(true);
			setMaximumIsAutomatic(true);
    	}
    }
    
    
	/**
	 * Returns the number of pixel used by the dimension on the given graphics.
	 * @param graphics
	 * @return int
	 */
    public int getGraphicsSize(Graphics graphics)
    {
		Rectangle bounds = graphics.getClipBounds();

		if ( getOrientation() == ORIENTATION_X )
		{
			return (int) bounds.getWidth();
		}
		else
		{
			return (int) bounds.getHeight();
		}
    }
    
    protected Dimension getSiblingDimension()
    {
		Space space = (Space) getParent();

		if ( getOrientation() == ORIENTATION_X )
		{
			return space.getYDimension();
		}
		else
		{
			return space.getXDimension();
		}
    }

    
	public int convertToGraphicsCoordonateSystem( double value )
	{
	    Space space = (Space) getParent();
		int graphicsSize = getGraphicsSize(space.getFigureGraphics());

		if ( value == getMin() )
		{
			return getOrientation() == ORIENTATION_X ? 0 : graphicsSize - 1;
		}

		if ( value == getMax() )
		{
			return getOrientation() == ORIENTATION_X ? graphicsSize - 1 : 0;
		}

	    double range = getMax() - getMin();
	    double factor = graphicsSize / range;
	    int valueOnGraphics = (int) (getOrientation() == ORIENTATION_X
	    	? factor * value + space.getOriginPoint().getX()
	    	: -factor * value + space.getOriginPoint().getY());

	    return valueOnGraphics;
    }

	public double convertToDimensionCoordonateSystem(int a)
	{
		double aa = a;
		Space space = (Space) getParent();
		double graphicsSize = getGraphicsSize(space.getFigureGraphics());

		double range = getMax() - getMin();
		double factor = graphicsSize / range;
		double valueOnDimension = (int) getOrientation() == ORIENTATION_X
			? (aa - space.getOriginPoint().getX()) / factor
			: (aa - space.getOriginPoint().getY()) / -factor;

		return valueOnDimension;
	}

	public double getLogicalIntervalRepresentedByOnePixel()
	{
		double logicalRange = getMax() - getMin();
		double graphicsSize = getGraphicsSize(getParentSpace().getFigureGraphics());
		return logicalRange / graphicsSize;
	}


	public String toString()
	{
		String orientation = getOrientation() == ORIENTATION_X ? "horizontal" : "vertical";
		return orientation + " dimension";
	}
}
