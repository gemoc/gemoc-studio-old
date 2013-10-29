package org.gemoc.gemoc_language_workbench.api.utils;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Class in charge of making sure the model is loaded correctly.
 * 
 * @author flatombe
 * 
 */
public interface ModelLoader {

	/**
	 * Loads the model with the correct Factories etc... Provided by the
	 * end-user in the xDSML project configuration file.
	 * 
	 * @param modelFileUri
	 *            the URI of the file of the model to load.
	 * @return the Resource corresponding to the given URI.
	 */
	public Resource loadModel(String modelFileUri);
}
