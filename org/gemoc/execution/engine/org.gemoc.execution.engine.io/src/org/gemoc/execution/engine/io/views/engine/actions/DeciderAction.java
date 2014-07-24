package org.gemoc.execution.engine.io.views.engine.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtension;

public class DeciderAction extends Action 
{
	
	private DeciderSpecificationExtension _specification;

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
			Activator.getDefault().error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	private GemocExecutionEngine _engine;
	public void setEngine(GemocExecutionEngine engine) {
		_engine = engine;
	}
	
}
