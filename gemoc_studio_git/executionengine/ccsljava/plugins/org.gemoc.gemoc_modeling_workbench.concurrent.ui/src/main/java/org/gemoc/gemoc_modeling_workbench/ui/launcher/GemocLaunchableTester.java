
package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.commons.eclipse.emf.EMFResource;
import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtensionPoint;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;

/**
 * Property tester for context launching menu.
 * 
 * Note: this PropertyTester seems to be fully activated only when the containing plugin is started
 */
public class GemocLaunchableTester extends PropertyTester {

	/**
	 * name for the "is model" property
	 */
	private static final String PROPERTY_IS_MODEL = "isModel"; //$NON-NLS-1$
	
	/**
	 * name for the "is executable domain specific model" property
	 */
	private static final String PROPERTY_IS_EXECUTABLE_DOMAIN_SPECIFIC_MODEL = "isExecutableDomainSpecificModel"; //$NON-NLS-1$
	
	
	protected boolean isModel(IAdaptable receiver){
		IFile modelFile = (IFile)(receiver).getAdapter(IFile.class);
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
		return false;
	}
	
	protected boolean isExecutableDomainSpecificModel(IAdaptable receiver){
		IFile modelFile = (IFile)(receiver).getAdapter(IFile.class);
		if(modelFile !=null){
			
			return existsDSMLWithFileExtension(modelFile.getFileExtension());
		}
		return false;
	}
	
	
	protected boolean existsDSMLWithFileExtension(String fileExtension){
		for(ConcurrentLanguageDefinitionExtension lde : ConcurrentLanguageDefinitionExtensionPoint.getSpecifications()){
			try{
				String xdsmluri = lde.getXDSMLFilePath();
				if (!xdsmluri.startsWith("platform:/plugin"))
					xdsmluri = "platform:/plugin" + xdsmluri;
				Object o = EMFResource.getFirstContent(xdsmluri);
				if(o != null && o instanceof LanguageDefinition){
					LanguageDefinition ld = (LanguageDefinition)o;
					if(ld.getFileExtensions().contains(fileExtension)){
						return true;
					}
				}
			}
			catch(Exception e){}
		}
		
		
		return false;
	}
	
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
				return isModel((IAdaptable)receiver);
			}
			return false;
		}
		if(PROPERTY_IS_EXECUTABLE_DOMAIN_SPECIFIC_MODEL.equals(property)) {
			if (receiver instanceof IAdaptable) {
				return isExecutableDomainSpecificModel((IAdaptable)receiver);
			}
			return false;
		}
		return false;
	}
	
}
