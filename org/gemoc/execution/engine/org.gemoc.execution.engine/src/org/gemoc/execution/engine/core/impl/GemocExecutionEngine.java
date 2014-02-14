package org.gemoc.execution.engine.core.impl;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.NamedReference;
import fr.inria.aoste.trace.Reference;
import glml.DomainSpecificEvent;
import glml.DomainSpecificEventFile;
import glml.ECLEvent;
import glml.Identity;
import glml.ModelSpecificEvent;
import glml.Pattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventInjectionException;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

/**
 * Implementation of the GEMOC Execution Engine. In particular, it is more
 * concerned about the model-specific elements such as the modelLoader and the
 * modelResource used for an execution.
 * 
 * 
 * @see ExecutionEngine
 * @see ObservableBasicExecutionEngine
 * 
 * @author flatombe
 * 
 */
public class GemocExecutionEngine extends ObservableBasicExecutionEngine {

	/**
	 * Derived from the language-specific elements using the loaded model.
	 */
	private Resource modelOfExecution = null;
	private Map<String, ModelSpecificEvent> modelSpecificEventsRegistry = null;
	private Resource solverInput = null;

	/**
	 * Delegated to the abstract class, for the language-level instantiation of
	 * the engine.
	 * 
	 * @see ObservableBasicExecutionEngine
	 * @param domainSpecificEventsResource
	 *            the resource containing the DomainSpecificEvents of the
	 *            language.
	 * @param solver
	 *            the solver corresponding to the MoC used by the xDSML.
	 * @param executor
	 *            the executor, able to execute code compiled from the language
	 *            used for the RTD/DSAs.
	 * @param feedbackPolicy
	 *            interprets the results from the DSAs to influence the
	 *            Solver/MoC.
	 */
	public GemocExecutionEngine(Resource mocEventsResource, Resource domainSpecificEventsResource,
			Solver solver, EventExecutor executor, FeedbackPolicy feedbackPolicy) {
		super(mocEventsResource, domainSpecificEventsResource, solver, executor, feedbackPolicy);
		Activator.getMessagingSystem().info(
				"*** Engine construction done. ***", Activator.PLUGIN_ID);
	}

