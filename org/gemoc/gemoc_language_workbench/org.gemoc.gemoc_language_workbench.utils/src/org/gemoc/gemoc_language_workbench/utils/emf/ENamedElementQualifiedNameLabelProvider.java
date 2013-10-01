package org.gemoc.gemoc_language_workbench.utils.emf;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.viewers.LabelProvider;

public class ENamedElementQualifiedNameLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if(element instanceof ENamedElement){
			StringBuilder sb = new StringBuilder();
			if(((ENamedElement)element).eContainer() != null){
				sb.append(getText(((ENamedElement)element).eContainer()));
				sb.append("::");
			}
			sb.append(((ENamedElement)element).getName());
			return sb.toString();
		}
		else return super.getText(element);
	}
	

}
