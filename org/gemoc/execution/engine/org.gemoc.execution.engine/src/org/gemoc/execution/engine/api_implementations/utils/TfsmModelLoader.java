package org.gemoc.execution.engine.api_implementations.utils;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import tfsm.TfsmPackage;
import tfsm.System;
import tfsm.impl.TfsmFactoryImpl;

public class TfsmModelLoader implements ModelLoader {

	@Override
	public Resource loadModel(String modelFileUri) {
//		// Initialize the model
//		TfsmPackage.eINSTANCE.eClass();
//
//		// Register the XMI resource factory for the .website extension
//
//		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
//		Map<String, Object> m = reg.getExtensionToFactoryMap();
//		m.put("tfsm", new TfsmFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resSet.getResource(URI.createURI(modelFileUri), true);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		System system = (System) resource.getContents().get(0);
		return system.eResource();
	}

}
