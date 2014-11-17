package cnrs.luchogie.up.data.event;


import cnrs.luchogie.up.data.Point;


/**
 * @author Luc Hogie
 */

public interface PointListener extends DataElementListener
{
	void xChanged( Point point, double oldX, double newX );
	void yChanged( Point point, double oldY, double newY );
}
