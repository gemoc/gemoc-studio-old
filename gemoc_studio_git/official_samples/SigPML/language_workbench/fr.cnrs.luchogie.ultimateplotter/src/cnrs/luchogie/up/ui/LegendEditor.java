/*
 * Created on Mar 23, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.ui;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cnrs.luchogie.up.system.Legend;


public class LegendEditor extends Editor
{
	private JTextField textField = new JTextField(20);
	private JList fontList = new JList();

	public LegendEditor()
	{
		setLayout(new GridLayout(1, 1));
		add(new JLabel("Text:"));
		add(textField);

		textField.getDocument().addDocumentListener(new DocumentListener()
		{
			public void changedUpdate(DocumentEvent arg0)
			{
				((Legend) getObject()).setText(textField.getText());
				updatePlotter();			
			}

			public void insertUpdate(DocumentEvent arg0)
			{
				((Legend) getObject()).setText(textField.getText());
				updatePlotter();			
			}

			public void removeUpdate(DocumentEvent arg0)
			{
				((Legend) getObject()).setText(textField.getText());
				updatePlotter();			
			}
		});
		
		fontList.setListData(Toolkit.getDefaultToolkit().getFontList());
	}
	
	public void setObject(Object object)
	{
		Legend arrow = (Legend) object;
		super.setObject(object);
		textField.setText(arrow.getText());
	}
	
	public String toString()
	{
		return "Legend";
	}
}
