package cnrs.luchogie.up.data.rendering.point;

import cnrs.luchogie.up.data.*;
import cnrs.luchogie.up.system.*;

/**
 * @author Administrateur
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class CoordinatePointRenderer extends TextPointRenderer
{
	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		Point point = (Point) object;
		setText( "(" + point.getX() + ", " + point.getY() + ")" );
		setXShift(0);
		setYShift(10);
		super.drawImpl(object, space);
	}
}
