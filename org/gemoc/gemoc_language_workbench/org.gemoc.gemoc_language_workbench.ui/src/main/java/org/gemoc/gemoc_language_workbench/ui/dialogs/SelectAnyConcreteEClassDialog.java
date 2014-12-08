package org.gemoc.gemoc_language_workbench.ui.dialogs;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


public class SelectAnyConcreteEClassDialog extends SelectAnyEObjectDialog  {

	public SelectAnyConcreteEClassDialog(ResourceSet resourceSet, ILabelProvider renderer) {
		this(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resourceSet, renderer);
	}	

	public SelectAnyConcreteEClassDialog(Shell parent, ResourceSet resourceSet,
			ILabelProvider renderer) {
		super(parent, resourceSet, renderer);
	}

	protected boolean select(EObject obj){
		if(obj instanceof EClass){
			return !((EClass)obj).isAbstract();
		}
		return false;
	}
	

	


}

