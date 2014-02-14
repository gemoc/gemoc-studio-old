package org.gemoc.execution.engine.commons.solvers.ccsl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS;
import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.gemoc_language_workbench.api.moc.SolverInputBuilder;

import fr.inria.aoste.timesquare.ECL.ECLDocument;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.timesquare.ccslkernel.solver.launch.CCSLKernelSolverWrapper;
import fr.inria.aoste.timesquare.simulationpolicy.maxcardpolicy.MaxCardSimulationPolicy;
import fr.inria.aoste.timesquare.trace.util.HelperFactory;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.NamedReference;
import fr.inria.aoste.trace.Reference;
import glml.ECLEvent;
import glml.GlmlFactory;
import glml.MocEvent;

/**
 * The interface of the CCSLKernelSolver as seen by the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public class CcslSolver implements
		org.gemoc.gemoc_language_workbench.api.moc.Solver {

	private CCSLKernelSolverWrapper solverWrapper = null;
	private URI solverInputURI = null;
	private SolverInputBuilder solverInputBuilder;
	private LogicalStep lastLogicalStep = null;
	private Map<Event, ModelElementReference> mappingEventToOriginalMer = null;

	public CcslSolver() {
		this.solverInputBuilder = new EclToCcslTranslator();
		this.mappingEventToOriginalMer = new HashMap<Event, ModelElementReference>();
	}

	public SolverInputBuilder getSolverInputBuilder() {
		return this.solverInputBuilder;
	}
	

	@Override
	public void forbidEventOccurrence(EventOccurrence eventOccurrence) {
		ModelElementReference clockToForce = HelperFactory
				.createModelElementReference(eventOccurrence
						.getReferedElement());
		this.solverWrapper.forceClockAbsence(clockToForce);
		// this.solverWrapper.forceClockAbsence(this.getClockLinkedToOccurrence(eventOccurrence));
	}

	@Override
	public void forceEventOccurrence(EventOccurrence eventOccurrence) {
		// ModelElementReference clockToForce = HelperFactory
		// .createModelElementReference(eventOccurrence.getReferedElement());
		Reference reference = eventOccurrence.getReferedElement();
		if (reference instanceof ModelElementReference) {
			ModelElementReference mer = (ModelElementReference) reference;

			Activator.getMessagingSystem().info(
					"Feedback: forcing clock presence of : \n" + "MER: "
							+ mer.toString() + "\n" + "ElementRef: "
							+ mer.getElementRef().get(0), Activator.PLUGIN_ID);
			
			ModelElementReference merToForce = this.mappingEventToOriginalMer.get(mer.getElementRef().get(0));
			Activator.getMessagingSystem().info("Retrieved mer from the map: " + merToForce.toString(), Activator.PLUGIN_ID);

			this.solverWrapper.forceClockPresence(merToForce);
			
			
		} else {
			throw new RuntimeException(
					"Refered Element of eventOccurrence should be a ModelElementReference");
		}

	}

	@Override
	public LogicalStep getNextStep() {
		try {
			LogicalStep res = this.solverWrapper.getSolver()
					.doOneSimulationStep();

			for (EventOccurrence eventOccurrence : res.getEventOccurrences()) {
				Clock c = this.getClockLinkedToOccurrence(eventOccurrence);
				if (c != null) {
					// OLD now GLML does the DSA-linking.
					/*
					 * EList<EObject> linkedObjects = c.getTickingEvent()
					 * .getReferencedObjectRefs(); if (linkedObjects.size() ==
					 * 2) {
					 */
					// OLD (for ECL). Removed because I'm testing with GLML.
					/*
					 * eventOccurrence.setContext(HelperFactory
					 * .createModelElementReference(linkedObjects .get(0)));
					 * eventOccurrence.setReferedElement(HelperFactory
					 * .createModelElementReference(linkedObjects .get(1)));
					 */
					// eventOccurrence
					// .setReferedElement(HelperFactory
					// .createNamedReference(c.getTickingEvent()
					// .getName()));
					Activator.getMessagingSystem().debug("Before the setting of the ref element :", Activator.PLUGIN_ID);
					ModelElementReference mer = (ModelElementReference) eventOccurrence.getReferedElement();
					Activator.getMessagingSystem().debug("- the MER : " + mer.toString(), Activator.PLUGIN_ID);
					Activator.getMessagingSystem().debug("- the list:" + mer.getElementRef().toString(), Activator.PLUGIN_ID);
					Activator.getMessagingSystem().debug("- clock? : " + (mer.getElementRef().get(mer.getElementRef().size()-1) instanceof Clock), Activator.PLUGIN_ID);
					
					mappingEventToOriginalMer.put(c.getTickingEvent(), (ModelElementReference) eventOccurrence.getReferedElement());
					
					eventOccurrence.setReferedElement(HelperFactory
							.createModelElementReference(c.getTickingEvent()));
					Activator.getMessagingSystem().debug(
							"MER of the eventOcc :"
									+ eventOccurrence.getReferedElement()
									+ "\nTicking event : "
									+ c.getTickingEvent().toString(),
							Activator.PLUGIN_ID);
					/* } */
				}
			}
			this.lastLogicalStep = res;
			return res;
		} catch (SolverException e) {
			String errorMessage = "SolverException while trying to get next Ccsl step";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
	}

	private Clock getClockLinkedToOccurrence(EventOccurrence eventOcc) {
		Reference ref = eventOcc.getReferedElement();
		if (ref instanceof ModelElementReference) {
			ModelElementReference mer = (ModelElementReference) ref;
			EList<EObject> eobjects = mer.getElementRef();
			EObject actualObject = eobjects.get(eobjects.size() - 1);
			if (actualObject instanceof Clock) {
				// you got the clock that ticked
				return (Clock) actualObject;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public String toString() {
		return this.getClass().getName() + "@[modelOfExecutionURI="
				+ this.solverInputURI + "]";
	}

	@Override
	public void setSolverInputFile(URI solverInputURI) {
		this.solverInputURI = solverInputURI;
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource ccslResource = resourceSet.getResource(
					this.solverInputURI, true);
			ccslResource.load(null);
			EcoreUtil.resolveAll(resourceSet);
			this.solverWrapper = new CCSLKernelSolverWrapper();
			this.solverWrapper.getSolver().loadModel(ccslResource);
			this.solverWrapper.getSolver().initSimulation();
			this.solverWrapper.getSolver().setPolicy(
					new MaxCardSimulationPolicy());
		} catch (IOException e) {
			String errorMessage = "IOException while instantiating the CcslSolver";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (UnfoldingException e) {
			String errorMessage = "UnfoldingException while instantiating the CcslSolver";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (SolverException e) {
			String errorMessage = "SolverException while instantiating the CcslSolver";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		}

	}

	@Override
	public EventOccurrence getCorrespondingEventOccurrence(MocEvent mocEvent,
			EObject target) {
		try {
			Activator
					.getMessagingSystem()
					.debug("Trying to find the instanciation of the following MoC Event for the following EObject : \n -"
							+ mocEvent.toString() + " \n -" + target.toString(),
							Activator.PLUGIN_ID);

			ECLEvent eclEvent = (ECLEvent) mocEvent;
			String eventName = eclEvent.getElement().getName();

			// String representation of the EObject :
			// "Klass@abc123 (att1: v1) (att2: v2)"
			String targetString = target.toString();
			// We get the list of attribute without ending and
			// parentheses : "att1: v1) (att2: v2"
			String stringOfAttributesList = targetString.substring(
					targetString.indexOf("(") + 1, targetString.length() - 1);
			// We split it to get ["att1: v1", "att2: v2"]
			List<String> listOfAttributes = Arrays
					.asList(stringOfAttributesList.split("\\) \\("));
			// We look for "name: xxx" in the array.
			String attributeName = "";
			for (String s : listOfAttributes) {
				if (s.startsWith("name: ")) {
					attributeName = s;
				}
			}
			String targetName = "";
			if (attributeName != "") {
				// Either we found "name: xxx" in which case we have
				// 'xxx'
				targetName = attributeName.substring(
						attributeName.indexOf("name: ") + "name: ".length(),
						attributeName.length());
			} else {
				// Or we throw exception (what to do?)
				throw new UnsupportedOperationException(
						"Somehow you need a 'name' attribute on your model elements...");
			}
			String eventOccurrenceName = "evt_" + targetName + "_" + eventName;

			Activator.getMessagingSystem().debug(
					"Looking for the clock named: " + eventOccurrenceName
							+ " among the following step :",
					Activator.PLUGIN_ID);
			Activator.getMessagingSystem().debug(
					this.lastLogicalStep.getEventOccurrences().toString(),
					Activator.PLUGIN_ID);

			for (EventOccurrence eventOccurrence : this.lastLogicalStep
					.getEventOccurrences()) {
				Activator.getMessagingSystem().debug(
						"reference : "
								+ eventOccurrence.getReferedElement()
										.toString(), Activator.PLUGIN_ID);
				if (eventOccurrence.getReferedElement() instanceof NamedReference) {
					NamedReference reference = (NamedReference) eventOccurrence
							.getReferedElement();
					if (reference.getValue().equals(eventOccurrenceName)) {
						Activator.getMessagingSystem().debug(
								"Returning: " + eventOccurrence.toString(),
								Activator.PLUGIN_ID);
						return eventOccurrence;
					}
				} else if (eventOccurrence.getReferedElement() instanceof ModelElementReference) {
					ModelElementReference reference = (ModelElementReference) eventOccurrence
							.getReferedElement();
					if (this.getValueOfStringAttribute(
							reference.getElementRef().get(0), "name").equals(
							eventOccurrenceName)) {
						Activator.getMessagingSystem().debug(
								"Returning: " + eventOccurrence.toString(),
								Activator.PLUGIN_ID);
						return eventOccurrence;
					}
				} else {
					throw new RuntimeException(
							"Context of EventOccurrence should be a NamedReference");
				}
			}
			throw new RuntimeException(
					"Couldn't find the instanciation of the MocEvent "
							+ mocEvent.toString() + " on eobject "
							+ target.toString());

		} catch (ClassCastException e) {
			String errorMessage = "Couldn't cast MocEvent to ECLEvent";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		}
		return null;
	}

	private String getValueOfStringAttribute(EObject eo, String attributeName) {
		// String representation of the EObject :
		// "Klass@abc123 (att1: v1) (att2: v2)"
		String targetString = eo.toString();
		// We get the list of attribute without ending and
		// starting parentheses : "att1: v1) (att2: v2"
		String stringOfAttributesList = targetString.substring(
				targetString.indexOf("(") + 1, targetString.length() - 1);
		// We split it to get ["att1: v1", "att2: v2"]
		List<String> listOfAttributes = Arrays.asList(stringOfAttributesList
				.split("\\) \\("));
		// We look for "attributeName: xxx" in the array.
		String attributeStringRepresentation = "";
		for (String s : listOfAttributes) {
			if (s.startsWith(attributeName + ": ")) {
				attributeStringRepresentation = s;
			}
		}
		String res = "";
		if (attributeStringRepresentation != "") {
			// Either we found "name: xxx" in which case we have
			// 'xxx'
			res = attributeStringRepresentation.substring(
					attributeStringRepresentation.indexOf(attributeName + ": ")
							+ (attributeName + ": ").length(),
					attributeStringRepresentation.length());
			return res;
		} else {
			// Or we throw exception (what to do?)
			throw new UnsupportedOperationException(
					"Somehow you need a 'name' attribute on your model elements...");
		}
	}
	
	@Override
	public Map<String, MocEvent> createMocEventsRegistry(Resource mocEventsResource){
		Map<String, MocEvent> res = new HashMap<String, MocEvent>();
		Iterator<EObject> iterator = mocEventsResource.getAllContents();
		while(iterator.hasNext()){
			EObject eo = iterator.next();
			if(eo instanceof DefPropertyCS){
				DefPropertyCS event = (DefPropertyCS) eo;
				ECLEvent eclEvent = GlmlFactory.eINSTANCE.createECLEvent();
				eclEvent.setElement(event);
				res.put(event.getName(), eclEvent);
			}
		}
		return res;
	}
}
