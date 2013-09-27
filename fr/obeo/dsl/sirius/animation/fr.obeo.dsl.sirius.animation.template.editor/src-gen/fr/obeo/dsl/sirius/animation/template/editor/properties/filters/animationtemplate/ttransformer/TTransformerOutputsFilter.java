/*******************************************************************************
 * 
 *******************************************************************************/
package fr.obeo.dsl.sirius.animation.template.editor.properties.filters.animationtemplate.ttransformer;

// Start of user code specific imports

import org.eclipse.emf.ecore.EStructuralFeature;

import fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage;
import fr.obeo.dsl.viewpoint.editor.properties.filters.common.ViewpointPropertyFilter;

// End of user code specific imports


/**
 * A filter for the outputs property section.
 */
public class TTransformerOutputsFilter extends ViewpointPropertyFilter {

	/**
	 * {@inheritDoc}
	 */
	protected EStructuralFeature getFeature() {
		return AnimationtemplatePackage.eINSTANCE.getTTransformer_Outputs();
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected boolean isRightInputType(Object arg0) {
        return arg0 instanceof fr.obeo.dsl.sirius.animationtemplate.TTransformer;
    }
	
	// Start of user code user methods

    // End of user code user methods
	
	

}