	@Override
	public void initialize(String modelURI, ModelLoader modelLoader) {
		Activator.getMessagingSystem().info(
				"Verifying input before instanciating GemocExecutionEngine...",
				Activator.PLUGIN_ID);

		// modelURI cannot be null, modelLoader cannot be null.
		if (modelURI == null | modelLoader == null) {
			String exceptionMessage = "";
			if (modelURI == null) {
				exceptionMessage += "modelURI is null, ";
			}
			if (modelLoader == null) {
				exceptionMessage += "modelLoader is null, ";
			}
			Activator.getMessagingSystem().info(
					"...NOK. Throwing NullPointerException.",
					Activator.PLUGIN_ID);
			throw new NullPointerException(exceptionMessage);
		} else {

			Activator.getMessagingSystem().info(
					"...OK. Initializing GemocExecutionEngine with...",
					Activator.PLUGIN_ID);
			Activator.getMessagingSystem().info("\tmodelURI: " + modelURI,
					Activator.PLUGIN_ID);
			Activator.getMessagingSystem().info(
					"\tmodelLoader: " + modelLoader, Activator.PLUGIN_ID);

			this.modelStringURI = modelURI;
			this.modelLoader = modelLoader;

			// Create the modelResource from the modelLoader and the modelURI.
			this.modelResource = this.modelLoader.loadModel(modelURI);

			Activator.getMessagingSystem().info(
					"Model was successfully loaded: "
							+ modelResource.toString(), Activator.PLUGIN_ID);

			// TODO: Invoke the transformation that creates the model of
			// execution
			// from the DSEs.
			
			// TFSM Sample
//			this.modelOfExecution = new ResourceSetImpl()
//			.getResource(
//					URI.createPlatformResourceURI(
//							"/org.gemoc.sample.tfsm.instances/TrafficControl/test/MyModelSpecificEvents.glml",
//							true), true);
			
			// Petrinet Sample
			this.modelOfExecution = new ResourceSetImpl()
					.getResource(
							URI.createPlatformResourceURI(
									"/org.gemoc.sample.petrinet/instances/test_1/BasicExample_ModelOfExecution.glml",
									true), true);

			// TODO : remove when EclToCCslTranslator gets implemented.
			try {
				Resource solverInput = this.solver.getSolverInputBuilder()
						.build(this.modelOfExecution);

				this.solverInput = solverInput;

			} catch (UnsupportedOperationException e) {
				// TFSM Sample
//				String solverInputFilePath = "/org.gemoc.sample.tfsm.instances/TrafficControl/test/test_executionModel.extendedCCSL";
				// Petrinet Sample
				String solverInputFilePath = "/org.gemoc.sample.petrinet/instances/test_1/BasicExample_MoCC.extendedCCSL";
				
				// String solverInputFilePath =
				// "/org.gemoc.sample.tfsm.instances/TrafficControl/test/MySolverInput.javasolverinput";
				this.solverInput = new ResourceSetImpl().getResource(URI
						.createPlatformResourceURI(solverInputFilePath, true),
						true);
				// this.solver.input.load(null) ???
			}

			// Then we place the created solverInput into the solver
			this.solver.setSolverInputFile(this.solverInput.getURI());

			// We create the internal representation of the MSEs.
			this.modelSpecificEventsRegistry = this
					.buildModelSpecificEventsRegistry(this.modelOfExecution);

			// We proceed to the first step of execution (a new one coming from
			// the solver or the first coming from a loaded scenario !)
			this.setCurrentStepAndUpdateTraces(this.getScheduledOrSolverStep());

			Activator.getMessagingSystem().info(
					"*** Engine initialization done. ***", Activator.PLUGIN_ID);
		}
	}

	/**
	 * Builds a map with, as keys, the names of the ModelSpecificEvents, as
	 * values, the ModelSpecificEvents. This is so because we "recognize" the
	 * MSE occurrences allowed by the MoC solver's trace thanks to the name of
	 * the event.
	 * 
	 * @param modelOfExecution
	 * @return the registry of ModelSpecificEvents based on their names.
	 */
	private Map<String, ModelSpecificEvent> buildModelSpecificEventsRegistry(
			Resource modelOfExecution) {
		Map<String, ModelSpecificEvent> res = new HashMap<String, ModelSpecificEvent>();
		DomainSpecificEventFile dseFile = (DomainSpecificEventFile) modelOfExecution
				.getContents().get(0);
		for (ModelSpecificEvent mse : dseFile.getModelEvents()) {
			res.put(mse.getName(), mse);
		}
		return res;
	}

	@Override
	public void reset() {
		this.solver.setSolverInputFile(this.solverInput.getURI());
		this.scheduledEventsMap.clear();
		this.scheduledSteps.clear();
		this.schedulingTrace.clear();
		this.executionTrace.clear();
		this.setCurrentStepAndUpdateTraces(this.getScheduledOrSolverStep());

		this.setChanged();
		this.notifyObservers(">Reset!");

		Activator.getMessagingSystem().warn("\n\n\nReset !\n\n\n",
				Activator.PLUGIN_ID);
	}

	private Integer getCurrentDate() {
		int res = 0;
		for (Integer integer : this.schedulingTrace.keySet()) {
			if (integer > res) {
				res = integer;
			}
		}
		return res;
	}

