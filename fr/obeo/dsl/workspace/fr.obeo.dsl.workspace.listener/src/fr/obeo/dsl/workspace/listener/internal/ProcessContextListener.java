/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.workspace.listener.internal;

import fr.obeo.dsl.process.ContextVariable;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.workspace.listener.change.process.TaskChanged;
import fr.obeo.dsl.workspace.listener.change.process.VariableChanged;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

public class ProcessContextListener extends AbstractListener<ProcessContext> 
{

	private EContentAdapter _adapter = null;
	
	public ProcessContextListener(ProcessContext observed) 
	{
		super(observed);
		_adapter = new EContentAdapter()
		{
		    public void notifyChanged(Notification notification) 
		    {
		        super.notifyChanged(notification);
		        processNotification(notification);
		    }
		};
		observed.eAdapters().add(_adapter);
		observed.getDefinition().eAdapters().add(_adapter);
	}

	public void dispose() 
	{
		getObserved().eAdapters().remove(_adapter);
	}

	@Override
	protected void notifyCurrentState(ProcessContext observed2, IChangeProcessor processor) 
	{
		throw new RuntimeException("not supported");
	}

	private void processNotification(Notification notification) 
	{
		if (notification.getNotifier() instanceof Task)
		{
			Task task = (Task)notification.getNotifier();
			if (notification.getEventType() == Notification.SET
				&& notification.getNewValue() != null)
			{
				Object newValue = notification.getNewValue();				
				if (!newValue.equals(notification.getOldValue()))
				{
					TaskChanged change = new TaskChanged(task);
					fireChange(change);
				}
			}
		}
		if (notification.getNotifier() instanceof ContextVariable)
		{
			ContextVariable variable = (ContextVariable)notification.getNotifier();
			if (notification.getEventType() == Notification.SET
					&& notification.getFeatureID(ContextVariable.class) == ProcessPackage.CONTEXT_VARIABLE__VARIABLE_VALUE
					&& notification.getNewValue() != null)
			{
				Object newValue = notification.getNewValue();				
				if (!newValue.equals(notification.getOldValue()))
				{
					VariableChanged change = new VariableChanged(variable);
					fireChange(change);
				}
			}
		}
	}

	
/*	class CustomEContentAdapter extends EContentAdapter{
		public CustomEContentAdapter(){
			super();
		}
		
		
	    protected boolean shouldAdapt(EStructuralFeature feature)
	    {
	    	if(feature.equals(ProcessPackage.eINSTANCE.getContextVariable_VariableValue()))
	    		return true;
	    	else return false;
	    }

	    @Override
	    protected void setTarget(EObject target)
	    {
	        super.setTarget(target);

	        if(target instanceof ContextVariable){
	        	ContextVariable t = (ContextVariable)target;
	        	addAdapter(ProcessPackage.eINSTANCE.getContextVariable_VariableValue());
	        }
	        for (EContentsEList.FeatureIterator<EObject> featureIterator = (EContentsEList.FeatureIterator<EObject>) target.eCrossReferences()
	                                                                                                                       .iterator(); featureIterator.hasNext();)
	        {
	            Notifier notifier = featureIterator.next();
	            EStructuralFeature feature = featureIterator.feature();
	            if (shouldAdapt(feature))
	            {
	                addAdapter(notifier);
	            }
	        }
	    }

	    @Override
	    protected void unsetTarget(EObject target)
	    {
	        super.unsetTarget(target);
	        
	        for (EContentsEList.FeatureIterator<EObject> featureIterator = (EContentsEList.FeatureIterator<EObject>) target.eCrossReferences()
	                                                                                                                       .iterator(); featureIterator.hasNext();)
	        {
	            Notifier notifier = featureIterator.next();
	            EStructuralFeature feature = featureIterator.feature();
	            if (shouldAdapt(feature))
	            {
	                removeAdapter(notifier);
	            }
	        }
	    }

	    @Override
	    protected void selfAdapt(Notification notification)
	    {
	        super.selfAdapt(notification);
	        if (notification.getNotifier() instanceof EObject)
	        {
	            Object feature = notification.getFeature();
	            if (feature instanceof EReference)
	            {
	                EReference eReference = (EReference) feature;
	                if (!eReference.isContainment() && shouldAdapt(eReference))
	                {
	                    handleContainment(notification);
	                }
	            }
	        }
	    }
	}*/
}
