package org.gemoc.gemoc_language_workbench.api.moc;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Service provided by the DSE language (Mapping Language) that is able to
 * instanciate the DSE Mapping to a Model instance. For example, using CCSL/ECL
 * technologies, it is able to provide the ExtendedCCSL file (Model of
 * Execution).
 * 
 * @author flatombe
 * 
 */
public interface ModelOfExecutionBuilder {

	/**
	 * 
	 * @param modelResource
	 * @return
	 */
	public Resource build(Resource domainSpecificEventsResource, Resource modelResource);
}
