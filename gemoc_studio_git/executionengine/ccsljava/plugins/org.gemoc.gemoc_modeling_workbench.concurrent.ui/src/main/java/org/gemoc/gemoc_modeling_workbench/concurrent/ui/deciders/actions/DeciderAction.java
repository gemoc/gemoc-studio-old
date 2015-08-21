package org.gemoc.gemoc_modeling_workbench.concurrent.ui.deciders.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gemoc.executionengine.ccsljava.api.core.ILogicalStepDecider;
import org.gemoc.executionengine.ccsljava.api.core.INonDeterministicExecutionEngine;
import org.gemoc.executionengine.ccsljava.api.extensions.deciders.DeciderSpecificationExtension;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.Activator;

public class DeciderAction extends Action 
{
	
	protected DeciderSpecificationExtension _specification;

	

	public DeciderAction(DeciderSpecificationExtension specification)
	{
		_specification = specification;
		setText(_specification.getName());
		setToolTipText(_specification.getDescription());
		ImageDescriptor id = ImageDescriptor.createFromURL(specification.getIconURL());
		setImageDescriptor(id);
	}
	
	@Override
	public void run() {
		ILogicalStepDecider newDecider;
		try {
			newDecider = _specification.instanciateDecider();
			_engine.changeLogicalStepDecider(newDecider);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	protected INonDeterministicExecutionEngine _engine;
	public void setEngine(INonDeterministicExecutionEngine engine) {
		_engine = engine;
	}
	
	public DeciderSpecificationExtension getSpecification() {
		return _specification;
	}
	
}
