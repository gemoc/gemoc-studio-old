package org.gemoc.gemoc_language_workbench.ui.dialogs;

import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;




public class SelectAnyEObjectDialog extends ElementListSelectionDialog  {

	Resource searchedResource;
	public SelectAnyEObjectDialog(Shell parent, Resource resource, ILabelProvider renderer) {
		super(parent, renderer);
		searchedResource = resource;
		ArrayList<EObject> all = new ArrayList<EObject>();
		for (TreeIterator<EObject> iterator = searchedResource.getAllContents(); iterator.hasNext();) {
			EObject o =  iterator.next();
			if(select(o)) all.add(o);
		}
		
		Object[] elements = all.toArray();
		this.setElements(elements);
	}

	protected boolean select(EObject obj){
		return true;
	}
	

	


}

