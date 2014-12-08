package org.gemoc.gemoc_language_workbench.ui.dialogs;

import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;


public class SelectAnyEObjectDialog extends ElementListSelectionDialog  {

	private ResourceSet _searchedResourceSet;

	public SelectAnyEObjectDialog(Shell parent, ResourceSet resourceSet, ILabelProvider renderer) {
		super(parent, renderer);
		_searchedResourceSet = resourceSet;
		ArrayList<EObject> all = new ArrayList<EObject>();
		EcoreUtil.resolveAll(resourceSet);
		for (Resource r : _searchedResourceSet.getResources())
		{
			for (TreeIterator<EObject> iterator = r.getAllContents(); iterator.hasNext();) {
				EObject o =  iterator.next();
				if(select(o)) all.add(o);
			}
		}
		
		Object[] elements = all.toArray();
		this.setElements(elements);
	}

	protected boolean select(EObject obj){
		return true;
	}
	

	


}

