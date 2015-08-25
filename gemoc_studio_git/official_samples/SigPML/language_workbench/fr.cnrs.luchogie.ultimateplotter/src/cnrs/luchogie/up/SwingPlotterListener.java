/*
 * Created on Feb 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up;

import cnrs.luchogie.up.data.Point;


/**
 * @author luc.hogie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface SwingPlotterListener
{
	void paintStarting(SwingPlotter sp);
	void paintFinished(SwingPlotter sp);
}
