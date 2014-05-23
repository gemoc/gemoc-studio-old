package org.gemoc.gemoc_commons.resource.merging;

import org.eclipse.emf.ecore.resource.Resource;

public class ActionContext {

	private Resource _resource;
	
	public ActionContext(Resource resource) {
		_resource = resource;
	}

	public Resource getResource() 
	{
		return _resource;
	}
	
}
