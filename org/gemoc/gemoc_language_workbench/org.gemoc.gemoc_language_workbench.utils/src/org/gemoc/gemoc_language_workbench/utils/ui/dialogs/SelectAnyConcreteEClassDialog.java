package org.gemoc.gemoc_language_workbench.utils.ui.dialogs;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;


public class SelectAnyConcreteEClassDialog extends SelectAnyEObjectDialog  {

	

	public SelectAnyConcreteEClassDialog(Shell parent, Resource resource,
			ILabelProvider renderer) {
		super(parent, resource, renderer);
	}

	protected boolean select(EObject obj){
		if(obj instanceof EClass){
			return !((EClass)obj).isAbstract();
		}
		return false;
	}
	

	


}

