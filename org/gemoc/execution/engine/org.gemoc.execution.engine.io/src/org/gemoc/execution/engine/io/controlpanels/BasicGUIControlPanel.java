package org.gemoc.execution.engine.io.controlpanels;

import glml.ModelSpecificEvent;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.gemoc.execution.engine.io.ControlPanel;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;

/**
 * A basic example of a GUI implementing ControlPanel and giving order to the
 * Execution Engine...
 * 
 * @author flatombe
 * 
 */
public class BasicGUIControlPanel implements ControlPanel {

	/**
	 * Filled in by the EngineManager at creation.
	 */
	private ExecutionEngine engine;

	public BasicGUIControlPanel() {

	}

	/**
	 * ActionListener which launches one full step of execution from the engine.
	 * 
	 * @author flatombe
	 * 
	 */
	private class ButtonHandlerRunOneStep implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BasicGUIControlPanel.this.engine.run(1);
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
			BasicGUIControlPanel.this.engine.reset();
		}
	}

	/**
	 * ActionListener for triggering a particular ModelSpecificEvent.
	 * 
	 * @author flatombe
	 * 
	 */
	private class ButtonHandlerEvent implements ActionListener {
		private ModelSpecificEvent mse;

		public ButtonHandlerEvent(ModelSpecificEvent mse) {
			this.mse = mse;
		}

		public void actionPerformed(ActionEvent e) {
			BasicGUIControlPanel.this.engine.runOneStep(mse);
		}
	}

	/**
	 * Building the buttons and laying them out... 1 button for "run one step" 1
	 * button for reset n button for the n possible ModelSpecificEvents.
	 */
	@Override
	public void initialize(ExecutionEngine engine) {
		this.engine = engine;

		JButton runOneStepButton = new JButton("run one step");
		ActionListener listenerRunOneStep = new ButtonHandlerRunOneStep();
		runOneStepButton.addActionListener(listenerRunOneStep);

		JButton resetButton = new JButton("reset");
		ActionListener listenerReset = new ButtonHandlerReset();
		resetButton.addActionListener(listenerReset);

		List<JButton> eventButtons = new ArrayList<JButton>();
		Collection<ModelSpecificEvent> events = this.engine.getNextEvents();
		for (ModelSpecificEvent mse : events) {
			JButton eventButton = new JButton(mse.getName());
			ActionListener listenerEvent = new ButtonHandlerEvent(mse);
			eventButton.addActionListener(listenerEvent);
			eventButtons.add(eventButton);
		}

		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		for (JButton eventButton : eventButtons) {
			content.add(eventButton);
		}
		content.add(runOneStepButton);
		content.add(resetButton);
		content.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		JFrame window = new JFrame("GEMOC Execution Engine Control Panel");
		window.setContentPane(content);
		window.setSize(500, 200);
		window.setLocation(100, 100);
		window.setVisible(true);

	}

}
