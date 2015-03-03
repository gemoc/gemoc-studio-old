package org.gemoc.execution.engine.core;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.FeedbackFactory;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public final class MSEManager 
{
	
	private MSEManager()
	{		
	}

	
	private static MSEManager _instance;
	
	
	public static MSEManager getInstance()
	{
		if (_instance == null)
		{
			_instance = new MSEManager();
		}
		return _instance;
	}
	
	
	private ArrayList<IMSEOccurrenceListener> _listeners = new ArrayList<>();
	
	private Object _listenersLock = new Object();
	
	public void removeListener(IMSEOccurrenceListener listener) 
	{
		synchronized (_listenersLock) 
		{
			_listeners.remove(listener);
		}
	}


	public void addListener(IMSEOccurrenceListener listener) 
	{
		synchronized (_listenersLock) 
		{
			_listeners.add(listener);
		}
	}


	public void raiseMSEOccurrence(EObject caller, String methodName)
	{
		EOperation operation = findOperation(caller, methodName);
		if (operation != null)
		{
			LogicalStep logicalStep = Gemoc_execution_traceFactory.eINSTANCE.createLogicalStep();
			MSEOccurrence occurrence = Gemoc_execution_traceFactory.eINSTANCE.createMSEOccurrence();
			occurrence.setLogicalstep(logicalStep);
			ModelSpecificEvent mse = FeedbackFactory.eINSTANCE.createModelSpecificEvent();
			mse.setCaller(caller);
			mse.setAction(operation);
			occurrence.setMse(mse);
			synchronized (_listenersLock) 
			{
				for (IMSEOccurrenceListener listener : _listeners)
				{
					listener.mseOccurenceRaised(occurrence);
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
	
}
