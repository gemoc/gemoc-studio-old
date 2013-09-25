package org.gemoc.execution.engine.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.api_implementations.dsa.EmfAction;
import org.gemoc.execution.engine.api_implementations.dse.EclEvent;
import org.gemoc.execution.engine.api_implementations.moc.CcslStep;
import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.moc.Step;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.Reference;

public class GemocExecutionEngine extends BasicExecutionEngine {
	private URI modelURI = null;
	private URI metamodelURI = null;
	private EPackage metamodelPackage = null;

	public GemocExecutionEngine(LanguageInitializer languageInitializer, ModelLoader modelLoader, Solver solver,
			Executor executor, FeedbackPolicy feedbackPolicy) throws CoreException {
		super(languageInitializer, modelLoader, solver, executor, feedbackPolicy);
	}

	// Dependency towards
	// fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock
	// Ask Julien to improve the API of EventOccurrence etc.
	 @Override
	    protected List<DomainSpecificEvent> match(Step step) {
	        Activator.getMessagingSystem().debug("Matching the given step : " + step.toString(), Activator.PLUGIN_ID);
	        List<DomainSpecificEvent> res = new ArrayList<DomainSpecificEvent>();
	        try {
	            CcslStep ccslStep = (CcslStep) step;
	            for (EventOccurrence eventOccurrence : ccslStep.getEventOccurrences()) {
	                if (eventOccurrence.getFState() == FiredStateKind.TICK) {
	                    Clock c = this.getClockLinkedToOccurrence(eventOccurrence);
	                    if (c != null) {
	                        EList<EObject> linkedObjects = c.getTickingEvent().getReferencedObjectRefs();
	                        if (linkedObjects.size() == 2) {
	                        	Activator.getMessagingSystem().debug("Linked objects are : \n\t" + linkedObjects.get(0).toString() + "\n\t && " + linkedObjects.get(1).toString(), Activator.PLUGIN_ID);
	                        	EObject linkedOperation = linkedObjects.get(1);
	                        	if(linkedOperation.eIsProxy()){
	                    			linkedOperation = EcoreUtil2.resolve(linkedOperation, this.metamodelPackage.eResource());
	                    		}
	                        	Activator.getMessagingSystem().debug("Is the second object an EOperation ?: " + (linkedOperation instanceof EOperation), Activator.PLUGIN_ID);
	                            if (linkedOperation instanceof EOperation) {
	                                res.add(new EclEvent(new EmfAction(linkedObjects.get(0), (EOperation) linkedOperation)));
	                            }
	                        }
	                    }
	                }

	            }
	        } catch (ClassCastException e) {
	            String errorMessage = "ClassCastException while casting Step as CcslStep";
	            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
	            Activator.error(errorMessage, e);
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

}
