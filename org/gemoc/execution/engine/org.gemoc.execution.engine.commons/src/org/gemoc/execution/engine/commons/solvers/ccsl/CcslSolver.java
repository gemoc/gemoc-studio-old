package org.gemoc.execution.engine.commons.solvers.ccsl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.gemoc_language_workbench.api.moc.SolverInputBuilder;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.parser.xtext.ExtendedCCSLStandaloneSetup;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.timesquare.ccslkernel.solver.launch.CCSLKernelSolverWrapper;
import fr.inria.aoste.timesquare.simulationpolicy.maxcardpolicy.MaxCardSimulationPolicy;
import fr.inria.aoste.timesquare.trace.util.HelperFactory;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.Reference;
import gepl.ECLEvent;
import gepl.GeplFactory;
import gepl.MocEvent;

/**
 * The interface of the CCSLKernelSolver as seen by the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public abstract class CcslSolver implements
		org.gemoc.gemoc_language_workbench.api.moc.Solver {

	private CCSLKernelSolverWrapper solverWrapper = null;
	private URI solverInputURI = null;
	// private SolverInputBuilder solverInputBuilder;
	private LogicalStep lastLogicalStep = null;
	private Map<Event, ModelElementReference> mappingEventToOriginalMer = null;

	protected String extentedCCSL_qvto_transformationPath; // "/org.gemoc.sample.tfsm/qvto-gen/tfsm_toCCSL.qvto";
	
	
	public CcslSolver(String extentedCCSL_qvto_transformationPath) {
		//this.solverInputBuilder = new EclToCcslTranslator();
		this.extentedCCSL_qvto_transformationPath = extentedCCSL_qvto_transformationPath;
		this.mappingEventToOriginalMer = new HashMap<Event, ModelElementReference>();
	}

//	public SolverInputBuilder getSolverInputBuilder() {
//		return this.solverInputBuilder;
//	}
//
//	public void setSolverInputBuilder(SolverInputBuilder solverInputBuilder) {
//		this.solverInputBuilder = solverInputBuilder;
//	}

	@Override
	public void forbidEventOccurrence(EventOccurrence eventOccurrence) {
		this.solverWrapper.forceClockAbsence(this
				.getModelElementReferenceFromEventOccurrence(eventOccurrence));
	}

	@Override
	public void forceEventOccurrence(EventOccurrence eventOccurrence) {
		this.solverWrapper.forceClockPresence(this
				.getModelElementReferenceFromEventOccurrence(eventOccurrence));

	}

	/**
	 * Returns the ModelElementReference refered by this eventOccurrence (as
	 * originally sent by the CCSL Solver).
	 * 
	 * @param eventOccurrence
	 * @return
	 */
	private ModelElementReference getModelElementReferenceFromEventOccurrence(
			EventOccurrence eventOccurrence) {
		Reference reference = eventOccurrence.getReferedElement();
		if (reference instanceof ModelElementReference) {
			ModelElementReference mer = (ModelElementReference) reference;
			ModelElementReference merToForce = this.mappingEventToOriginalMer
					.get(mer.getElementRef().get(0));
			return merToForce;
		} else {
			throw new RuntimeException(
					"Refered Element of eventOccurrence should be a ModelElementReference");
		}
	}

	@Override
	public LogicalStep getNextStep() {
		try {
			// Retrieve a step from the CCSL Solver.
			LogicalStep res = this.solverWrapper.getSolver()
					.doOneSimulationStep();

			// We need to slightly adapt the trace so as to be able to establish
			// the link
			// between an EventOccurrence and an ECL Event.
			for (EventOccurrence eventOccurrence : res.getEventOccurrences()) {
				Clock c = this.getClockLinkedToOccurrence(eventOccurrence);
				if (c != null) {
					ModelElementReference mer = (ModelElementReference) eventOccurrence
							.getReferedElement();
					// We memorize the reference to the Clock (3 EObjects : file
					// / block / clock) so it can be retrieved later on.
					mappingEventToOriginalMer.put(c.getTickingEvent(),
							(ModelElementReference) eventOccurrence
									.getReferedElement());
					// Instead we place the ECL Event
					eventOccurrence.setReferedElement(HelperFactory
							.createModelElementReference(c.getTickingEvent()));
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

	/**
	 * Returns the clock linked to an EventOccurrence.
	 * 
	 * @param eventOcc
	 * @return
	 */
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

	@Override
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
			Map<EObject, Collection<Setting>>  unresolvedProxies = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
			if(unresolvedProxies.size() != 0){
				Activator.getMessagingSystem()
				.warn("There are unresolved proxies in "+solverInputURI+ ", the first is "+unresolvedProxies.entrySet().toArray()[0], Activator.PLUGIN_ID);
				Activator.getMessagingSystem()
				.warn("Please verify your extendedCCSL file, (it must not contain resolve warning).", Activator.PLUGIN_ID);
			}
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

	/**
	 * used to test if we need to generate the extendedCCSL
	 * extendedCCSL should be regenerated if user model is newer than the extendedCCSL
	 */
	public boolean isSolverInputFileReadyForUserModel(URI userModelURI){
		// TODO implement this feature 
		return true;
	}
	
	/**
	 * generate the ExtendedCCSL using the provided qvto transformation
	 * return the URI of the prepared file 
	 */
	public URI prepareSolverInputFileForUserModel(URI userModelURI){
		// generate the ExtendedCCSL
		// set the input
		// TODO implement this feature 
		return null;
	}
	
	@Override
	public EventOccurrence getCorrespondingEventOccurrence(MocEvent mocEvent,
			EObject target) {
		try {
			// Retrieve the name of the MocEvent
			ECLEvent eclEvent = (ECLEvent) mocEvent;
			String eventName = eclEvent.getElement().getName();
			// Retrieve the value of attribute "name" on the target
			String targetName = this.getValueOfStringAttribute(target, "name");
			// So the clock generated by the transformation should have the
			// following name:
			String eventOccurrenceName = "evt_" + targetName + "_" + eventName;

			for (EventOccurrence eventOccurrence : this.lastLogicalStep
					.getEventOccurrences()) {
				if (eventOccurrence.getReferedElement() instanceof ModelElementReference) {
					ModelElementReference reference = (ModelElementReference) eventOccurrence
							.getReferedElement();
					if (this.getValueOfStringAttribute(
							reference.getElementRef().get(0), "name").equals(
							eventOccurrenceName)) {
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

	/**
	 * Returns the value of the attribute whose name is attributeName of eobject
	 * eo. The type of the attribute must be String. Basically if a String
	 * attribute is a good enough unique identifier for your EObjects then use
	 * this method to retrieve the value of the attribute without making
	 * assumption about the EObject. Otherwise, better use .toString().
	 * 
	 * @param eo
	 * @param attributeName
	 * @return
	 */
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
	public Map<String, MocEvent> createMocEventsRegistry(
			Resource mocEventsResource) {
		Map<String, MocEvent> res = new HashMap<String, MocEvent>();
		Iterator<EObject> iterator = mocEventsResource.getAllContents();
		while (iterator.hasNext()) {
			EObject eo = iterator.next();
			if (eo instanceof DefPropertyCS) {
				DefPropertyCS event = (DefPropertyCS) eo;
				ECLEvent eclEvent = GeplFactory.eINSTANCE.createECLEvent();
				eclEvent.setElement(event);
				res.put(event.getName(), eclEvent);
			}
		}
		return res;
	}

	@Override
	public List<LogicalStep> getPossibleLogicalSteps() {
		// TODO improve when the appropriate support if implemented in timesquare
		List<LogicalStep> logicalSteps = new ArrayList<LogicalStep>();
		logicalSteps.add(getNextStep());
		return logicalSteps;
	}

	@Override
	public int proposeLogicalStepByIndex() {
		// TODO improve when the appropriate support if implemented in timesquare
		return 0;
	}

	@Override
	public void applyLogicalStepByIndex(int indexOfStepToApply) {
		// TODO improve when the appropriate support if implemented in timesquare
		
	}

	
	
	public String getExtentedCCSL_qvto_transformationPath() {
		return extentedCCSL_qvto_transformationPath;
	}

	public void setExtentedCCSL_qvto_transformationPath(
			String extentedCCSL_qvto_transformationPath) {
		this.extentedCCSL_qvto_transformationPath = extentedCCSL_qvto_transformationPath;
	}
}
