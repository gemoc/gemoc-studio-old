package org.gemoc.execution.engine.io.frontends.controlpanels;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.gemoc.execution.engine.io.core.impl.BasicControlPanel;
import org.gemoc.execution.engine.io.exceptions.ImpossibleCommandException;
import org.gemoc.gemoc_language_workbench.api.Activator;

/**
 * A basic example of a GUI implementing ControlPanel and giving order to the
 * Execution Engine...
 * 
 * @author flatombe
 * 
 */
public class ExampleGUIControlPanel extends BasicControlPanel {

	public ExampleGUIControlPanel() {
		JButton runOneStepButton = new JButton("Run one step");
		runOneStepButton.addActionListener(new ButtonHandlerRunOneStep());

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ButtonHandlerReset());

		JButton pauseButton = new JButton("Pause");
		resetButton.addActionListener(new ButtonHandlerPause());

		JButton stepBackButton = new JButton("Step back one step");
		resetButton.addActionListener(new ButtonHandlerStepBack());

		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(runOneStepButton);
		content.add(resetButton);
		content.add(pauseButton);
		content.add(stepBackButton);
		content.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		JFrame window = new JFrame("GEMOC Execution Engine Control Panel");
		window.setContentPane(content);
		window.setSize(500, 200);
		window.setLocation(0, 0);
		window.setVisible(true);
	}

	/**
	 * ActionListener which launches one full step of execution from the engine.
	 * 
	 * @author flatombe
	 * 
	 */
	private class ButtonHandlerRunOneStep implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				ExampleGUIControlPanel.this.run(1);
			} catch (ImpossibleCommandException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Activator.error(e1.getClass().getSimpleName() + " in "
						+ this.getClass().getSimpleName(), e1);
			}
		}
	}

	/**
	 * ActionListener for resetting the engine.
	 * 
	 * @author flatombe
	 * 
	 */
	private class ButtonHandlerReset implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				ExampleGUIControlPanel.this.reset();
			} catch (ImpossibleCommandException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Activator.error(e1.getClass().getSimpleName() + " in "
						+ this.getClass().getSimpleName(), e1);
			}
		}
	}

	private class ButtonHandlerPause implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				ExampleGUIControlPanel.this.pause();
			} catch (ImpossibleCommandException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Activator.error(e1.getClass().getSimpleName() + " in "
						+ this.getClass().getSimpleName(), e1);
			} catch (UnsupportedOperationException e2) {
				JOptionPane.showMessageDialog(null,
						"Unsupported operation pause", "Error",
						JOptionPane.ERROR_MESSAGE);
				Activator.error(e2.getClass().getSimpleName() + " in "
						+ this.getClass().getSimpleName(), e2);
			}
		}
	}

	private class ButtonHandlerStepBack implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				ExampleGUIControlPanel.this.stepBack(1);
			} catch (ImpossibleCommandException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Activator.error(e1.getClass().getSimpleName() + " in "
						+ this.getClass().getSimpleName(), e1);
			} catch (UnsupportedOperationException e2) {
				JOptionPane.showMessageDialog(null,
						"Unsupported operation stepBack", "Error",
						JOptionPane.ERROR_MESSAGE);

				Activator.error(e2.getClass().getSimpleName() + " in "
						+ this.getClass().getSimpleName(), e2);
			}
		}
	}

}
