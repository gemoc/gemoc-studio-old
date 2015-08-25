/*
 * Created on Mar 23, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cnrs.luchogie.up.system.Arrow;

/**
 * @author luc.hogie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ArrowEditor extends Editor
{
	private JSlider widthSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
	private JSlider lenghtSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 10);

	public ArrowEditor()
	{
		{
			widthSlider.setMajorTickSpacing(10);
			widthSlider.setMinorTickSpacing(1);
			widthSlider.setPaintLabels(true);
			widthSlider.setPaintTicks(true);
			widthSlider.setPaintTrack(true);
		}

		{
			lenghtSlider.setMajorTickSpacing(10);
			lenghtSlider.setMinorTickSpacing(1);
			lenghtSlider.setPaintLabels(true);
			lenghtSlider.setPaintTicks(true);
			lenghtSlider.setPaintTrack(true);
		}

		setLayout(new GridLayout(2, 2));
		add(new JLabel("Width"));
		add(widthSlider);
		add(new JLabel("Lenght"));
		add(lenghtSlider);


		widthSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				((Arrow) getObject()).setWidth(widthSlider.getValue());
				updatePlotter();
			}
		});

		lenghtSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				((Arrow) getObject()).setLength(lenghtSlider.getValue());
				updatePlotter();
			}
		});
	}
	
	public void setObject(Object object)
	{
		Arrow arrow = (Arrow) object;
		super.setObject(object);
		widthSlider.setValue(arrow.getWidth());
	}
	
	public String toString()
	{
		return "Arrow";
	}
}
