package org.gemoc.execution.engine.core;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.FeedbackFactory;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public final class MSEManager 
{
	
	private MSEManager()
	{		
	}

	
	private static MSEManager _instance;
	
	private ActionModel _actionModel;
	
	
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
			ModelSpecificEvent mse = findOrCreateMSE(caller, operation);
			occurrence.setMse(mse);
			synchronized (_listenersLock) 
			{
				for (IMSEOccurrenceListener listener : _listeners)
				{
					listener.mseOccurenceAboutToBeRaised(occurrence);
				}
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
	
	private ModelSpecificEvent findOrCreateMSE(EObject caller, EOperation operation){
		
		if( _actionModel != null){
			for(ModelSpecificEvent existingMSE :_actionModel.getEvents()){
				if(existingMSE.getCaller().equals(caller) && existingMSE.getAction().equals(operation)){
					// no need to create one, we already have it
					return existingMSE;
				}
			}
		}
		// let's create a MSE
		final ModelSpecificEvent mse = FeedbackFactory.eINSTANCE.createModelSpecificEvent();
		mse.setCaller(caller);
		mse.setAction(operation);
		mse.setName("MSE_"+caller.getClass().getSimpleName()+"_"+operation.getName());
		// and add it for possible reuse
		if( _actionModel != null){
			
			
			if(_actionModel.eResource() != null){
				TransactionUtil.getEditingDomain(_actionModel.eResource());
				RecordingCommand command = new RecordingCommand(TransactionUtil.getEditingDomain(_actionModel.eResource()), "Saving new MSE ") {
					@Override
					protected void doExecute() {
						_actionModel.getEvents().add(mse);
			
						try {
							_actionModel.eResource().save(null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				TransactionUtil.getEditingDomain(_actionModel.eResource()).getCommandStack().execute(command);
				
			}
		}
		return mse;
	}
	
	public ActionModel getActiveActionModel(){
		return _actionModel;
	}
	
	public void setActiveActionModel(ActionModel actionModel){
		_actionModel = actionModel;
	}
	
}
