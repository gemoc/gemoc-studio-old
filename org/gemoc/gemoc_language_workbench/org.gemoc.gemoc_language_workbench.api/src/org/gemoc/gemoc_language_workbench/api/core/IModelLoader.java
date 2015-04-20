package org.gemoc.gemoc_language_workbench.api.core;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Class in charge of making sure the model is loaded correctly.
 * 
 * @author flatombe
 * 
 */
public interface IModelLoader {

	Resource loadModel(IExecutionContext context);
	Resource loadModelForAnimation(IExecutionContext context);

}
