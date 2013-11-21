package org.gemoc.execution.engine.io.controlpanels;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.gemoc.execution.engine.io.ControlPanel;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicGUIControlPanel implements ControlPanel {

	private ExecutionEngine engine;

	public BasicGUIControlPanel() {

	}

	private class HelloWorldDisplay extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(
					"Press the buttons below to control the execution of \n"
							+ BasicGUIControlPanel.this.engine.toString(), 20,
					30);
		}
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BasicGUIControlPanel.this.engine.run(1);
		}
	}

	@Override
	public void initialize(ExecutionEngine engine) {
		this.engine = engine;

		HelloWorldDisplay displayPanel = new HelloWorldDisplay();
		JButton okButton = new JButton("run one step");
		ButtonHandler listener = new ButtonHandler();
		okButton.addActionListener(listener);

		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(displayPanel, BorderLayout.CENTER);
		content.add(okButton, BorderLayout.SOUTH);

		JFrame window = new JFrame("GEMOC Execution Engine Control Panel");
		window.setContentPane(content);
		window.setSize(250, 100);
		window.setLocation(100, 100);
		window.setVisible(true);

	}

}
