package org.gemoc.execution.engine.core.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.api_implementations.dsa.EmfAction;
import org.gemoc.execution.engine.api_implementations.dse.EclEvent;
import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.NamedReference;
import fr.inria.aoste.trace.Reference;

public class GemocExecutionEngine extends BasicExecutionEngine {

	public GemocExecutionEngine(LanguageInitializer languageInitializer, ModelLoader modelLoader, String eclFilePath,
			Solver solver, Executor executor, FeedbackPolicy feedbackPolicy) throws CoreException {
		super(languageInitializer, modelLoader, eclFilePath, solver, executor, feedbackPolicy);
		Activator.getMessagingSystem().info("*** Engine construction done. ***", Activator.PLUGIN_ID);
	}

	@Override
	public void initialize(String modelURI) {
		Activator.getMessagingSystem().info("Initializing GemocExecutionEngine with...", Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tmodelURI: " + modelURI, Activator.PLUGIN_ID);

		this.modelResource = this.modelLoader.loadModel(modelURI);
		this.executor.setModel(this.modelResource);
		Activator.getMessagingSystem().info("Model was successfully loaded: " + modelResource.toString(),
				Activator.PLUGIN_ID);

		// TODO: do something with the DSE file and the model.
		// Programatically generate the .extendedCCSL.
		String modelOfExecutionURI = "/org.gemoc.execution.engine.example/model/TrafficControl_MoCC_new.extendedCCSL";

		this.solver.setModelOfExecutionFile(modelOfExecutionURI);

		Activator.getMessagingSystem().info("*** Engine initialization done. ***", Activator.PLUGIN_ID);
	}

	@Override
	protected List<DomainSpecificEvent> match(LogicalStep step) {
		Activator.getMessagingSystem().debug(
				"Matching the given step : " + step.toString() + " containing: \n"
						+ step.getEventOccurrences().toString(), Activator.PLUGIN_ID);
		List<DomainSpecificEvent> res = new ArrayList<DomainSpecificEvent>();
		for (EventOccurrence eventOccurrence : step.getEventOccurrences()) {
			if (eventOccurrence.getFState() == FiredStateKind.TICK) {
				// EObject target =
				// this.getEObjectFromReference(eventOccurrence.getContext());
				// EOperation operation = (EOperation)
				// this.getEObjectFromReference(eventOccurrence.getReferedElement());

				// En attendant que la couche d'adaptation du solveur CCSL soit
				// faite...
				EObject target = null;
				EOperation operation = null;
				Clock c = this.getClockLinkedToOccurrence(eventOccurrence);
				if (c != null) {
					// is c a DSA caller --> should be replaced with mapping
					// manipulation
					EList<EObject> linkedObjects = c.getTickingEvent().getReferencedObjectRefs();
					if (linkedObjects.size() == 2) {
						target = linkedObjects.get(0);
						operation = (EOperation) linkedObjects.get(1);
					}
				}

				res.add(new EclEvent(new EmfAction(target, operation)));
			}
		}
		return res;
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

	private EObject getEObjectFromReference(Reference reference) {
		Activator.getMessagingSystem().debug(
				"Trying to retrieve the EObject from the Reference : " + reference.toString(), Activator.PLUGIN_ID);

		EList<EObject> elements = ((ModelElementReference) reference).getElementRef();
		if (reference instanceof ModelElementReference) {
			// Returns EObject thanks to the list of EObjects
			return elements.get(elements.size() - 1);
		} else if (reference instanceof NamedReference) {
			// Returns EObject thanks to its qualified name
			Iterator<EObject> modelIterator = this.modelResource.getContents().get(0).eAllContents();
			while (modelIterator.hasNext()) {
				EObject eo = modelIterator.next();
				if (this.getNameOfEObject(eo).equals(elements.get(elements.size() - 1))) {
					return eo;
				}
			}
		} else {
			throw new RuntimeException(
					"Context reference is neither a ModelElementReference nor a NamedElementReference");
		}
		return null;
	}

	private String getNameOfEObject(EObject eo) {
		return this.getQualifiedName(eo);
	}

	private String getQualifiedName(EObject eo) {
		String res = getSimpleName(eo);
		EObject tmp = eo.eContainer();
		while (tmp != null) {
			res = getSimpleName(tmp) + "::" + res;
			tmp = tmp.eContainer();
		}
		return res;
	}

	private String getSimpleName(EObject eo) {
		return this.invokeGetNameOnEObject(eo);
	}

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
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalArgumentException e) {
			String errorMessage = "IllegalArgumentException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (NoSuchMethodException e) {
			String errorMessage = "NoSuchMethodException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = "IllegalAccessException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = "InvocationTargetException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
	}

}
