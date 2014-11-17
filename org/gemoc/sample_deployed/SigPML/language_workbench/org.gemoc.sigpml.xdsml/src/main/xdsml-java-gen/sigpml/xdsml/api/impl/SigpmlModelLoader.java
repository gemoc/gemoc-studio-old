/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */
package sigpml.xdsml.api.impl;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
public class SigpmlModelLoader implements IModelLoader {
	public Resource loadModel(String modelFileUri) {
		Resource result = null;
		System.out.println("[SigpmlModelLoader] loading model from uri "+modelFileUri);
		if(modelFileUri.endsWith(".xmi") || modelFileUri.endsWith(".SigPML") || modelFileUri.endsWith(".sigpml") ){
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put("xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		    m.put("SigPML", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		    m.put("sigpml", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		    // Obtain a new resource set
		    ResourceSet resSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		    // Create the resource
		    result = resSet.getResource(URI.createURI(modelFileUri), true);
		}

		return result;
	}
}