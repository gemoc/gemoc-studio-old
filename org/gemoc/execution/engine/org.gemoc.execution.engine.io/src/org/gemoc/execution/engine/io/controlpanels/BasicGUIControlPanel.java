package org.gemoc.execution.engine.io.controlpanels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;

import org.gemoc.execution.engine.io.ControlPanel;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicGUIControlPanel implements ControlPanel {

	private ExecutionEngine engine;

	public BasicGUIControlPanel() {

	}

	private class ButtonHandlerRunOneStep implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BasicGUIControlPanel.this.engine.run(1);
		}
	}

	private class ButtonHandlerReset implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BasicGUIControlPanel.this.engine.reset();
		}
	}

	private class ButtonHandlerEvent implements ActionListener {
		private ModelSpecificEvent mse;

		public ButtonHandlerEvent(ModelSpecificEvent mse) {
			this.mse = mse;
		}

		public void actionPerformed(ActionEvent e) {
			BasicGUIControlPanel.this.engine.runOneStep(mse);
		}
	}

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
		content.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);

		JFrame window = new JFrame("GEMOC Execution Engine Control Panel");
		window.setContentPane(content);
		window.setSize(500, 200);
		window.setLocation(100, 100);
		window.setVisible(true);

	}

}
