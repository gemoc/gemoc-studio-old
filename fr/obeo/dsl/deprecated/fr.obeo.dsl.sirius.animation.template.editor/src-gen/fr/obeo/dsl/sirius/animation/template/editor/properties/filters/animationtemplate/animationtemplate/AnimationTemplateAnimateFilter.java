/*******************************************************************************
 * 
 *******************************************************************************/
package fr.obeo.dsl.sirius.animation.template.editor.properties.filters.animationtemplate.animationtemplate;

// Start of user code specific imports

import org.eclipse.emf.ecore.EStructuralFeature;

import fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage;
import fr.obeo.dsl.viewpoint.editor.properties.filters.common.ViewpointPropertyFilter;

// End of user code specific imports


/**
 * A filter for the animate property section.
 */
public class AnimationTemplateAnimateFilter extends ViewpointPropertyFilter {

	/**
	 * {@inheritDoc}
	 */
	protected EStructuralFeature getFeature() {
		return AnimationtemplatePackage.eINSTANCE.getAnimationTemplate_Animate();
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected boolean isRightInputType(Object arg0) {
        return arg0 instanceof fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate;
    }
	
	// Start of user code user methods

    // End of user code user methods
	
	

}