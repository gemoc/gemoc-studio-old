/*
 * Created on Apr 30, 2004
 */
package cnrs.luchogie.up;

import java.util.Collection;


/**
 * @author luc.hogie
 */
public interface InteractiveSwingPlotterListener extends SwingPlotterListener
{
	void pointsSelected(SwingPlotter sp, Collection points);
}
