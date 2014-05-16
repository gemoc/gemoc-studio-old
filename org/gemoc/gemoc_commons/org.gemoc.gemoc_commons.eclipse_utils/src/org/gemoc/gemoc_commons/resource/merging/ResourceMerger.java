package org.gemoc.gemoc_commons.resource.merging;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ResourceMerger {

	private IFile _inputFile;
	
	protected ResourceMerger(IFile inputFile) {
		_inputFile = inputFile;
	}

	public void mergeInto(IFile outputFile) throws IOException {
		EList<Resource> resources = getResources(outputFile);
		URI outputURI = URI.createPlatformResourceURI(outputFile.getFullPath().toString(), true);
		merge(resources, outputURI);
	}

	private EList<Resource> getResources(IFile outputFile) {
		ResourceSet rs = new ResourceSetImpl();
		URI inputURI = URI.createPlatformResourceURI(_inputFile.getFullPath().toString(), true);
		Resource r = rs.getResource(inputURI, true);
		EcoreUtil.resolveAll(r); // result in the load of several resources
		return rs.getResources();
	}

	private void merge(EList<Resource> resources, URI outputURI) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource uniqueResource = rs.createResource(outputURI);
		for(Resource r : resources) 
		{
			uniqueResource.getContents().addAll(r.getContents());
		}
		uniqueResource.save(null);
	}

}
