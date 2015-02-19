package org.gemoc.execution.engine.commons.trace;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.commons.ModelExecutionContext;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.FeedbackFactory;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public final class TraceManager 
{
	
	private TraceManager()
	{		
	}

	
	private static TraceManager _instance;
	
	
	public static TraceManager getInstance()
	{
		if (_instance == null)
		{
			_instance = new TraceManager();
		}
		return _instance;
	}
	
	
	private ArrayList<IExecutionEngine> _engines = new ArrayList<>();
	
	private Object _executionEngineLock = new Object();
	
	public void addEngine(IExecutionEngine engine)
	{
		synchronized (_executionEngineLock) 
		{
			_engines.add(engine);
		}
	}

	public void removeEngine(IExecutionEngine engine)
	{
		synchronized (_executionEngineLock) 
		{
			_engines.remove(engine);
		}
	}

	public void raiseMSEOccurrence(EObject caller, String methodName)
	{
		LogicalStep logicalStep = Gemoc_execution_traceFactory.eINSTANCE.createLogicalStep();
		MSEOccurrence occurrence = Gemoc_execution_traceFactory.eINSTANCE.createMSEOccurrence();
		occurrence.setLogicalstep(logicalStep);
		ModelSpecificEvent mse = FeedbackFactory.eINSTANCE.createModelSpecificEvent();
		mse.setCaller(caller);
		mse.setAction(findOperation(caller, methodName));
		occurrence.setMse(mse);
		synchronized (_executionEngineLock) 
		{
			for (IExecutionEngine engine : _engines)
			{
				String uri = engine.getExecutionContext().getResourceModel().getURIFragment(caller);
				if (uri != null)
				{
					for (IEngineAddon addon : engine.getExecutionContext().getExecutionPlatform().getEngineAddons())
					{
						ArrayList<LogicalStep> logicalSteps = new ArrayList<LogicalStep>();
						logicalSteps.add(logicalStep);
						addon.aboutToSelectLogicalStep(engine, logicalSteps);
					}
				}
			}
		}
	}
	
	private EOperation findOperation(EObject object, String methodName)
	{
		for (EOperation operation : object.eClass().getEAllOperations())
		{
			// !!! this is not super correct yet as polyphormism allows the definition of 2 methods with the same name !!!
			if (operation.getName().equals(methodName))
			{
				return operation;
			}
		}
		return null;
	}
	
//	private Collection<IExecutionContext> getExecutionContexts(EObject object)
//	{
//		ArrayList<IExecutionContext> contexts = new ArrayList<IExecutionContext>();
//		synchronized (_executionEngineLock) 
//		{
//			for (IExecutionEngine engine : _engines)
//			{
//				String uri = engine.getExecutionContext().getResourceModel().getURIFragment(object);
//				if (uri != null)
//				{
//					contexts.add(engine.getExecutionContext());
//				}
//			}
//		}
//		return contexts;
//	}

	
}