	// This method is in charge of interpreting the pattern described in GLML.
	// For now let's do some simple interpretation in Java, however here is
	// where we might want to use an implementation that supports bidirection in
	// order to deal with the feedback.
	private Boolean patternOfEventOccursInSchedulingTrace(
			ModelSpecificEvent mse, Map<Integer, LogicalStep> schedulingTrace) {
		Boolean res = false;
		Pattern pattern = mse.getCondition();
		if (pattern instanceof Identity) {
			// Identity means the last scheduling step must contain an event
			// occurrence that has a named reference of same name as the mapped
			// MoC Event.
			Identity identity = (Identity) pattern;
			// TODO should MoCEvent have the name attribute and be filled
			// depending on the implementation used?
			String mappedMocEventName = ((ECLEvent) identity.getArgument())
					.getElement().getName();
			LogicalStep lastStep = schedulingTrace.get(this.getCurrentDate());
			for (EventOccurrence eventOccurrence : lastStep
					.getEventOccurrences()) {
				if (eventOccurrence.getFState() == FiredStateKind.TICK
						& eventOccurrence.getReferedElement() != null) {
					if (eventOccurrence.getReferedElement() instanceof NamedReference) {
						// In our protocol, the scheduling trace's event
						// occurrences' refered element must be a named
						// reference to the clock (ECL event). This way we know
						// what MoC event it is related to.
						NamedReference namedReference = (NamedReference) eventOccurrence
								.getReferedElement();
						String nameOfTheECLEventCorrespondingToTheTickingClock = namedReference
								.getValue();
						String targetName = this.getValueOfStringAttribute(mse.getModelSpecificActions().get(0).getTarget(), "name");
						
						res = nameOfTheECLEventCorrespondingToTheTickingClock
								.equals("evt_" + targetName + "_"
										+ mappedMocEventName)
								|| res;
					} else if(eventOccurrence.getReferedElement() instanceof ModelElementReference){
						// In our protocol, the scheduling trace's event
						// occurrences' refered element must be a named
						// reference to the clock (ECL event). This way we know
						// what MoC event it is related to.
						ModelElementReference mer = (ModelElementReference) eventOccurrence
								.getReferedElement();
						String stringOfTheECLEventCorrespondingToTheTickingClock = mer.getElementRef().get(0).toString();
						Activator.getMessagingSystem().debug("string of the ecl event corresponding to the ticking clock: " + stringOfTheECLEventCorrespondingToTheTickingClock, Activator.PLUGIN_ID);
						// MAYBE FILTER BY NAME HERE TOO
						String nameOfTheECLEventCorrespondingToTheTickingClock = this.getValueOfStringAttribute(mer.getElementRef().get(0), "name");
						Activator.getMessagingSystem().debug("name of the ecl event : " + nameOfTheECLEventCorrespondingToTheTickingClock, Activator.PLUGIN_ID);
						// In the MSE Specification, we have a link from MSE to
						// its reification (DSE).
						// We also have a link (pattern) from DSE to MSE.
						// Unfortunately we cannot explicitly know which clock
						// (EventOccurrence) came from which ECL Event, so we
						// cannot map MSEs directly to clocks and thus they are
						// mapped to the same Ecl Event as their reification.
						// Which is why we need to do this mapping by analyzing
						// the name of the clock (EventOccurrence) so as to see
						// if it indeed is an instanciation of the correct ECL
						// Event and if it aims the same EObject from the model
						// as our MSE's MSA does.
						String nameOfTheEObject = this.getValueOfStringAttribute(mse.getModelSpecificActions().get(0).getTarget(), "name");
						
						
						res = nameOfTheECLEventCorrespondingToTheTickingClock
								.equals("evt_" + nameOfTheEObject + "_"
										+ mappedMocEventName)
								|| res;
						Activator.getMessagingSystem().debug("made up name of the event with targetname etc : " + "evt_" + nameOfTheEObject + "_" + mappedMocEventName, Activator.PLUGIN_ID);
					} else{
						throw new RuntimeException("Unable to analyze correctly the scheduling step provided");
					}
				}
			}
		} else {
			throw new UnsupportedOperationException(
					"Not able to interpret the following pattern: "
							+ pattern.toString());
		}
		return res;
	}
	
