package org.gemoc.gemoc_language_workbench.ui.api;

import org.eclipse.emf.ecore.resource.Resource;

public interface IXDSMLModelLoader {
	public Resource loadModel(String modelFileUri);

}
