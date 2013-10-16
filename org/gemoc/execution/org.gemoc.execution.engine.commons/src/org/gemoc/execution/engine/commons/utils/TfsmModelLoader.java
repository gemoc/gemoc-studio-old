package org.gemoc.execution.engine.commons.utils;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

public class TfsmModelLoader implements ModelLoader {

	@Override
	public Resource loadModel(String modelFileUri) {
		Resource result = null;
		System.out.println("[TfsmModelLoader] loading model from uri "
				+ modelFileUri);
		if (modelFileUri.endsWith(".xmi") || modelFileUri.endsWith(".tfsm")) {
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("xmi",
					new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
			m.put("tfsm",
					new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
			// Obtain a new resource set
			ResourceSet resSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
			// Create the resource
			result = resSet.getResource(URI.createURI(modelFileUri), true);
		}

		return result;
	}

}