	private String getValueOfStringAttribute(EObject eo, String attributeName){
		// String representation of the EObject :
		// "Klass@abc123 (att1: v1) (att2: v2)"
		String targetString = eo.toString();
		// We get the list of attribute without ending and
		// starting parentheses : "att1: v1) (att2: v2"
		String stringOfAttributesList = targetString.substring(
				targetString.indexOf("(") + 1,
				targetString.length() - 1);
		// We split it to get ["att1: v1", "att2: v2"]
		List<String> listOfAttributes = Arrays
				.asList(stringOfAttributesList.split("\\) \\("));
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

	// TODO : this method will change when we change the DSE language.
	@Override
	protected Collection<ModelSpecificEvent> match(
			Map<Integer, LogicalStep> schedulingTrace) {
		Activator.getMessagingSystem().debug(
				"Matching against the following scheduling trace:\n"
						+ this.mapToString(this.schedulingTrace),
				Activator.PLUGIN_ID);
		Collection<ModelSpecificEvent> res = new ArrayList<ModelSpecificEvent>();
		for (ModelSpecificEvent mse : this.modelSpecificEventsRegistry.values()) {
			if (this.patternOfEventOccursInSchedulingTrace(mse, schedulingTrace) == true) {
				res.add(mse);
			}
		}
		return res;
	}

	@Override
	public void injectEvent(DomainSpecificEvent injectedDse, EObject target)
			throws EventInjectionException {
		this.setChanged();
		this.notifyObservers("Received from ControlPanel: injection of event <<"
				+ injectedDse.getName()
				+ ">> on target <<"
				+ target.toString()
				+ ">>");
		try {
			Activator.getMessagingSystem().info(
					"Trying injection of the following event : "
							+ injectedDse.getName() + " on target: "
							+ target.toString(), Activator.PLUGIN_ID);

			// First we verify that the DSE is valid (with respect to the file
			// describing the DSEs) and that the target is indeed in the model
			// and that the metaclass of the target is the metaclass targetted
			// by the action of the DSE.

			EcoreUtil.EqualityHelper equalityHelper = new EcoreUtil.EqualityHelper();
			if (!(this.domainSpecificEventsRegistry.containsValue(injectedDse)
					&& this.resourceContainsEObject(this.modelResource, target) && /*
																					 * equalityHelper
																					 * .
																					 * equals
																					 * (
																					 * injectedDse
																					 * .
																					 * getDomainSpecificActions
																					 * (
																					 * )
																					 * .
																					 * get
																					 * (
																					 * 0
																					 * )
																					 * .
																					 * getTargetClass
																					 * (
																					 * )
																					 * ,
																					 * target
																					 * .
																					 * eClass
																					 * (
																					 * )
																					 * )
																					 */injectedDse
					.getDomainSpecificActions().get(0).getTargetClass()
					.getName().equals(target.eClass().getName()))) {
				String errorMessage = "";
				if (!this.domainSpecificEventsRegistry
						.containsValue(injectedDse)) {
					errorMessage += "The selected DomainSpecificEvent is not present in the DSE file, ";
				}
				if (!this.resourceContainsEObject(this.modelResource, target)) {
					errorMessage += "The model resource does not contained the selected EObject, ";
				}
				if (!/*
					 * equalityHelper.equals(injectedDse
					 * .getDomainSpecificActions().get(0).getTargetClass(),
					 * target.eClass()
					 */injectedDse.getDomainSpecificActions().get(0)
						.getTargetClass().getName()
						.equals(target.eClass().getName())) {
					errorMessage += "The metaclass of the selected EObject does not correspond to the metaclass targetted by the selected DomainSpecificEvent, ";
				}
				errorMessage = errorMessage.substring(0,
						errorMessage.length() - 2) + ".";
				throw new EventInjectionException(errorMessage);
			} else {

				Activator
						.getMessagingSystem()
						.debug("DSE Registry and model resource contain required elements. Target is of valid type. Proceeding with the injection.",
								Activator.PLUGIN_ID);

				// If it is the case, then we (try to) retrieve the equivalent
				// MSE
				ModelSpecificEvent mse = this
						.findCorrespondingModelSpecificEvent(injectedDse,
								target, this.modelSpecificEventsRegistry);
				Activator.getMessagingSystem().debug(
						"The equivalent MSE is: " + mse.toString(),
						Activator.PLUGIN_ID);

				// We get the events allowed by the MoC for the current step.
				Collection<ModelSpecificEvent> allowedEvents = this
						.getCurrentPossibleEvents();
				Activator.getMessagingSystem().debug(
						"Allowed events are: " + allowedEvents.toString(),
						Activator.PLUGIN_ID);

				if (allowedEvents.contains(mse)) {
					// If the injected MSE is legal, then it is added to the
					// scheduled events of the current step.
					List<ModelSpecificEvent> scheduledEventsForCurrentStep = this.scheduledEventsMap
							.get(this.currentStep);
					scheduledEventsForCurrentStep.add(mse);
					Activator.getMessagingSystem().info(
							"MSE added to the scheduled events of the step.",
							Activator.PLUGIN_ID);
				} else {
					// If the MSE is not authorized by the MoC, we throw an
					// exception and leave the GUI to deal with it (reinject
					// later,
					// send feedback to the user, etc...)
					Activator.getMessagingSystem().warn(
							"MSE was not allowed by the MoC.",
							Activator.PLUGIN_ID);
					throw new EventInjectionException(
							"Injecting this event is not allowed by the Model of Computation at that time.");
				}
			}

			Activator.getMessagingSystem().info(
					"Scheduling Trace: \n" + mapToString(this.schedulingTrace)
							+ "\n Scheduled Events: \n"
							+ mapToString(this.scheduledEventsMap),
					Activator.PLUGIN_ID);
		} catch (NoSuchElementException e) {
			throw new EventInjectionException(
					"Could not find a corresponding Model-Specific Event. Please verify your selection. Your Model of Execution or Solver Input may be incorrect !");
		} catch (RuntimeException e1) {
			Activator.error("RuntimeException during injection of event", e1);
			throw e1;
		}
	}

	@Override
	public Resource getModelResource() {
		return this.modelResource;
	}

	/**
	 * Searches through the given map for a Model-Specific Event which the
	 * following characteristics:
	 * <ul>
	 * <li>Its reification is "equals" to the DSE given in arguments. Because
	 * the DSE resource is loaded at two different places (once in the
	 * ModelOfExecution file, once by this Engine), the instances are not the
	 * same though the objects have the same features values. Which is why we
	 * use EcoreUtil.EqualityHelper.</li>
	 * </ul>
	 * Its first (and only... ?) MSA's target is equals to the target given in
	 * the parameters (same as above).
	 * 
	 * @param dse
	 *            A Domain-Specific Event
	 * @param target
	 *            An EObject of the model
	 * @param map
	 *            The ModelSpecificEvents registry
	 * @return the MSE corresponding to the DSE on the given target.
	 */
	private ModelSpecificEvent findCorrespondingModelSpecificEvent(
			DomainSpecificEvent dse, EObject target,
			Map<String, ModelSpecificEvent> map) {
		Activator.getMessagingSystem().debug(
				"Trying to find the MSE with the following characteristics:"
						+ "\n - DSE: " + dse + "\n - Target: "
						+ target.toString() + "\n Among the following MSE map:"
						+ "\n" + this.mapToString(map), Activator.PLUGIN_ID);
		EcoreUtil.EqualityHelper equalityHelper = new EcoreUtil.EqualityHelper();
		for (ModelSpecificEvent mse : map.values()) {
			// Adding a name-based equality because it doesn't work anymore... I
			// think it's when looking up the references...
			if ((equalityHelper.equals(mse.getReification(), dse) || mse
					.getReification().getName().equals(dse.getName()))
					&& equalityHelper.equals(
							mse.getModelSpecificActions().get(0).getTarget(),
							target)) {
				Activator.getMessagingSystem().debug(
						"Found corresponding MSE: " + mse.getName(),
						Activator.PLUGIN_ID);
				return mse;
			}
		}
		Activator
				.getMessagingSystem()
				.debug("Could not find corresponding MSE. Throwing NoSuchElementException.",
						Activator.PLUGIN_ID);
		throw new NoSuchElementException();
	}

	private boolean resourceContainsEObject(Resource resource, EObject eo) {
		Iterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject content = it.next();
			if (content.equals(eo)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * All 5 methods below are a hack needed at some point to retrieve the
	 * EObject from a qualified name.
	 */

	/**
	 * Hack to retrieve an EObject from its qualified name...
	 * 
	 * @param modelResource
	 * @param qualifiedName
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public EObject getEObjectFromQualifiedName(Resource modelResource,
			String qualifiedName) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {

		Iterator<EObject> iterator = modelResource.getAllContents();// this.modelResource.getContents().get(0).eAllContents();
		EObject res = null;
		while (iterator.hasNext() & res == null) {
			EObject modelElement = iterator.next();
			if (this.getQualifiedName(modelElement).equals(qualifiedName)) {
				res = modelElement;
			}
		}
		return res;
	}

	/**
	 * Part of the hack to get an EObject from its qualified name.
	 * 
	 * @param reference
	 * @return
	 */
	private EObject getEObjectFromReference(Reference reference) {

		EList<EObject> elements = ((ModelElementReference) reference)
				.getElementRef();
		if (reference instanceof ModelElementReference) {
			// Returns EObject thanks to the list of EObjects
			return elements.get(elements.size() - 1);
		} else if (reference instanceof NamedReference) {
			// Returns EObject thanks to its qualified name
			try {
				EObject res = getEObjectFromQualifiedName(this.modelResource,
						(((NamedReference) reference).getValue()));
				Activator.getMessagingSystem().debug("Returning :" + res,
						Activator.PLUGIN_ID);
				return res;
			} catch (SecurityException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (IllegalArgumentException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (NoSuchMethodException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (IllegalAccessException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (InvocationTargetException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			}

			// Iterator<EObject> modelIterator =
			// this.modelResource.getContents().get(0).eAllContents();
			// while (modelIterator.hasNext()) {
			// EObject eo = modelIterator.next();
			// if (this.getNameOfEObject(eo).equals(elements.get(elements.size()
			// - 1))) {
			// return eo;
			// }
			// }
		} else {
			throw new RuntimeException(
					"Context reference is neither a ModelElementReference nor a NamedElementReference");
		}
	}

	/**
	 * Part of the hack to get an EObject from its qualified name.
	 * 
	 * @param eo
	 * @return
	 */
	private String getQualifiedName(EObject eo) {
		String res = getSimpleName(eo);
		EObject tmp = eo.eContainer();
		while (tmp != null) {
			res = getSimpleName(tmp) + "::" + res;
			tmp = tmp.eContainer();
		}
		return res;
	}

	/**
	 * Part of the hack to get an EObject from its qualified name.
	 * 
	 * @param eo
	 * @return
	 */
	private String getSimpleName(EObject eo) {
		return this.invokeGetNameOnEObject(eo);
	}

	/**
	 * Part of the hack to get an EObject from its qualified name.
	 * 
	 * @param eObjectMethod
	 * @return
	 */
	private String invokeGetNameOnEObject(EObject eObjectMethod) {
		Method method;
		try {
			method = eObjectMethod.getClass().getMethod("getName");
			Object res = method.invoke(eObjectMethod);
			if (res instanceof String) {
				return (String) res;
			} else {
				return null;
			}
		} catch (SecurityException e) {
			String errorMessage = "SecurityException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalArgumentException e) {
			String errorMessage = "IllegalArgumentException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (NoSuchMethodException e) {
			String errorMessage = "NoSuchMethodException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = "IllegalAccessException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = "InvocationTargetException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
	}

	@Override
	public Collection<ModelSpecificEvent> getModelSpecificEvents() {
		return this.modelSpecificEventsRegistry.values();
	}

	@Override
	public ModelSpecificEvent getCorrespondingModelSpecificEvent(
			DomainSpecificEvent dse, EObject target) {
		return this.findCorrespondingModelSpecificEvent(dse, target, this.modelSpecificEventsRegistry);
	}

}
