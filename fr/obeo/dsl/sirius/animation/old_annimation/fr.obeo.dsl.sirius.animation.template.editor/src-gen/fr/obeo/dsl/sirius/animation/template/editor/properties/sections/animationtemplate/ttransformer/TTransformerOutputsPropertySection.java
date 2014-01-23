/*******************************************************************************
 * 
 *******************************************************************************/
package fr.obeo.dsl.sirius.animation.template.editor.properties.sections.animationtemplate.ttransformer;

// Start of user code imports

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage;
import fr.obeo.dsl.viewpoint.editor.properties.sections.common.AbstractEditorDialogPropertySection;

// End of user code imports

/**
 * A section for the outputs property of a TTransformer object.
 */
public class TTransformerOutputsPropertySection extends AbstractEditorDialogPropertySection {
	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractEditorDialogPropertySection#getDefaultLabelText()
	 */
	protected String getDefaultLabelText() {
	    return "Outputs"; //$NON-NLS-1$
	}
	
	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractEditorDialogPropertySection#getLabelText()
	 */
	protected String getLabelText() {
		String labelText;
		labelText = super.getLabelText() + ":"; //$NON-NLS-1$
		// Start of user code get label text
	    
	    // End of user code get label text
	    return labelText;
	}
	
	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractEditorDialogPropertySection#getFeature()
	 */
	protected EReference getFeature() {
		return AnimationtemplatePackage.eINSTANCE.getTTransformer_Outputs();
	}

	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractEditorDialogPropertySection#getFeatureAsText()
	 */
	protected String getFeatureAsText() {
		String string = new String();
		
		if (eObject.eGet(getFeature()) != null) {
			List<?> values = (List<?>)eObject.eGet(getFeature());
			for (Iterator<?> iterator = values.iterator(); iterator.hasNext(); ) {
				EObject eObj = (EObject)iterator.next();
				string += getAdapterFactoryLabelProvider(eObj).getText(eObj);
				if (iterator.hasNext())
					string += ", ";
			}
		}
		
		return string;
	}

	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractEditorDialogPropertySection#isEqual(java.util.List)
	 */
	protected boolean isEqual(List<?> newList) {
		return newList.equals(eObject.eGet(getFeature()));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
	    super.createControls(parent, tabbedPropertySheetPage);	  	    
	    // Start of user code create controls
	    
	    // End of user code create controls	    
	}
	
	// Start of user code user operations
	
	// End of user code user operations
}