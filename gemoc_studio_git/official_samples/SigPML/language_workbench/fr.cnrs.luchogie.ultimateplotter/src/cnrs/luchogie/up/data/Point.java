package cnrs.luchogie.up.data;

import java.util.Collection;
import java.util.Iterator;

import cnrs.luchogie.up.data.event.PointListener;

/**
 * <p>
 * The point is the basic data entity that is drawn on the graphics. A point is
 * 2-dimensional.
 * </p>
 * 
 * <p>
 * Points are always contained in a figure. It is not possible to display a
 * point that would't be contained in a figure. If you have a single point to
 * display, you have a create a figure that will contain this point and display
 * this figure.
 * </p>
 * 
 * <p>
 * Points are not defined as subclass of figure for efficiency reasons. Figure
 * have subfigures and subpoints thus they handle a private data structures for
 * storing these elements. Points do not have subpoints or subfigure thus they
 * do not need these data structure. if Point were a subclass of Figure, it
 * would inherit the data structure without never using them. That would be a
 * great waste a memory space. As point may be extremely numerous, the Point
 * class has to be as lightweight as possible.
 * </p>
 * 
 * @author Luc Hogie
 * 
 */
public class Point extends DataElement implements toools.math.Point
{
	private static final Point ORIGIN = new Point(0, 0);

	private double x, y;

	public Point()
	{
		this(0, 0);
	}

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public Object clone()
	{
		Point point = new Point(getX(), getY());
		int rendererCount = getRendererCount();

		for (int i = 0; i < rendererCount; ++i)
		{
			point.addRenderer(getRendererAt(i));
		}

		return point;
	}

	public void setX(double x)
	{
		if (x != this.x)
		{
			double oldX = this.x;
			this.x = x;

			if (getListeners() != null)
			{
				fireXChanged(this, oldX, x);
			}
		}
	}

	public void setY(double y)
	{

		if (y != this.y)
		{
			double oldY = this.y;
			this.y = y;

			if (getListeners() != null)
			{
				fireYChanged(this, oldY, y);
			}
		}
	}

	public void setXY(double x, double y)
	{
		setX(x);
		setY(y);
	}

	private void fireXChanged(Point point, double oldX, double newX)
	{
		Collection listeners = getListeners();

		if (listeners != null)
		{
			Iterator i = listeners.iterator();

			while (i.hasNext())
			{
				((PointListener) i.next()).xChanged(point, oldX, newX);
			}
		}
	}

	private void fireYChanged(Point point, double oldY, double newY)
	{
		Collection listeners = getListeners();

		if (listeners != null)
		{
			Iterator i = listeners.iterator();

			while (i.hasNext())
			{
				((PointListener) i.next()).yChanged(point, oldY, newY);
			}
		}
	}

	public void translate(double x, double y)
	{
		setXY(getX() + x, getY() + y);
	}

	public void rotate(double angle, Point ref)
	{
		double dx = x - ref.x;
		double dy = y - ref.y;
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		setXY(dx * cos - dy * sin + ref.x, dx * sin + dy * cos + ref.y);
	}

	public void rotate(double angle)
	{
		rotate(angle, ORIGIN);
	}

	public double getDistanceTo(Point p)
	{
		double dx = x - p.getX();
		double dy = y - p.getY();
		return Math.sqrt(dx * dx + dy * dy);
	}

	public String toString()
	{
		return "cartesian coordinates = " + toStringCartesian() + ", polar coordinates = " + toStringPolar();
	}

	public String toStringCartesian()
	{
		return "(" + x + ", " + y + ")";
	}

	public String toStringPolar()
	{
		return "(" + getDistanceToOrigin() + ", " + getAngle() + "�)";
	}

	public double getDistanceToOrigin()
	{
		return Math.sqrt(x * x + y * y);
	}

	public double getAngle()
	{
		return Math.atan2(y, x);
	}

	public void setDistanceToOrigin(double newd)
	{
		if (newd < 0)
			throw new IllegalArgumentException("distance can't be negative: " + newd);

		double ratio = newd / getDistanceToOrigin();
		setXY(x * ratio, y * ratio);
	}

	public void setAngle(double newAngle)
	{
		rotate(newAngle - getAngle());
	}

	public static void main(String[] args)
	{
		Point p = new Point(1, 1);
		System.out.println(p);
		p.setDistanceToOrigin(2.5);
		System.out.println(p);
		System.out.println(p);
		p.setAngle(Math.PI);
		System.out.println(p);
	}

	@Override
	public boolean equals(Object obj)
	{
		Point p = (Point) obj;
		return p.x == x && p.y == y;
	}

	@Override
	public int hashCode()
	{
		return (x + ":" + y).hashCode();
	}
}
