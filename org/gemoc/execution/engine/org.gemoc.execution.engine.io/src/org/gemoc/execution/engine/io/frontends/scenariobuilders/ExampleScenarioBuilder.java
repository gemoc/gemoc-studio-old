package org.gemoc.execution.engine.io.frontends.scenariobuilders;

import glml.DomainSpecificEvent;
import glml.ModelSpecificEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.io.core.impl.BasicScenarioBuilder;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventInjectionException;

public class ExampleScenarioBuilder extends BasicScenarioBuilder {

	private JPanel content;
	private JFrame window;

	private DomainSpecificEvent selectedEvent;
	private EObject 	selectedTarget;
	

	protected JPanel 	actionPanel;
	protected JPanel 	dsePanel;
	protected JPanel 	modelElementPanel;
	protected JPanel	possibleEventsPanel;

	private JLabel 		eventLabel;
	private JLabel 		targetLabel;

	private Collection<ModelSpecificEvent> possibleEvents;
	private Collection<JLabel> possibleEventsLabels;

	/**
	 * Creates the base of the GUI.
	 */
	public ExampleScenarioBuilder() {
		this.selectedEvent = null;
		this.selectedTarget = null;

		this.content = new JPanel();
		this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
		//this.content.setLayout(new FlowLayout());
		
		//-----------------------------------------------
		actionPanel = new JPanel();
		actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.X_AXIS));
		
		JPanel actionPanelLeft = new JPanel();
		actionPanelLeft.setLayout(new BoxLayout(actionPanelLeft, BoxLayout.Y_AXIS));		
		this.eventLabel = new JLabel("Selected DSE: ");
		actionPanelLeft.add(eventLabel);
		this.targetLabel = new JLabel("Selected model element: ");
		actionPanelLeft.add(targetLabel);
		actionPanel.add(actionPanelLeft);
		
		JPanel actionPanelRight = new JPanel();	
		actionPanelRight.setLayout(new BoxLayout(actionPanelRight, BoxLayout.Y_AXIS));
		actionPanel.add(actionPanelRight);	
		
		JButton injectButton = new JButton("Inject event");
		injectButton.addActionListener(new ButtonHandlerInject());
		actionPanelRight.add(injectButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ButtonHandlerClear());
		actionPanelRight.add(clearButton);
		
		this.content.add(actionPanel);
		
		// -----------------------------------------------
		
		//mainPanel.setSize(new Dimension(this.content.getWidth(), this.content.getHeight() -actionPanel.getHeight()));
		
		// -----------------------------------------------	
		dsePanel = new JPanel();
		dsePanel.setLayout(new BoxLayout(dsePanel, BoxLayout.Y_AXIS));
		JScrollPane dseScrollPane = new JScrollPane(dsePanel);
		dseScrollPane.setBorder(BorderFactory.createTitledBorder("Choose DSE"));
		//mainPanel.add(dseScrollPane);
		
		// -----------------------------------------------	
		modelElementPanel = new JPanel();
		modelElementPanel.setLayout(new BoxLayout(modelElementPanel, BoxLayout.Y_AXIS));
		JScrollPane modelElementScrollPane = new JScrollPane(modelElementPanel);
		modelElementScrollPane.setBorder(BorderFactory.createTitledBorder("Choose Model Element"));
		//mainPanel.add(modelElementScrollPane);
		
		// -----------------------------------------------	
		possibleEventsPanel = new JPanel();
		possibleEventsPanel.setLayout(new BoxLayout(possibleEventsPanel, BoxLayout.Y_AXIS));
		//possibleEventsPanel.add(new JLabel("Possible MSEs at this time: "));
		JScrollPane possibleEventsScrollPane = new JScrollPane(possibleEventsPanel);
		possibleEventsScrollPane.setBorder(BorderFactory.createTitledBorder("Possible MSEs at this time:"));
		//mainPanel.add(possibleEventsScrollPane);
		
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				dseScrollPane, modelElementScrollPane);
		splitPane1.setDividerLocation(250);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				splitPane1, possibleEventsScrollPane);
		splitPane2.setDividerLocation(400);
		
		JScrollPane mainPanel = new JScrollPane(splitPane2);
		
		this.content.add(mainPanel);
		
		this.window = new JFrame("GEMOC Execution Engine Scenario Builder");
		this.window.setContentPane(this.content);
		this.window.setSize(700, 600);
		this.window.setLocation(0, 100);
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

	private void validate() {
		this.eventLabel.setText("Selected DSE: " + this.getSelectedEventText());
		this.targetLabel.setText("Selected model element: "
				+ this.getSelectedTargetText());

		this.possibleEvents = this.engine.getCurrentPossibleEvents();
		for (JLabel label : this.possibleEventsLabels) {
			possibleEventsPanel.remove(label);
		}
		this.possibleEventsLabels.clear();
		this.setAndAddPossibleEventsLabels();
		this.window.validate();
	}

	private void setAndAddPossibleEventsLabels() {
		for (ModelSpecificEvent mse : this.possibleEvents) {
			JLabel label = new JLabel(mse.getName());
			possibleEventsPanel.add(label);
			this.possibleEventsLabels.add(label);
		}
	}

	@Override
	public void initialize(ExecutionEngine engine) {
		this.engine = engine;
		this.addEventButtons(this.engine.getDomainSpecificEvents());
		//this.content.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.addModelButtons(this.engine.getModelResource());
		//this.content.add(new JSeparator(SwingConstants.HORIZONTAL));
		//this.content.add(new JLabel("Possible MSEs at this time: "));
		this.possibleEventsLabels = new ArrayList<JLabel>();
		this.possibleEvents = null;
		this.validate();
	}

	public void addEventButtons(Collection<DomainSpecificEvent> events) {
		for (DomainSpecificEvent dse : events) {
			JButton eventButton = new JButton(dse.getName());
			ActionListener listenerEvent = new ButtonHandlerEvent(dse);
			eventButton.addActionListener(listenerEvent);
			eventButton.setOpaque(true);
			eventButton.setBackground(Color.CYAN);
			dsePanel.add(eventButton);
		}
	}

	public void addModelButtons(Resource modelResource) {
		Iterator<EObject> it = modelResource.getAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();
			JButton eobjectButton = new JButton(eo.toString());
			ActionListener listener = new ButtonHandlerEObject(eo);
			eobjectButton.addActionListener(listener);
			eobjectButton.setOpaque(true);
			eobjectButton.setBackground(Color.MAGENTA);
			modelElementPanel.add(eobjectButton);
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
					ExampleScenarioBuilder.this.validate();
				} catch (UnsupportedOperationException e2) {
					JOptionPane.showMessageDialog(null,
							"Unsupported operation injection", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (EventInjectionException e1) {
					JOptionPane.showMessageDialog(
							null,
							"Exception during the injection of the event:"
									+ e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (Throwable e3) {
					JOptionPane.showMessageDialog(
							null,
							"Exception during the injection of the event:"
									+ e3.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private class ButtonHandlerClear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ExampleScenarioBuilder.this.selectedTarget = null;
			ExampleScenarioBuilder.this.selectedEvent = null;
			ExampleScenarioBuilder.this.validate();
		}
	}

	private class ButtonHandlerEObject implements ActionListener {
		private EObject eo;

		public ButtonHandlerEObject(EObject eo) {
			this.eo = eo;
		}

		public void actionPerformed(ActionEvent e) {
			ExampleScenarioBuilder.this.selectedTarget = eo;
			ExampleScenarioBuilder.this.validate();
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
			ExampleScenarioBuilder.this.validate();
		}
	}
}
