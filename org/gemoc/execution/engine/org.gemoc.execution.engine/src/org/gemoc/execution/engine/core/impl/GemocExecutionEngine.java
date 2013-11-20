package org.gemoc.execution.engine.core.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.api_standard_implementations.dsa.ModelAction;
import org.gemoc.execution.engine.api_standard_implementations.dse.ModelEvent;
import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.NamedReference;
import fr.inria.aoste.trace.Reference;

public class GemocExecutionEngine extends BasicExecutionEngine {

	public GemocExecutionEngine(Resource domainSpecificEventsResource,
			Solver solver, EventExecutor executor, FeedbackPolicy feedbackPolicy)
			throws CoreException {
		super(domainSpecificEventsResource, solver, executor, feedbackPolicy);

		// TODO : parse DSE file to fill in the DSE/DSA information read

		Activator.getMessagingSystem().info(
				"*** Engine construction done. ***", Activator.PLUGIN_ID);
	}

	@Override
	public void initialize(String modelURI, ModelLoader modelLoader) {
		Activator.getMessagingSystem().info(
				"Verifying input before instanciating GemocExecutionEngine...",
				Activator.PLUGIN_ID);

		// modelURI cannot be null or "", modelLoader cannot be null.
		if (modelURI == null | modelLoader == null | modelURI.isEmpty()) {
			String exceptionMessage = "";
			if (modelURI == null) {
				exceptionMessage += "modelURI is null, ";
			}
			if (modelLoader == null) {
				exceptionMessage += "modelLoader is null, ";
			}
			if (modelURI.isEmpty()) {
				exceptionMessage += "modelURI is empty, ";
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

			// TODO: do something with the DSE file and the model.
			// Programatically generate the .extendedCCSL.
			// Resource modelOfExecution = this.modelOfExecutionBuilder.build(
			// this.domainSpecificEventsResource, this.modelResource);

			// String modelOfExecutionFilePath =
			// "/org.gemoc.sample.tfsm.instances/TrafficControl/test_executionModel.extendedCCSL";
			// String modelOfExecutionFilePath =
			// "/org.gemoc.sample.tfsm.instances/TrafficControl/TrafficControl_RendezVous.extendedCCSL";
			String modelOfExecutionFilePath = "/org.gemoc.sample.tfsm.instances/TrafficControl/TrafficControl_MoCC.extendedCCSL";

			URI modelOfExecutionURI = URI.createPlatformResourceURI(
					modelOfExecutionFilePath, true);
			// URI modelOfExecutionURI = modelOfExecution.getURI();

			this.solver.setModelOfExecutionFile(modelOfExecutionURI);

			Activator.getMessagingSystem().info(
					"*** Engine initialization done. ***", Activator.PLUGIN_ID);
		}
	}

	@Override
	protected List<ModelSpecificEvent> match(LogicalStep step) {
		Activator.getMessagingSystem().debug(
				"Matching the given step : " + step.toString()
						+ " containing: \n"
						+ step.getEventOccurrences().toString(),
				Activator.PLUGIN_ID);
		List<ModelSpecificEvent> res = new ArrayList<ModelSpecificEvent>();
		for (EventOccurrence eventOccurrence : step.getEventOccurrences()) {
			if (eventOccurrence.getFState() == FiredStateKind.TICK) {
				Activator.getMessagingSystem().debug(
						"FState is TICK for eventOccurrence: "
								+ eventOccurrence, Activator.PLUGIN_ID);

				if (eventOccurrence.getContext() != null
						& eventOccurrence.getReferedElement() != null) {

					EObject target = this
							.getEObjectFromReference(eventOccurrence
									.getContext());
					Activator.getMessagingSystem().debug(
							"Linked to the EObject: " + target,
							Activator.PLUGIN_ID);
					try {
						EOperation operation = (EOperation) this
								.getEObjectFromReference(eventOccurrence
										.getReferedElement());
						Activator.getMessagingSystem().debug(
								"Linked to the EOperation: " + operation,
								Activator.PLUGIN_ID);
						ModelSpecificEvent mse = new ModelEvent(
								"dseNamesNotUsedYet", new ModelAction(target,
										operation, null), null);
						res.add(mse);
					} catch (ClassCastException e) {
						Activator.getMessagingSystem().warn(
								"... but not linked to an EOperation.",
								Activator.PLUGIN_ID);
					}
				}
			}
		}
		return res;
	}

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


//	private String getQualifiedName(EObject eo) throws SecurityException,
//			IllegalArgumentException, NoSuchMethodException,
//			IllegalAccessException, InvocationTargetException {
//		String res = this.invokeGetNameOnEObject(eo);
//		EObject tmp = eo.eContainer();
//		while (tmp != null) {
//			res = this.invokeGetNameOnEObject(tmp) + "::" + res;
//			tmp = tmp.eContainer();
//		}
//		return res;
//	}
//
//	private String invokeGetNameOnEObject(EObject eObjectMethod)
//			throws SecurityException, NoSuchMethodException,
//			IllegalArgumentException, IllegalAccessException,
//			InvocationTargetException {
//		Method method;
//		method = eObjectMethod.getClass().getMethod("getName");
//		Object res = method.invoke(eObjectMethod);
//		if (res instanceof String) {
//			return (String) res;
//		} else {
//			return null;
//		}
//	}

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

}
