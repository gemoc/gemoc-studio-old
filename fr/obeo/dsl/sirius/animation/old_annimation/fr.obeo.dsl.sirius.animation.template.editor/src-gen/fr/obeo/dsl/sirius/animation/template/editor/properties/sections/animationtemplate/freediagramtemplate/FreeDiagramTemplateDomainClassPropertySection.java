/*******************************************************************************
 * 
 *******************************************************************************/
package fr.obeo.dsl.sirius.animation.template.editor.properties.sections.animationtemplate.freediagramtemplate;

// Start of user code imports

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage;
import fr.obeo.dsl.viewpoint.editor.editorPlugin.ViewpointEditor;
import fr.obeo.dsl.viewpoint.editor.properties.sections.common.AbstractComboPropertySection;

// End of user code imports

/**
 * A section for the domainClass property of a FreeDiagramTemplate object.
 */
public class FreeDiagramTemplateDomainClassPropertySection extends AbstractComboPropertySection {
	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractComboPropertySection#getDefaultLabelText()
	 */
	protected String getDefaultLabelText() {
	    return "DomainClass"; //$NON-NLS-1$
	}
	
	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractComboPropertySection#getLabelText()
	 */
	protected String getLabelText() {
		String labelText;
	    labelText = super.getLabelText() + "*:"; //$NON-NLS-1$
		// Start of user code get label text
	    
	    // End of user code get label text
	    return labelText;
	}
	
	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractComboPropertySection#getFeature()
	 */
	protected EReference getFeature() {
		return AnimationtemplatePackage.eINSTANCE.getFreeDiagramTemplate_DomainClass();
	}

	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractComboPropertySection#getFeatureValue(int)
	 */
	protected Object getFeatureValue(int index) {
		return getFeatureValueAt(index);
	}

	/**
	 * @see fr.obeo.dsl.sirius.animation.template.editor.properties.sections.AbstractComboPropertySection#isEqual(int)
	 */
	protected boolean isEqual(int index) {
		boolean isEqual = false;
		if (getFeatureValueAt(index) == null)
			isEqual = eObject.eGet(getFeature()) == null;
		else
			isEqual = getFeatureValueAt(index).equals(eObject.eGet(getFeature()));
		return isEqual;
	}
	
	/**
	 * Returns the value at the specified index in the choice of values for the
	 * feature.
	 * 
	 * @param index
	 * 			Index of the value.
	 * @return
	 * 			the value at the specified index in the choice of values.
	 */
	protected Object getFeatureValueAt(int index) {
		List<?> values = getChoiceOfValues();
		if (values.size() < index || values.size() == 0 || index == -1) {
            return null;
        }
		return values.get(index);
	}

	/**
	 * Fetches the list of available values for the feature.
	 * 
	 * @return
	 * 			The list of available values for the feature.
	 */
	protected List<?> getChoiceOfValues() {
		List<?> values = Collections.emptyList();
		List<IItemPropertyDescriptor> propertyDescriptors = getDescriptors();
	    for (Iterator<IItemPropertyDescriptor> iterator = propertyDescriptors.iterator(); iterator.hasNext(); ) {
	    	IItemPropertyDescriptor propertyDescriptor = (IItemPropertyDescriptor)iterator.next();
	    	if (((EStructuralFeature)propertyDescriptor.getFeature(eObject)) == getFeature())
	    		values = new ArrayList<Object>(propertyDescriptor.getChoiceOfValues(eObject));
	    } 		
	    // Start of user code choice of values
	    // End of user code choice of values
		return values;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
	    super.createControls(parent, tabbedPropertySheetPage);	  	    
	     nameLabel.setFont(ViewpointEditor.getFontRegistry().get("required"));
	    // Start of user code create controls
	    
	    // End of user code create controls	    
	}		
	// Start of user code user operations
	
	// End of user code user operations
}