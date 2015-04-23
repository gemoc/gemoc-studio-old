package org.gemoc.gemoc_language_workbench.api.core;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Class in charge of making sure the model is loaded correctly.
 * 
 * @author flatombe
 * 
 */
public interface IModelLoader {

	/** load Model when running in normal mode */
	Resource loadModel(IExecutionContext context);
	/** load model when running in animation mode */
	Resource loadModelForAnimation(IExecutionContext context);

}
