package org.gemoc.execution.engine.api_implementations.moc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.api_implementations.utils.TfsmModelLoader;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import tfsm.System;
import tfsm.TfsmClock;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;
import fr.inria.aoste.trace.TracePackage;

public class MockSolver implements Solver {

	private Resource modelOfExecutionResource = null;
	private Resource traceResource = null;
	private TraceFactory myFactory = null;
	private List<MockConstraint> constraints = null;
	private int timer = 0;

	@Override
	public void forbidEventOccurrenceReferencing(EObject target) {
		Activator.getMessagingSystem().info("TODO in MockSolver : forbid event occurrence referencing ...", Activator.PLUGIN_ID);
	}

	@Override
	public void forceEventOccurrenceReferencing(EObject target) {
		Activator.getMessagingSystem().info("TODO in MockSolver : force event occurrence referencing ...", Activator.PLUGIN_ID);
	}

	@Override
	public LogicalStep getNextStep() {
		Activator.getMessagingSystem().debug("Using MockSolver to retrieve a step", Activator.PLUGIN_ID);
		LogicalStep res = null;
		while (res == null & timer < 100) {
			for (MockConstraint constraint : this.constraints) {
				if (constraint.time == timer) {
					Activator.getMessagingSystem().debug("Returning constraint #" + constraint.time, Activator.PLUGIN_ID);
					
					EventOccurrence eventOccurrence = myFactory.createEventOccurrence();
					eventOccurrence.setFState(FiredStateKind.TICK);

					ModelElementReference targetReference = myFactory.createModelElementReference();
					targetReference.getElementRef().add(constraint.target);

					ModelElementReference operationReference = myFactory.createModelElementReference();
					operationReference.getElementRef().add(constraint.operation);

					eventOccurrence.setContext(targetReference);
					eventOccurrence.setReferedElement(operationReference);

					res = myFactory.createLogicalStep();
					res.getEventOccurrences().add(eventOccurrence);

				}
			}
			timer++;
		}
		return res;
	}

	private EOperation getEOperationFromName(EObject eo, String name) {
		for (EOperation operation : eo.eClass().getEAllOperations()) {
			if (operation.getName().equals(name)) {
				return operation;
			}
		}
		return null;
	}

	@Override
	public void setModelOfExecutionFile(URI modelOfExecutionURI) {
		Resource modelResource = new TfsmModelLoader()
				.loadModel("/org.gemoc.execution.engine.example/model/TrafficControl.tfsm");
		// Créer des contraintes ...
		System modelRoot = (System) modelResource.getContents().get(0);

		TfsmClock clock = (TfsmClock) modelRoot.getGlobalClocks().get(0);
		EOperation initialize = getEOperationFromName(clock, "initialize");
		EOperation tick = getEOperationFromName(clock, "tick");

		this.constraints = new ArrayList<MockConstraint>();
		this.constraints.add(new MockConstraint(clock, initialize, 0));
		this.constraints.add(new MockConstraint(clock, tick, 1));

//		// Créer la trace ...
//		TracePackage packageInstance = TracePackage.eINSTANCE;
//		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
//		Map<String, Object> m = reg.getExtensionToFactoryMap();
//		m.put("xmi", new XMIResourceFactoryImpl());
//		ResourceSet resSet = new ResourceSetImpl();
//
//		URI modelURI = URI.createURI("models/SimplePDLCreator_Created_Process.xmi");
//		traceResource = resSet.createResource(modelURI);

		// La fabrique pour fabriquer les Ã©lÃ©ments de SimplePDL
		this.myFactory = TraceFactory.eINSTANCE;

	}

	private class MockConstraint {
		private EObject target;
		private EOperation operation;
		private int time;

		public MockConstraint(EObject target, EOperation operation, int time) {
			this.target = target;
			this.operation = operation;
			this.time = time;
		}
	}

}
