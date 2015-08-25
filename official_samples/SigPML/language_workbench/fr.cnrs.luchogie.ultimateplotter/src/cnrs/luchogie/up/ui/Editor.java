/*
 * Created on Mar 23, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.ui;

import javax.swing.JPanel;

public class Editor extends JPanel
{
	private UI ui;
	private Object object;
		
	protected void updatePlotter()
	{
		ui.getPlotter().setUpdateNeeded(true);
		ui.getPlotter().repaint();
	}
	public UI getUpUI()
	{
		return ui;
	}

	public void setUpUI(UI ui)
	{
		this.ui = ui;
	}

	public Object getObject()
	{
		return object;
	}

	public void setObject(Object object)
	{
		this.object = object;
	}
}
