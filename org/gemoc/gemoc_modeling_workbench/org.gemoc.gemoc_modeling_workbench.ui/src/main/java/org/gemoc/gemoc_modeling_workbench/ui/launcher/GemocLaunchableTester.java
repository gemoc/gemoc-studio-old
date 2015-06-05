
package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * Property tester for context launching menu.
 */
public class GemocLaunchableTester extends PropertyTester {

	/**
	 * name for the "is model" property
	 */
	private static final String PROPERTY_IS_MODEL = "isModel"; //$NON-NLS-1$
	
	
	
	
	/**
	 * Method runs the tests defined from extension points for Run As... and Debug As... menu items.
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 * @since 3.2
	 * @return true if the specified tests pass, false otherwise
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if(PROPERTY_IS_MODEL.equals(property)) {
			if (receiver instanceof IAdaptable) {
				IFile modelFile = (IFile)((IAdaptable)receiver).getAdapter(IFile.class);
				if(modelFile !=null){
					ResourceSet rs = new ResourceSetImpl();
					URI modelURI = URI.createURI("platform:/resource/"+modelFile.getFullPath().toString());
					try{
						Resource resource = rs.getResource(modelURI, true);
					if (resource != null) {
						return true;
					}
					} catch (Exception e){
						// not a valid model, simply ignore
						return false;
					}
				}
			}
			return false;
		}
		
		return false;
	}
	
}
