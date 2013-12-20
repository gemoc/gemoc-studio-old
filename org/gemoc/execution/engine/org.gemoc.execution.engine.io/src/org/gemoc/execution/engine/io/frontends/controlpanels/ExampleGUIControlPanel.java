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
		ActionListener listenerRunOneStep = new ButtonHandlerRunOneStep();
		runOneStepButton.addActionListener(listenerRunOneStep);

		JButton resetButton = new JButton("Reset");
		ActionListener listenerReset = new ButtonHandlerReset();
		resetButton.addActionListener(listenerReset);

		JButton pauseButton = new JButton("Pause");
		ActionListener listenerPause = new ButtonHandlerPause();
		resetButton.addActionListener(listenerPause);

		JButton stepBackButton = new JButton("Step back one step");
		ActionListener listenerStepBack = new ButtonHandlerStepBack();
		resetButton.addActionListener(listenerStepBack);

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
		window.setLocation(100, 100);
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
			} catch (UnsupportedOperationException e2) {
				JOptionPane.showMessageDialog(null,
						"Unsupported operation pause", "Error",
						JOptionPane.ERROR_MESSAGE);
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
			} catch (UnsupportedOperationException e2) {
				JOptionPane.showMessageDialog(null,
						"Unsupported operation stepBack", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
