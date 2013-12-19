package org.gemoc.execution.engine.io.frontends.scenariobuilders;

import glml.DomainSpecificEvent;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.io.core.impl.BasicScenarioBuilder;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventInjectionException;

public class ExampleScenarioBuilder extends BasicScenarioBuilder {

	private JPanel content;
	private JFrame window;

	private DomainSpecificEvent selectedEvent;
	private EObject selectedTarget;

	private JLabel eventLabel;
	private JLabel targetLabel;

	/**
	 * Creates the base of the GUI.
	 */
	public ExampleScenarioBuilder() {
		this.selectedEvent = null;
		this.selectedTarget = null;

		this.content = new JPanel();
		JButton injectButton = new JButton("Inject event");
		injectButton.addActionListener(new ButtonHandlerInject());

		this.eventLabel = new JLabel("Selected DSE: ");
		this.targetLabel = new JLabel("Selected model element: ");

		this.content.add(eventLabel);
		this.content.add(targetLabel);
		this.content.add(injectButton);
		this.content.setLayout(new FlowLayout());
		this.content
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		this.window = new JFrame("GEMOC Execution Engine Scenario Builder");
		this.window.setContentPane(this.content);
		this.window.setSize(500, 200);
		this.window.setLocation(100, 100);
		this.window.setVisible(true);
	}

	private String getSelectedEventText() {
		if (this.selectedEvent == null) {
			return "";
		} else {
			return this.selectedEvent.getName();
		}
	}

	private String getSelectedTargetText() {
		if (this.selectedTarget == null) {
			return "";
		} else {
			return this.selectedTarget.toString();
		}
	}

	private void repaint() {
		this.window.repaint();
		this.eventLabel.setText("Selected DSE: " + this.getSelectedEventText());
		this.targetLabel.setText("Selected model element: "
				+ this.getSelectedTargetText());
	}

	@Override
	public void initialize(ExecutionEngine engine) {
		this.engine = engine;
		this.addEventButtons(this.engine.getDomainSpecificEvents());
		this.addModelButtons(this.engine.getModelResource());
	}

	public void addEventButtons(Collection<DomainSpecificEvent> events) {
		for (DomainSpecificEvent dse : events) {
			JButton eventButton = new JButton(dse.getName());
			ActionListener listenerEvent = new ButtonHandlerEvent(dse);
			eventButton.addActionListener(listenerEvent);
			this.content.add(eventButton);
		}
	}

	public void addModelButtons(Resource modelResource) {
		for (EObject eo : modelResource.getContents().get(0).eContents()) {
			JButton eobjectButton = new JButton(eo.toString());
			ActionListener listener = new ButtonHandlerEObject(eo);
			eobjectButton.addActionListener(listener);
			this.content.add(eobjectButton);
		}
	}

	private class ButtonHandlerInject implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (ExampleScenarioBuilder.this.selectedEvent == null
					|| ExampleScenarioBuilder.this.selectedTarget == null) {
				JOptionPane
						.showMessageDialog(
								null,
								"Please select a Domain-Specific Event and an element from the model.",
								"Information", JOptionPane.INFORMATION_MESSAGE);
			} else {
				try {
					ExampleScenarioBuilder.this.injectEvent(
							ExampleScenarioBuilder.this.selectedEvent,
							ExampleScenarioBuilder.this.selectedTarget);
					ExampleScenarioBuilder.this.selectedEvent = null;
					ExampleScenarioBuilder.this.selectedTarget = null;
				} catch (UnsupportedOperationException e2) {
					JOptionPane.showMessageDialog(null,
							"Unsupported operation stepBack", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (EventInjectionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private class ButtonHandlerEObject implements ActionListener {
		private EObject eo;

		public ButtonHandlerEObject(EObject eo) {
			this.eo = eo;
		}

		public void actionPerformed(ActionEvent e) {
			ExampleScenarioBuilder.this.selectedTarget = eo;
			ExampleScenarioBuilder.this.repaint();
		}
	}

	/**
	 * ActionListener for triggering a particular ModelSpecificEvent.
	 * 
	 * @author flatombe
	 * 
	 */
	private class ButtonHandlerEvent implements ActionListener {
		private DomainSpecificEvent dse;

		public ButtonHandlerEvent(DomainSpecificEvent dse) {
			this.dse = dse;
		}

		public void actionPerformed(ActionEvent e) {
			ExampleScenarioBuilder.this.selectedEvent = dse;
			ExampleScenarioBuilder.this.repaint();
		}
	}
}
