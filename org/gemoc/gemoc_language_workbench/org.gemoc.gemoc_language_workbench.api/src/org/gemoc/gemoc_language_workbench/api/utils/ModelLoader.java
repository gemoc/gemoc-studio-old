package org.gemoc.gemoc_language_workbench.api.utils;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Tool in charge of making sure the model is loaded correctly.
 * 
 * @author flatombe
 * 
 */
public interface ModelLoader {

	/**
	 * Loads the model with the correct Factories etc...
	 * 
	 * @param modelFileUri
	 * @return the Resource corresponding to the given URI.
	 */
	public Resource loadModel(String modelFileUri);
}
